/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yatzy.controller;



import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joel Meier
 */
public class Hello_yatzyController implements Initializable {

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }
    //Get the next .fxml via button
    @FXML
    private void next(ActionEvent event) throws IOException {
        
                Parent homeView = FXMLLoader.load(getClass().getResource("/fxml/View_Yatzy.fxml"));
                Scene viewScene = new Scene(homeView);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(viewScene);
                window.show();
              }
   
}
