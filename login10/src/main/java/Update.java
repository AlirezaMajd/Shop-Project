/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ssystem
 */
public class Update {
   
private Model pm;
File f = new File("E:\\SinUp files\\RAPIDCLICKS");
int ln;
String Name , Detail , Price;
String name;
 
  
   
void ReadFile(){
    
       
        this.pm =new Model();
      
            ln=1;
            RandomAccessFile ref = null;
        try {
            ref = new RandomAccessFile(f+"\\product.txt","rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i=0; ref.readLine() !=null ;i++){
                ln++;
            }
        } catch (IOException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("number line"+ln);
                
    
    
    BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader(f+"\\product.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            for (int i=0;i<ln;i+=10){
             
           try {
               while(reader.readLine() != null){
                  
                   String name = reader.readLine().substring(5);
                   String detail = reader.readLine().substring(7);
                   String sprice = reader.readLine().substring(6);
                   String code = reader.readLine().substring(5);
                   String number = reader.readLine().substring(7);
                   String title = reader.readLine().substring(6);
                   String address = reader.readLine().substring(8);
                   String image = reader.readLine().substring(4);
                   int Number = Integer.parseInt(number);
                   
                   int pcode = Integer.parseInt(code);
                   float price = Float.parseFloat(sprice);
                   Product p = new Product(Number,pcode,name,title,price,detail,address,image);
                   this.pm.addProduct(p); 
               }  } catch (IOException ex) {
               Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
           }
                             
}
       
       
       
}





    
    public Update(int i){

    ReadFile();   
    JFrame f = new JFrame("AdminPage");
    JLabel l3=new JLabel("UPDATE PRODUCT");
    l3.setBounds(400,15,150,20);
    l3.setForeground(Color.white);
    f.add(l3);
   


   
       JButton p2=new JButton("Exit");    
p2.setBounds(20,60,90, 27);
p2.setBackground(Color.decode("#F67280"));
p2.setForeground(Color.WHITE);
p2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new AdminShop();
       
        f.dispose();
    }  
});
f.add(p2);
       
       
    JLabel Name=new JLabel("Product Name:");
    Name.setBounds(100, 150, 100, 25);
    Name.setForeground(Color.WHITE);
    f.add(Name);
   
    
    
    
   JTextField  name=new JTextField(this.pm.getProduct(i).getName());    
    name.setBounds(200, 150, 200, 25);
     f.add(name);
     
     JLabel title=new JLabel("Title:");
    title.setBounds(129, 200, 100, 25);
    title.setForeground(Color.WHITE);
    f.add(title);
     
     JTextField  Title=new JTextField(this.pm.getProduct(i).getReduction());    
    Title.setBounds(200, 200, 200, 25);
     f.add(Title);
     
     JLabel price=new JLabel("Price:");
    price.setBounds(120, 250, 100, 25);
    price.setForeground(Color.WHITE);
    f.add(price);
     
    JTextField  Price=new JTextField(String.valueOf(this.pm.getProduct(i).getPrice()));    
    Price.setBounds(200, 250, 200, 25);
     f.add(Price);
     
     JLabel number=new JLabel("Number:");
    number.setBounds(120, 300, 100, 25);
    number.setForeground(Color.WHITE);
    f.add(number);
    
    JTextField  Number=new JTextField(String.valueOf(this.pm.getProduct(i).getNumber()));    
    Number.setBounds(200, 300, 200, 25);
    f.add(Number);
     
     JLabel details=new JLabel("Details:");
    details.setBounds(120, 350, 100, 25);
    details.setForeground(Color.WHITE);
    f.add(details);
   
     JTextField  Details=new JTextField(this.pm.getProduct(i).getDtail());    
    Details.setBounds(200, 350, 200, 60);
     f.add(Details);

     JLabel address=new JLabel("Address:");
    address.setBounds(122, 450, 100, 25);
    address.setForeground(Color.WHITE);
    f.add(address);
     
     JTextField  Address=new JTextField(this.pm.getProduct(i).getAddress());    
    Address.setBounds(200, 450, 200, 60);
     f.add(Address);
     
    
     
    
     
     
     
       JLabel image=new JLabel("Product Picture:");
    image.setBounds(580, 150, 100, 25);
    image.setForeground(Color.WHITE);
    f.add(image);
    
    
    JLabel  Image=new JLabel("");     
     Image.setIcon(new ImageIcon(this.pm.getProduct(i).getImage()));
    Image.setBounds(500, 170, 230, 200);
    Border border = BorderFactory.createLineBorder(Color.WHITE, 3);    
    Image.setBorder(border);
    f.add(Image);
     
    JTextField  upload=new JTextField("");    
    upload.setBounds(500, 380, 280, 30);
   
     
    JButton p1=new JButton("Choose Image");    
