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
public class Opinin {
    
    private int qaul;
    private int price;
    private int value;
    public Opinin(int qual,int price,int value){
        this.qaul=qual;
        this.price=price;
        this.value=value;
    }
    public int getQual(){
        return qaul;   
    }
    
     public int getPrice(){
        return price;   
    }
      public int getValue(){
        return value;   
    }
    
    
}
