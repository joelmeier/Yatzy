/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yatzy.model;

/**
 *
 * @author Joel Meier
 */
public class Figur {
    String name;
    double value;
    boolean complete;

    public Figur(String name, double value, boolean complete) {
        this.name = name;
        this.value = value;
        this.complete = complete;
    }

    //gets the name of the combination with the highest value
    public String getName() {
        return name;
    }
    //gets the value of the combination
    public double getValue() {
        return value;
    }
    //gets if the combination is already complete or not
    public boolean getComplete(){
        return complete;
    }
    
}
