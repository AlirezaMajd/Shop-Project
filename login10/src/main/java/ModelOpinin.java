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
public class ModelOpinin {
       LinkedList<Opinin> listOpinin = new LinkedList<Opinin>();
    
   
    public int addOpinin(Opinin p){
        this.listOpinin.add(p);
        return this.listOpinin.size();        
    }
    public int count(){
        return this.listOpinin.size();
    }
    public Opinin getOpinin(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listOpinin.get(index);
    }
}
