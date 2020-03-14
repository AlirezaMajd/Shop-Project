
package main.java;

import java.awt.Color;
import java.awt.Font;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ssystem
 */
public class DetailShoping {
     int ln;
     int lnOp;
    File f = new File("E:\\SinUp files\\RAPIDCLICKS");
    File sound = new File("E:\\SinUp files\\Sound");
    private ModelOpinin opinin;
    private Model pm;
    private int average;
   
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

    
DetailShoping(int c) {
    
   
    ReadFile();
            
     RandomAccessFile ref = null;
        try {
            ref = new RandomAccessFile(sound+"\\Sound_"+c+".txt","rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i=0; ref.readLine() !=null ;i++){
                lnOp++;
            }
        } catch (IOException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("number linepppppppppppppppppppp"+lnOp);
                
    
    this.opinin = new ModelOpinin();
    BufferedReader reader = null;
    
        try {
            reader = new BufferedReader(new FileReader(sound+"\\Sound_"+c+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            for (int i=0;i<lnOp;i+=5){
             
           try {
               while(reader.readLine() != null){
                  
                   String qual = reader.readLine().substring(9);
                   String pric = reader.readLine().substring(9);
                   String val = reader.readLine().substring(9);
                  
                  
                   int qualty = Integer.parseInt(qual);
                   int price = Integer.parseInt(pric);
                   int value = Integer.parseInt(val);
                  
                   
                   Opinin op = new Opinin(qualty,price,value);
                   
                   this.opinin.addOpinin(op);
                 
               }  } catch (IOException ex) {
               Logger.getLogger(shop1.class.getName()).log(Level.SEVERE, null, ex);
           }
                             
}
JPanel pane3=new JPanel();  
pane3.setBounds(0,100,700,500);    
pane3.setBackground(Color.white);  
 
 JFrame f = new JFrame("Detail");
int sum=0;

for (int i=0;i<this.opinin.count();i++){
    sum +=this.opinin.getOpinin(i).getQual();
    sum +=this.opinin.getOpinin(i).getPrice();
    sum +=this.opinin.getOpinin(i).getValue();
}
if(this.opinin.count()>0){
 average = sum/(this.opinin.count()*2);
}
System.out.print(average);

    if(average>=70){
     JLabel star=new JLabel("");
    star.setBounds(-50,110,150,50);
    star.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star);
    
      JLabel star2=new JLabel("");
    star2.setBounds(10,110,150,50);
    star2.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star2);
    
     
      JLabel star3=new JLabel("");
    star3.setBounds(70,110,150,50);
    star3.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star3);
     
      JLabel star4=new JLabel("");
    star4.setBounds(130,110,150,50);
    star4.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star4);
     
      JLabel star5=new JLabel("");
    star5.setBounds(190,110,150,50);
    star5.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star5);
    
    }
    
    if(average >0 & average <10 ){
         JLabel star=new JLabel("");
    star.setBounds(-50,110,150,50);
    star.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star);
    }
    
     
    if(average >=10 & average <20 ){
         JLabel star=new JLabel("");
    star.setBounds(-50,110,150,50);
    star.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star);
    
      JLabel star2=new JLabel("");
    star2.setBounds(10,110,150,50);
    star2.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star2);
    }
    
      if(average >=20 & average <40 ){
         JLabel star=new JLabel("");
    star.setBounds(-50,110,150,50);
    star.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star);
    
      JLabel star2=new JLabel("");
    star2.setBounds(10,110,150,50);
    star2.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star2);
    
     JLabel star3=new JLabel("");
    star3.setBounds(70,110,150,50);
    star3.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star3);
    }

      
        if(average >=40 & average <70 ){
         JLabel star=new JLabel("");
    star.setBounds(-50,110,150,50);
    star.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star);
    
      JLabel star2=new JLabel("");
    star2.setBounds(10,110,150,50);
    star2.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star2);
    
     JLabel star3=new JLabel("");
    star3.setBounds(70,110,150,50);
    star3.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star3);
    
       JLabel star4=new JLabel("");
    star4.setBounds(130,110,150,50);
    star4.setIcon(new ImageIcon("C:\\Users\\Ssystem\\Desktop\\login10\\src\\star5.png"));
    f.add(star4);
    }
        
    
        


 
  
    
   
    JLabel l2=new JLabel("DETAIL PAGE");
    l2.setBounds(290,15,110,20);
    l2.setForeground(Color.white);
    f.add(l2);
    
    JLabel image=new JLabel("");
    image.setBounds(410,100,230,300);

    image.setIcon(new ImageIcon(this.pm.getProduct(c).getImage()));
    f.add(image);
    
    
    
    JLabel l1=new JLabel("Name : "+this.pm.getProduct(c).getName());
    l1.setBounds(50,140,100,100);
    f.add(l1);
    
    JLabel l3=new JLabel("Price : "+this.pm.getProduct(c).getPrice());
    l3.setBounds(50,180,200,100);
     l3.setForeground(Color.decode("#0C9463"));
    f.add(l3);
    
    JLabel l4=new JLabel("Detail : "+this.pm.getProduct(c).getDtail());
    l4.setBounds(50,210,500,100);
    f.add(l4);
    
    JLabel number=new JLabel("Qountity : "+this.pm.getProduct(c).getNumber());
    number.setBounds(50,240,100,100);
    f.add(number);
    
    
     JLabel l5=new JLabel("Address : "+this.pm.getProduct(c).getAddress());
    l5.setBounds(50,280,500,100);
    f.add(l5);
       
JButton p2=new JButton("Back");    
p2.setBounds(20,60,100, 27);
p2.setBackground(Color.decode("#F67280"));
p2.setForeground(Color.WHITE);
//String usr = c2;
//String psd = c3;
p2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new shop1();
       
        f.dispose();
    }  
});
f.add(p2);






      


JPanel panel=new JPanel();  
panel.setBounds(0,0,700,50);    
panel.setBackground(Color.getHSBColor(50, 800, 150));  





    
       




JPanel pane2=new JPanel();  
pane2.setBounds(0,50,700,50);    
pane2.setBackground(Color.decode("#C06C84"));  
f.add(panel);f.add(pane2);f.add(pane3);
f.setSize(700,500);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
   }

}