p1.setBounds(560,410,150, 27);
p1.setBackground(Color.decode("#F67280"));
p1.setForeground(Color.WHITE);
p1.addActionListener(new ActionListener(){
    
    public void actionPerformed(ActionEvent e){
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter=new FileNameExtensionFilter(".images", "jpg","png");
        file.addChoosableFileFilter(filter);
        
        
        int result=file.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path=selectedFile.getAbsolutePath();
            upload.setText(path);
            Image.setIcon(new ImageIcon(path));
        }
        else
        {
            System.out.println("No File Selected");
        }
    }
});
   

f.add(p1);

     
     
       JButton add=new JButton("Update Product");    
add.setBounds(560,480,150, 27);
add.setBackground(Color.decode("#F67280"));
add.setForeground(Color.WHITE);
int c = (Integer)i;
//String code  = String.valueOf(this.pm.getProduct(i).getcode());
add.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
   // new update(c);
   // System.out.print(name.getText());
//    new UpdateProduct(code);
//    new AdminShop();
//    f.dispose();
    
    }  
}); 
f.add(add);
     
     
     
     
     
       JPanel pane4=new JPanel();  
pane4.setBounds(0,0,900,50);    
pane4.setBackground(Color.getHSBColor(50, 800, 150));  


JPanel pane3=new JPanel();  
pane3.setBounds(0,100,900,500);    
pane3.setBackground(Color.decode("#6C5B7B"));  

JPanel pane2=new JPanel();  
pane2.setBounds(0,50,900,50);    
pane2.setBackground(Color.decode("#C06C84"));  
f.add(pane4);f.add(pane2);f.add(pane3);
f.setSize(900,600);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
        
    }

    private static class UpdateProduct {
    private Model pm;
File f = new File("E:\\SinUp files\\RAPIDCLICKS");
int ln;         
        public UpdateProduct(String code) {
        
          
            ln=1;
            RandomAccessFile ref = null;
        try {
            ref = new RandomAccessFile(f+"\\product.txt","rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i=0; ref.readLine() !=null ;i++){
                ln++;
            }
        } catch (IOException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
           
                
    
        BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader(f+"\\product.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
         code = String.valueOf(code);
            for (int i=0;i<ln;i+=9){
             
           try {
               while(reader.readLine() != null){
                  
                   String name = reader.readLine().substring(5);
                   String detail = reader.readLine().substring(7);
                   String sprice = reader.readLine().substring(6);
                   String coding = reader.readLine().substring(5);
                   String number = reader.readLine().substring(7);
                   String title = reader.readLine().substring(6);
                   String address = reader.readLine().substring(8);
                   
                   if(coding.equals(code)){
                      
                   }
                   
                   
     
               }  } catch (IOException ex) {
               Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
           }
                             
}
         
         
            
            
        }
    }

    private static class update {
        private Model pm;
File f = new File("E:\\SinUp files\\RAPIDCLICKS");
int ln;

  
   
void ReadFile(){
    
       
        this.pm =new Model();
      
            ln=1;
            RandomAccessFile ref = null;
        try {
            ref = new RandomAccessFile(f+"\\product.txt","rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i=0; ref.readLine() !=null ;i++){
                ln++;
            }
        } catch (IOException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("number line"+ln);
                
    
    
    BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader(f+"\\product.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            for (int i=0;i<ln;i+=10){
             
           try {
               while(reader.readLine() != null){
                  
                   String name = reader.readLine().substring(5);
                   String detail = reader.readLine().substring(7);
                   String sprice = reader.readLine().substring(6);
                   String code = reader.readLine().substring(5);
                   String number = reader.readLine().substring(7);
                   String title = reader.readLine().substring(6);
                   String address = reader.readLine().substring(8);
                   String image = reader.readLine().substring(4);
                   int Number = Integer.parseInt(number);
                   
                   int pcode = Integer.parseInt(code);
                   float price = Float.parseFloat(sprice);
                   Product p = new Product(Number,pcode,name,title,price,detail,address,image);
                   this.pm.addProduct(p); 
               }  } catch (IOException ex) {
               Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
           }
                             
}
       
       
       
}






        public update(int i) {
            ReadFile();
           
        }
    }
}
   

