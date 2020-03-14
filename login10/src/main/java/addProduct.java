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
public class addProduct {
   
private Model pm;
File f = new File("E:\\SinUp files\\RAPIDCLICKS");
int ln;
File f2 = new File("E:\\SinUp files\\BTREE");

  void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
        
    }
  
    void countLines(){
        try {
            ln=1;
            RandomAccessFile ref = new RandomAccessFile(f+"\\product.txt","rw");
            for (int i=0; ref.readLine() !=null ;i++){
                ln++;
            }
            System.out.println("number line"+ln);
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       


  private static int getRandomNumberInRange(int min, int max) {

		

		Random r = new Random();
		return r.nextInt(((max - min) + 1) + min);
	}

 int code =  getRandomNumberInRange(100000000,999999999);
       
  void addData(String Name,String Reduction,String Detail , String Price , String number,String address, String image){
        try {
            RandomAccessFile ref = new RandomAccessFile(f+"\\product.txt","rw");
            for (int i=0;i<ln;i++){
                ref.readLine();
            }
            
            int PriceR = Integer.parseInt(Price);
            int Reduc = Integer.parseInt(Reduction);
            int price = PriceR - (1-(Reduc/100));
           
            ref.writeBytes("\r\n");
            ref.writeBytes("Name:"+Name + "\r\n");            
            ref.writeBytes("Detail:"+Detail + "\r\n");
            ref.writeBytes("Price:"+price + "\r\n");
            ref.writeBytes("Code:"+code + "\r\n");
            ref.writeBytes("Number:"+number + "\r\n");
            ref.writeBytes("Title:"+Reduction + "\r\n");
            ref.writeBytes("Address:"+address + "\r\n");
            ref.writeBytes("Url:"+image + "\r\n");
            
            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     */
  
   void CreateProductArray(){
         BufferedReader reader;
        try {
        

            reader = new BufferedReader(new FileReader(f+"\\product.txt"));
         
            for (int i=0;i<ln;i+=10){
             
                while(reader.readLine() != null){
                     
                     String name = reader.readLine().substring(5);
                     String detail = reader.readLine().substring(7);
                     String sprice = reader.readLine().substring(6);
                     String code = reader.readLine().substring(5);
                     String number = reader.readLine().substring(7);
                     String title = reader.readLine().substring(6);
                     String address = reader.readLine().substring(8);
                     String image = reader.readLine().substring(4);
                     
                     int Code = Integer.parseInt(code);
                     int Number = Integer.parseInt(number);
                     float price = Float.parseFloat(sprice);
                    Product p = new Product(Number,Code,name,title,price,detail,address,image);

                   
                    this.pm.addProduct(p);
                   
                   
                   
        } 
                             
    }
             } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
}    
   
   
   
   
   
  

   
  void createFolder2(){
        if(!f2.exists()){
            f2.mkdirs();
        }
        
    }     
  void addBtree(String Name,String Reduction,String Detail , String Price , String number,String address, String image){
        try {
            RandomAccessFile ref = new RandomAccessFile(f2+"\\"+code+".txt","rw");
            for (int i=0;i<ln;i++){
                ref.readLine();
            }
            
            int PriceR = Integer.parseInt(Price);
            int Reduc = Integer.parseInt(Reduction);
            int price = PriceR - (1-(Reduc/100));
           
            ref.writeBytes("\r\n");
            ref.writeBytes("Name:"+Name + "\r\n");            
            ref.writeBytes("Detail:"+Detail + "\r\n");
            ref.writeBytes("Price:"+price + "\r\n");
            ref.writeBytes("Code:"+code + "\r\n");
            ref.writeBytes("Number:"+number + "\r\n");
            ref.writeBytes("Title:"+Reduction + "\r\n");
            ref.writeBytes("Address:"+address + "\r\n");
            ref.writeBytes("Url:"+image + "\r\n");
            
            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
   
   
   
   
   
   
   
   
   
   
    public addProduct(){

     JFrame f = new JFrame("AdminPage");
    JLabel l3=new JLabel("ADD PRODUCT");
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
       
       
    JLabel name=new JLabel("Name:");
    name.setBounds(120, 150, 100, 25);
    name.setForeground(Color.WHITE);
    f.add(name);
   
   JTextField  Name=new JTextField("");    
    Name.setBounds(200, 150, 200, 25);
     f.add(Name);
     
     JLabel title=new JLabel("Reduction:");
    title.setBounds(120, 250, 100, 25);
           
    title.setForeground(Color.WHITE);
    f.add(title);
     
     JTextField  Title=new JTextField("");    
    Title.setBounds(200, 250, 200, 25);
           
     f.add(Title);
     
     JLabel price=new JLabel("Price:");
    price.setBounds(120, 200, 100, 25);
    price.setForeground(Color.WHITE);
    f.add(price);
     
     JTextField  Price=new JTextField("");    
    Price.setBounds(200, 200, 200, 25);
     f.add(Price);
     
     JLabel number=new JLabel("Quantity:");
    number.setBounds(120, 300, 100, 25);
    number.setForeground(Color.WHITE);
    f.add(number);
     
     JTextField  Number=new JTextField("");    
    Number.setBounds(200, 300, 200, 25);
     f.add(Number);
     
     JLabel details=new JLabel("Details:");
    details.setBounds(120, 350, 100, 25);
    details.setForeground(Color.WHITE);
    f.add(details);
     
     JTextField  Details=new JTextField("");    
    Details.setBounds(200, 350, 200, 60);
     f.add(Details);

     JLabel address=new JLabel("Address:");
    address.setBounds(120, 450, 100, 25);
    address.setForeground(Color.WHITE);
    f.add(address);
     
     JTextField  Address=new JTextField("");    
    Address.setBounds(200, 450, 200, 60);
     f.add(Address);
     
    JLabel image=new JLabel("Product Picture:");
    image.setBounds(565, 140, 100, 25);
    image.setForeground(Color.WHITE);
    f.add(image);
    
  
    JLabel  Image=new JLabel("");       
    Image.setBounds(500, 170, 230, 200);
    Border border = BorderFactory.createLineBorder(Color.WHITE, 3);        
    Image.setBorder(border);
    f.add(Image);
     
    JTextField  upload=new JTextField("");    
    upload.setBounds(500, 380, 280, 30);
   
     
    JButton p1=new JButton("Choose Image");    
    p1.setBounds(540,380,150, 27);
    p1.setBackground(Color.getHSBColor(50, 800, 150));
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
 
       JButton add=new JButton("Add Product");    
    add.setBounds(540,480,150, 27);
    add.setBackground(Color.decode("#0C9463"));
    add.setForeground(Color.WHITE);
    add.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
        createFolder();
        createFolder2();
        countLines();
        addData(Name.getText(),Title.getText(),Details.getText(),Price.getText(),Number.getText(),Address.getText(),upload.getText());
        addBtree(Name.getText(),Title.getText(),Details.getText(),Price.getText(),Number.getText(),Address.getText(),upload.getText());
        new AdminShop();
        f.dispose();

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
    public static void main(String[] args){
        new addProduct();
    }
   }