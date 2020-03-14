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

public class Factor {
   
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
 

    public Factor(int c,String user, String email) {
        
        
       ReadFile();
      
      
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
      

    JFrame f = new JFrame("Factor");
    JLabel l3=new JLabel(" FACTOR ");
    l3.setBounds(150,0,70,50);
    l3.setForeground(Color.BLACK);
    f.add(l3);
    
    JPanel panel=new JPanel();  
panel.setBounds(0,0,700,50);    
panel.setBackground(Color.getHSBColor(50, 800, 150));  
f.add(panel);

int j=50;
for(int i=0;i<this.cart.count();i++){
    
   
   JLabel l1=new JLabel(i+1+": "+this.cart.getProduct(i).getName());
    l1.setBounds( 10,10+j,200,20);
    f.add(l1);

    
    JLabel l2=new JLabel("  $"+this.cart.getProduct(i).getPrice()); 
    l2.setBounds(300,10+j,100,20);
    l2.setForeground(Color.decode("#0C9463"));
    f.add(l2);
    
    j +=50;
    
}

int total=0;
for(int i=0;i<this.cart.count();i++){
    total +=this.cart.getProduct(i).getPrice();
}
    
    JLabel l1=new JLabel("-----------");
    l1.setBounds( 30,400,200,20);
    f.add(l1);
    
    JLabel l2=new JLabel("-----------");
    l2.setBounds( 300,400,200,20);
    f.add(l2);
    
    String count = String.valueOf(this.cart.count());
   JLabel l4=new JLabel(count+" "+"Product");
    l4.setBounds( 30,420,200,20);
    f.add(l4);

    
    JLabel l5=new JLabel("$ "+String.valueOf(total)); 
    l5.setBounds(310,420,100,20);
   
    f.add(l5);
    

JPanel pane=new JPanel();  
pane.setBounds(0,0,900,600);    
pane.setBackground(Color.white);  
f.add(pane);
     
       
       JButton p2=new JButton("Back");    
p2.setBounds(130,500,100, 27);
p2.setBackground(Color.decode("#F67280"));
p2.setForeground(Color.WHITE);
p2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new Cart(-1,user,email);
       
        f.dispose();
    }  
});
f.add(p2);

f.setSize(380,600);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
        
    } 
}