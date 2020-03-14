/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;



/**
 *
 * @author Ssystem
 */
public class Product {
   
   private int number;
   private int code;
   private String name;
   private float price;
   private String detail;
   private String title;
   private String address;
   private String image;
   
   public Product(int number,int code , String name,String title , float price , String detail,String address,String image){
       this.number=number;
       this.code=code;
       this.name=name;
       this.title=title;
       this.price=price;
       this.detail = detail;
       this.address=address;
       this.image = image;
   }
       public int getNumber(){
           return number;
       }
   
       public void setNumber(int number){
           this.number=number;
       }
       public int getcode(){
           return code;   
   }
       public void setId(int code){
           this.code=code;
       }
         public String getAddress(){
           return address;
       }
       public String getName(){
           return name;
       }
        public String getImage(){
           return image;
       }
         public String getReduction(){
           return title;
       }
        public String getDtail(){
           return detail;
       }
         public void setDetail(String detail){
           this.name=detail;
       }
       public void setName(String name){
           this.name=name;
       }
        public void setImage(String image){
           this.image=image;
       }
       public float getPrice(){
           return price;
       }
    
       public void setPrice(float price){
           this.price=price;
       }   
}
