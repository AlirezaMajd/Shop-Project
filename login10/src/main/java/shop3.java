package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.Border;



/**
 *
 * @author Ssystem
 */
public class shop3{ 
    int ln;
    File f = new File("E:\\SinUp files\\RAPIDCLICKS");
    private Model pm;
   
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
shop3(String user,String email){    
    

 ReadFile();
 new CreateCart(email);
            
JFrame f=new JFrame("User-page");
int j = 210;
int t = 26;

 JLabel page2=new JLabel("");
    page2.setBounds(80,0,1000, 100);
    page2.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src/shop.png"));
    f.add(page2);


    
    JLabel page=new JLabel("");
    page.setBounds(0, 0, 1300, 750);
    page.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src/c.jpeg"));
    f.add(page);
    
     JLabel page1=new JLabel("");
    page1.setBounds(300,0,1000, 750);
    page1.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src/c.jpeg"));
    f.add(page1);


for(int i=0;i<this.pm.count();i++){
     if (t>1100){
        j += 300;
        t=26;
    }
     
         JPanel Rpanel=new JPanel();  
    Rpanel.setBounds(47+t,j-75,65,30);  
    
    Rpanel.setBackground(Color.CYAN);
    page.add(Rpanel);
    
     JLabel Reduction=new JLabel(" %"+this.pm.getProduct(i).getReduction());  
    Reduction.setForeground(Color.white);
    Reduction.setFont(new Font("Verdana", Font.PLAIN, 15));
    Rpanel.add(Reduction);
     
    
    JLabel image=new JLabel("");
    image.setIcon(new ImageIcon(this.pm.getProduct(i).getImage()));
    image.setBounds(47+t, j-75, 230, 200);
    Border border = BorderFactory.createLineBorder(Color.WHITE, 2);        
    image.setBorder(border);
    page.add(image);

    JButton b=new JButton("Detail");
    b.setBackground(Color.WHITE);
    b.setBounds(47+t,130+j,230,30); 
    b.setForeground(Color.red);
    int c = i;
   
    b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
          new Detail(c,user,email);
          f.dispose();
    }  
}); 
    page.add(b);
    
 
    t +=300;
}

 


JButton goCart=new JButton("cart");    
goCart.setBounds(1000,50,100, 27);
goCart.setBackground(Color.decode("#0C9463"));
goCart.setForeground(Color.WHITE);

goCart.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new Cart(-1,user,email);
       
        f.dispose();
    }  
});
page.add(goCart);



JButton goBack=new JButton("Exit");    
goBack.setBounds(1130,50,100, 27);
goBack.setBackground(Color.decode("#0C9463"));
goBack.setForeground(Color.WHITE);

goBack.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new shop1();
       
        f.dispose();
    }  
});
page.add(goBack);


 
    




f.setSize(1300,750);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
}   

    private static class RemoveAll {
        int ln;
        File f = new File("E:\\SinUp files\\RAPIDCLICKS");
        public RemoveAll() {
            RandomAccessFile ref = null;
            try {
                ref = new RandomAccessFile(f+"\\product.txt","rw");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             shop1 rf = new shop1();                                   
    }     
  }

    private static class CreateCart {

        File f3 = new File("E:\\SinUp files\\CART");
     
      void createFolder(){
        if(!f3.exists()){
            f3.mkdirs();
        }
      }
        public CreateCart(String email) {
            
            createFolder();
            try {
            FileReader fr = new FileReader(f3+"\\Cart_"+email+".txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f3+"\\Cart_"+email+".txt");
                System.out.println("file created");
            } catch (IOException ex1) {
                Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        }
    }
}