
package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author Ssystem
 */
public class quality {
    
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
   
   
    
   
   
   

  
   

   quality(int id,String user,String email){   
    
    JFrame f = new JFrame("Quality");
   
   
     
     
    final JLabel quality = new JLabel("Quality Product:");           
    quality.setBounds(90,115,200,40);
    f.add(quality);
     
      final JTextField qlty = new JTextField ("0");            
             
  
     
    JRadioButton qty=new JRadioButton("very bad");    
    qty.setBounds(90,170,100,30);  
    qty.setBackground(Color.white);
    qty.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(qty.isSelected()){
        qlty.setText("-50");
    }
      
 }  
});
  f.add(qty);
  
    JRadioButton qty2=new JRadioButton(" bad");    
    qty2.setBounds(200,170,50,30);  
    qty2.setBackground(Color.white);
    qty2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(qty2.isSelected()){
        qlty.setText("-30");
    }
      
 }  
});
  f.add(qty2);
  
  
     JRadioButton qty3=new JRadioButton("average");    
    qty3.setBounds(310,170,100,30);  
    qty3.setBackground(Color.white);
    qty3.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(qty3.isSelected()){
        qlty.setText("10");
    }
      
 }  
});
  f.add(qty3);
  
   JRadioButton qty4=new JRadioButton("good");    
    qty4.setBounds(410,170,70,30);  
    qty4.setBackground(Color.white);
    qty4.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(qty4.isSelected()){
        qlty.setText("30");
    }
      
 }  
});
  f.add(qty4);
  
  
   JRadioButton qty5=new JRadioButton("vey good");    
    qty5.setBounds(510,170,100,30);  
    qty5.setBackground(Color.white);
    qty5.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(qty5.isSelected()){
        qlty.setText("50");
    }
      
 }  
});
  f.add(qty5);
  
  
  
  
  
  
  
  
  
  
  
  
   final JLabel Price = new JLabel("Price Product:");           
    Price.setBounds(90,220,200,40);
    f.add(Price);
     
      final JTextField price = new JTextField ("0");            
             
  
     
    JRadioButton pric=new JRadioButton("very bad");    
    pric.setBounds(90,275,100,30);  
    pric.setBackground(Color.white);
    pric.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(pric.isSelected()){
        price.setText("-50");
    }
      
 }  
});
  f.add(pric);
  
    JRadioButton pric2=new JRadioButton(" bad");    
    pric2.setBounds(200,275,50,30);  
    pric2.setBackground(Color.white);
    pric2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(pric2.isSelected()){
        price.setText("-30");
    }
      
 }  
});
  f.add(pric2);
  
  
     JRadioButton pric3=new JRadioButton("average");    
    pric3.setBounds(310,275,100,30);  
    pric3.setBackground(Color.white);
    pric3.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(pric3.isSelected()){
        price.setText("10");
    }
      
 }  
});
  f.add(pric3);
  
   JRadioButton pric4=new JRadioButton("good");    
    pric4.setBounds(410,275,70,30);  
    pric4.setBackground(Color.white);
    pric4.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(pric4.isSelected()){
        price.setText("30");
    }
      
 }  
});
  f.add(pric4);
  
  
   JRadioButton pric5=new JRadioButton("vey good");    
    pric5.setBounds(510,275,100,30);  
    pric5.setBackground(Color.white);
    pric5.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(pric5.isSelected()){
        price.setText("50");
    }
      
 }  
});
  f.add(pric5);
  
  
  
  
  
  
  
  
  
   final JLabel Value = new JLabel("Value Product:");           
    Value.setBounds(90,325,200,40);
    f.add(Value);
     
      final JTextField value = new JTextField ("0");            
             
  
     
    JRadioButton val=new JRadioButton("very bad");    
    val.setBounds(90,390,100,30);  
    val.setBackground(Color.white);
    val.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(val.isSelected()){
        value.setText("-50");
    }
      
 }  
});
  f.add(val);
  
    JRadioButton val2=new JRadioButton(" bad");    
    val2.setBounds(200,390,50,30);  
    val2.setBackground(Color.white);
    val2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(val2.isSelected()){
        value.setText("-30");
    }
      
 }  
});
  f.add(val2);
  
  
     JRadioButton val3=new JRadioButton("average");    
    val3.setBounds(310,390,100,30);  
    val3.setBackground(Color.white);
    val3.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(val3.isSelected()){
        value.setText("10");
    }
      
 }  
});
  f.add(val3);
  
   JRadioButton val4=new JRadioButton("good");    
    val4.setBounds(410,390,70,30);  
     val4.setBackground(Color.white);
    pric4.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(val4.isSelected()){
        value.setText("30");
    }
      
 }  
});
  f.add(val4);
  
  
   JRadioButton val5=new JRadioButton("vey good");    
    val5.setBounds(510,390,100,30);  
    val5.setBackground(Color.white);
    val5.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){     
    if(val5.isSelected()){
        value.setText("50");
    }
      
 }  
});
  f.add(val5);
  
  
  
  
  
  
  
  
  
