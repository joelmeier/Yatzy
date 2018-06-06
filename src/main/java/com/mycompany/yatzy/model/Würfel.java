package com.mycompany.yatzy.model;

import javafx.scene.image.ImageView;

/**
 *
 * @author Joel Meier
 */
public class Würfel {
    private int wert;
    private boolean ticked;
    private ImageView image;
    
    //constructor
    public Würfel() {
        würfeln();
    }
    //gets the value or the dice
    public int getWert() {
        return wert;
    }
    //gets the image for the view
    public ImageView getImage() {
        return image;
    }
    //sets the image for the view
    public void setImage(ImageView image) {
        this.image = image;
    }
    //gets if the dice is held/ ticked
    public boolean isTicked() {
        return ticked;
    }
    //sets ticked to true or false
    public void setTicked(boolean ticked) {
        this.ticked = ticked;
    }
    //creates the dice with its value
    public void würfeln(){
        wert = (int) (Math.random() * 6 + 1);
        
    }
    //resets the value of the dice
    public void reset(){
        wert = 0;
    }
    }
