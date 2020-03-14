
package main.java;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ssystem
 */

public class Cart {
   
  int ln , lnCart;
    File f = new File("E:\\SinUp files\\RAPIDCLICKS");
    File f2 = new File("E:\\SinUp files\\CART");
    private Model pm;   
    private CartModel cart;   
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
 
   
       

    public Cart(int c,String user,String email) {
        
        
       ReadFile();
       if(c>-1){
      new addCart(this.pm.getProduct(c).getcode(),email);
       }
      
        this.cart =new CartModel();
      
            lnCart=1;
            RandomAccessFile ref = null;
        try {
            ref = new RandomAccessFile(f2+"\\Cart_"+email,"rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i=0; ref.readLine() !=null ;i++){
                lnCart++;
            }
        } catch (IOException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
          
                
    
      
      BufferedReader reader = null;
       try {
            reader = new BufferedReader(new FileReader(f2+"\\Cart_"+email+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
     
         for (int i=0;i<lnCart;i+=3){
           try {
               while(reader.readLine() != null){
                  
                   String code = reader.readLine().substring(12);
                   
                   for(int j=0;j<this.pm.count();j++){
                       String CodeProduct = String.valueOf(this.pm.getProduct(j).getcode());
                       if(code.equals(CodeProduct)){
                           String name = this.pm.getProduct(j).getName();
                           Float price = this.pm.getProduct(j).getPrice();
                           String image = this.pm.getProduct(j).getImage();
                          
                           CartObject product = new CartObject(name,price,image);
                           this.cart.addProduct(product);
                       }
                       
                   }
               }  } catch (IOException ex) {
               Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
           }
                             
         }
      

    JFrame f = new JFrame("Cart");
     JLabel l3=new JLabel(" User Cart");
    l3.setBounds(400,15,150,20);
    l3.setForeground(Color.white);
    f.add(l3);
    
    
    JLabel l5=new JLabel(user + " Welcom to your Acount Cart");
    l5.setBounds(35,110,300,20);
     l5.setForeground(Color.white);
    f.add(l5);
    
      
    JPanel pane5=new JPanel();  
    pane5.setBounds(0,110,300,20);    
    pane5.setBackground(Color.decode("#0C9463"));  
    f.add(pane5);
    
    
int j = 210;
int t = 20;   
for(int i=0;i<this.cart.count();i++){
     if (t>800){
        j += 300;
        t=20;
    }
     JPanel panel=new JPanel();  
    panel.setBounds(18+t,130+j,230,30);  
    panel.setBackground(Color.CYAN);  
    
    JLabel image4=new JLabel("");
    image4.setIcon(new ImageIcon(this.cart.getProduct(i).getImage()));
    image4.setBounds(18+t, j-75, 230, 200);
    Border border = BorderFactory.createLineBorder(Color.WHITE, 2);        
    image4.setBorder(border);
    f.add(image4);
    
   JLabel l1=new JLabel(""+this.cart.getProduct(i).getName());
    
    panel.add(l1);

    
    JLabel l6=new JLabel("  $"+this.cart.getProduct(i).getPrice());   
    l6.setForeground(Color.decode("#F67280"));
    panel.add(l6);
    
   
  
    t +=300;
    f.add(panel);
}

      
       JButton factor=new JButton("Factor");    
factor.setBounds(760,60,100, 27);
factor.setBackground(Color.decode("#0C9463"));
factor.setForeground(Color.WHITE);
factor.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new Factor(-1,user,email);
       
        f.dispose();
    }  
});
f.add(factor);

     
       
       JButton p2=new JButton("Back");    
p2.setBounds(20,60,100, 27);
p2.setBackground(Color.decode("#F67280"));
p2.setForeground(Color.WHITE);
p2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new shop3(user,email);
       
        f.dispose();
    }  
});
f.add(p2);
       
       
       
       
       JPanel pane4=new JPanel();  
pane4.setBounds(0,0,900,50);    
pane4.setBackground(Color.getHSBColor(50, 800, 150));  

JPanel pane3=new JPanel();  
pane3.setBounds(0,100,900,800);    
pane3.setBackground(Color.white);  

JPanel pane2=new JPanel();  
pane2.setBounds(0,50,900,50);    
pane2.setBackground(Color.decode("#C06C84"));  
f.add(pane4);f.add(pane2);f.add(pane3);
f.setSize(900,800);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
        
    }

    private static class addCart {
        
      File f3 = new File("E:\\SinUp files\\CART");
      int ln;
     

        public addCart(int code,String email) {
       
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
            
            try {
            ln=1;
            RandomAccessFile ref = new RandomAccessFile(f3+"\\Cart_"+email+".txt","rw");
            for (int i=0; ref.readLine() !=null ;i++){
                ln++;
            }
            System.out.println("number line"+ln);
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             try {
            RandomAccessFile ref = new RandomAccessFile(f3+"\\Cart_"+email+".txt","rw");
            for (int i=0;i<ln;i++){
                ref.readLine();
            }
            ref.writeBytes("\r\n");
            ref.writeBytes("ProductCode:" +code + "\r\n");
            
           
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    }
}
