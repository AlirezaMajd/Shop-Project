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
public class CartObject {
   private String name;
   private float price;
   private String image;
    public CartObject(String name,float price, String image){
        this.name=name;
        this.price=price;
        this.image=image;
       
    }
    public String getName(){
        return name;
    }
     public float getPrice(){
        return price;
    }
     
      public String getImage(){
        return image;
    }
}
