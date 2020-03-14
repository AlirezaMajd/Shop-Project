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
public class Model {
     LinkedList<Product> listOfProduct = new LinkedList<Product>();
    
   
    public int addProduct(Product p){
        this.listOfProduct.add(p);
        return this.listOfProduct.size();        
    }
    public int count(){
        return this.listOfProduct.size();
    }
    public Product getProduct(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listOfProduct.get(index);
    }
    public boolean removeProduct(int id){
        int index = -1;
        for (int i=0 , n = count() ;i<n ;i++){
            if(this.listOfProduct.get(i).getcode() == id){
                index = i;
                break;
            }
        }
          if(index != -1){
                    this.listOfProduct.remove(index);
                    return true;
            }
          return false;
    } 
}
