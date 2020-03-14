/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

import java.util.LinkedList;

/**
 *
 * @author Ssystem
 */
public class CartModel {
      LinkedList<CartObject> listCart = new LinkedList<CartObject>();
    
   
    public int addProduct(CartObject p){
        this.listCart.add(p);
        return this.listCart.size();        
    }
    public int count(){
        return this.listCart.size();
    }
    public CartObject getProduct(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listCart.get(index);
    }
}
