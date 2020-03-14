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
public class UserModel {
     LinkedList<User> listUser = new LinkedList<User>();
    
   
    public int addUser(User p){
        this.listUser.add(p);
        return this.listUser.size();        
    }
    public int count(){
        return this.listUser.size();
    }
    public User getUser(int index){
        if(index < 0 || index >= count()){
            return null;
        }
        return this.listUser.get(index);
    }
}
