package com.mycompany.yatzy.model;

import com.mycompany.yatzy.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel Meier
 */
public class User {

    private static User user = null;
    private int balance = 0;
   
    private User() {
       
    }
    
    public int getBalance(){
        return balance;
    }
    
    public int getOfflineBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    
    public void removeBalance(int b){
        balance-=b;
    }
    
    public void addBalance(int b){
        balance+=b;
    }


}
