package main.java;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;


import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



/**
 *
 * @author Ssystem
 */
public class shop1{ 
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
                   String image= reader.readLine().substring(4);
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
   
   
   
   

  
shop1(){    
     
    
ReadFile();

JFrame f=new JFrame("Button Example");



   

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
    
int j = 240;
int t = 26; 
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
    int c = i;
    image.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
       new DetailShoping(c);
        
        f.dispose();
        
    }  
}); 
    page.add(image);
    
    JPanel panel=new JPanel();  
    panel.setBounds(47+t,130+j,230,30);  
    panel.setBackground(Color.CYAN);
    
   JLabel l1=new JLabel(""+this.pm.getProduct(i).getName());
    
    panel.add(l1);

    JLabel l3=new JLabel("  $"+this.pm.getProduct(i).getPrice());  
    l3.setForeground(Color.decode("#F67280"));
    panel.add(l3);
    
   
  
    t +=300;
    page.add(panel);
}



JLabel pag1 = new JLabel("1");
pag1.setBounds(30,10,110, 27);
pag1.setForeground(Color.WHITE);
pag1.setFont(new Font("Verdana", Font.PLAIN, 30));
page.add(pag1);

JLabel log = new JLabel("Log in");
log.setBounds(930,50,110, 27);
log.setForeground(Color.WHITE);
log.setFont(new Font("Verdana", Font.PLAIN, 27));
//log.setPreferredSize(new Dimension(550, 300));
log.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
        Login rf = new Login();
        rf.setVisible(true);
        rf.pack();
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.dispose();
    }  
}); 
page.add(log);

JLabel admin = new JLabel("Admin");
admin.setBounds(1050,50,110, 27);
admin.setForeground(Color.WHITE);
admin.setFont(new Font("Verdana", Font.PLAIN, 26));
//log.setPreferredSize(new Dimension(550, 300));
admin.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
        Login2 rf = new Login2();
        rf.setVisible(true);
        rf.pack();
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.dispose();
        
    }  
}); 
page.add(admin);




JLabel list = new JLabel("List");
list.setBounds(1180,50,110, 27);
list.setForeground(Color.WHITE);
list.setFont(new Font("Verdana", Font.PLAIN, 26));
//log.setPreferredSize(new Dimension(550, 300));
list.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
       
        shop2 rf = new shop2();
        rf.setVisible(true);
        rf.pack();
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        f.dispose();
    }  
}); 
page.add(list);






JLabel peg2 = new JLabel("2");
peg2.setBounds(580,100,110, 27);
peg2.setForeground(Color.WHITE);
peg2.setFont(new Font("Verdana", Font.PLAIN, 27));
//log.setPreferredSize(new Dimension(550, 300));
peg2.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
        new shopMain2();
        f.dispose();
    }  
}); 
page.add(peg2);





JLabel peg3 = new JLabel("3");
peg3.setBounds(700,100,110, 27);
peg3.setForeground(Color.WHITE);
peg3.setFont(new Font("Verdana", Font.PLAIN, 27));

peg3.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {               
        new shopMain3();
        f.dispose();
    }  
}); 
page.add(peg3);





JTextField search = new JTextField();
search.setBounds(400,50,500,35);
page.add(search);
        
JButton p3 = new JButton("Search");
p3.setBounds(320,50,75,33);
p3.setBackground(Color.decode("#D6E5FA"));
p3.setForeground(Color.decode("#46B5D1"));
p3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        new Search(search.getText());
    }
});
page.add(p3);



f.setSize(1300,750);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
}   



public static void main(String[] args) {
    new shop1();
   
     
  }    

    private void setLayout(FlowLayout flowLayout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private static class Search {
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

        public Search(String text) {
            ReadFile();
            int flag=0;
            for(int i=0;i<this.pm.count();i++){
                if(this.pm.getProduct(i).getName().equals(text)){
                    flag=this.pm.getProduct(i).getNumber() ;
                   
                }
            }
            if(flag>0){
                if(flag==1){
                    JOptionPane.showMessageDialog(null, "There are 1 product from this product");
                }else{
                     JOptionPane.showMessageDialog(null, "There are "+flag+" product from this product");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "There isnt product from this product");
            }
            
        }
    }
}