//    public void actionPerformed(ActionEvent e){    
//if(rb1.isSelected()){    
//JOptionPane.showMessageDialog(this,"You are Male.");    
//}    
//if(rb2.isSelected()){    
//JOptionPane.showMessageDialog(this,"You are Female.");    
//}    
//}    
    
       
JButton p2=new JButton("Back");    
p2.setBounds(20,60,100, 27);
p2.setBackground(Color.decode("#F67280"));
p2.setForeground(Color.WHITE);

p2.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
         new Detail(id,user,email);
        f.dispose();
        

    }  
});
f.add(p2);


JButton regist=new JButton("Regist");    
regist.setBounds(290,450,100, 27);
regist.setBackground(Color.decode("#0C9463"));
regist.setForeground(Color.WHITE);
//int Id =(Integer)this.pm.getProduct(id).getcode();
regist.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
        
       
       new addPool(id,qlty.getText(),price.getText(),value.getText());
        new Detail(id,user,email);
        f.dispose();

    }  
});
f.add(regist);





JPanel panel=new JPanel();  
panel.setBounds(0,0,700,50);    
panel.setBackground(Color.getHSBColor(50, 800, 150));  

JPanel pane3=new JPanel();  
pane3.setBounds(0,100,700,550);    
pane3.setBackground(Color.white);  

JPanel pane2=new JPanel();  
pane2.setBounds(0,50,700,50);    
pane2.setBackground(Color.decode("#C06C84"));  
f.add(panel);f.add(pane2);f.add(pane3);
f.setSize(700,550);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
f.setLocationRelativeTo(null);
   }

    private static class Createquality {
        
          File f4 = new File("E:\\SinUp files\\Sound");
     
      void createFolder(){
        if(!f4.exists()){
            f4.mkdirs();
        }
      }

        public Createquality(String code) {
            
                  createFolder();
            try {
            FileReader fr = new FileReader(f4+"\\Sound_"+code+".txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f4+"\\Sound_"+code+".txt");
                System.out.println("file created");
            } catch (IOException ex1) {
                Logger.getLogger(SinUp.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        }
    }

    private static class addPool {
        
         File f2 = new File("E:\\SinUp files\\Sound");
         int ln;
   

        public addPool(int id, String quality, String price, String value) {
              try {
            ln=1;
            RandomAccessFile ref = new RandomAccessFile(f2+"\\Sound_"+id+".txt","rw");
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
            RandomAccessFile ref = new RandomAccessFile(f2+"\\Sound_"+id+".txt","rw");
            for (int i=0;i<ln;i++){
                ref.readLine();
            }
            
           
            ref.writeBytes("\r\n");
            ref.writeBytes("Opinion1:"+quality + "\r\n");            
            ref.writeBytes("Opinion2:"+price + "\r\n");
            ref.writeBytes("Opinion3:"+value + "\r\n");
           
            
            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              
              
        }
    
   
  

}
