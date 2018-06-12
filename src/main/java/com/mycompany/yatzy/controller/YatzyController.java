/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yatzy.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.mycompany.yatzy.model.Bot;
import com.mycompany.yatzy.model.Figur;
import com.mycompany.yatzy.model.GegnerChecker;
import com.mycompany.yatzy.model.Model;
import com.mycompany.yatzy.model.Würfel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joel Meier
 */
public class YatzyController implements Initializable {

    //initializes all variables
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblEinser1;
    @FXML
    private Label lblZweier1;
    @FXML
    private Label lblDreier1;
    @FXML
    private Label lblVierer1;
    @FXML
    private Label lblFünfer1;
    @FXML
    private Label lblSechser1;
    @FXML
    private Label lbl3Pasch1;
    @FXML
    private Label lbl4Pasch1;
    @FXML
    private Label lblFullHouse1;
    @FXML
    private Label lblKleineStrasse1;
    @FXML
    private Label lblGrosseStrasse1;
    @FXML
    private Label lblYahtzee1;
    @FXML
    private Label lblChance1;
    @FXML
    private Label lblTotal1;
    @FXML
    private JFXRadioButton rbEinser;
    @FXML
    private JFXRadioButton rbZweier;
    @FXML
    private JFXRadioButton rbDreier;
    @FXML
    private JFXRadioButton rbVierer;
    @FXML
    private JFXRadioButton rbFünfer;
    @FXML
    private JFXRadioButton rbSechser;
    @FXML
    private JFXRadioButton rbDreierpasch;
    @FXML
    private JFXRadioButton rbViererpasch;
    @FXML
    private JFXRadioButton rbFullHouse;
    @FXML
    private JFXRadioButton rbKleineStrasse;
    @FXML
    private JFXRadioButton rbGrosseStrasse;
    @FXML
    private JFXRadioButton rbYahtzee;
    @FXML
    private JFXRadioButton rbChance;
    @FXML
    private Label lblEinser2;
    @FXML
    private Label lblZweier2;
    @FXML
    private Label lblDreier2;
    @FXML
    private Label lblVierer2;
    @FXML
    private Label lblFünfer2;
    @FXML
    private Label lblSechser2;
    @FXML
    private Label lbl3Pasch2;
    @FXML
    private Label lbl4Pasch2;
    @FXML
    private Label lblFullHouse2;
    @FXML
    private Label lblKleineStrasse2;
    @FXML
    private Label lblGrosseStrasse2;
    @FXML
    private Label lblYahtzee2;
    @FXML
    private Label lblChance2;
    @FXML
    private Label lblTotal2;
    @FXML
    private Button btnWuerfeln;
    @FXML
    private CheckBox cbwuerfel1;
    @FXML
    private CheckBox cbwuerfel2;
    @FXML
    private CheckBox cbwuerfel3;
    @FXML
    private CheckBox cbwuerfel4;
    @FXML
    private CheckBox cbwuerfel5;
    final ToggleGroup group = new ToggleGroup();

    private int abbruch = 0;
    @FXML
    private ImageView wuerfel1;
    @FXML
    private ImageView wuerfel2;
    @FXML
    private ImageView wuerfel3;
    @FXML
    private ImageView wuerfel4;
    @FXML
    private ImageView wuerfel5;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXButton btnNewGame;
    @FXML
    private Label lblRounds;
    GegnerChecker wahl = new GegnerChecker();
    Bot bot = new Bot();
    ArrayList<Integer> rndNumbers = new ArrayList();
    int rounds = 1;
    ArrayList<Integer> hold = new ArrayList();
    Figur figur;
    private AnchorPane anchorPane;
    private Stage window;
    int freieWürfe = 2;
    CheckBox[] checkBoxes;
    JFXRadioButton[] rbuttons;
    ArrayList<Würfel> würfe = new ArrayList<Würfel>();
    Label[] labels1;
    Label[] labels2;
    Model model = new Model();
    int punkte = 0;
    double balance = 1000;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rbuttons = new JFXRadioButton[]{
            rbEinser, rbZweier, rbDreier, rbVierer, rbFünfer, rbSechser, rbDreierpasch, rbViererpasch, rbFullHouse, rbKleineStrasse, rbGrosseStrasse, rbChance, rbYahtzee
        };

        labels1 = new Label[]{
            lblEinser1, lblZweier1, lblDreier1, lblVierer1, lblFünfer1, lblSechser1, lbl3Pasch1, lbl4Pasch1, lblFullHouse1, lblKleineStrasse1, lblGrosseStrasse1, lblChance1, lblYahtzee1
        };

        labels2 = new Label[]{
            lblEinser2, lblZweier2, lblDreier2, lblVierer2, lblFünfer2, lblSechser2, lbl3Pasch2, lbl4Pasch2, lblFullHouse2, lblKleineStrasse2, lblGrosseStrasse2, lblChance2, lblYahtzee2
        };

        for (JFXRadioButton rbtn : rbuttons) {
            rbtn.setSelectedColor(Color.BLACK);
            rbtn.setUnSelectedColor(Color.WHITE);
            rbtn.setToggleGroup(group);
        }

        btnNewGame.setDisable(true);

        checkBoxes = new CheckBox[]{
            cbwuerfel1, cbwuerfel2, cbwuerfel3, cbwuerfel4, cbwuerfel5
        };

        for (int i = 0; i < 5; i++) {
            würfe.add(new Würfel());
        }

        würfe.get(0).setImage(wuerfel1);
        würfe.get(1).setImage(wuerfel2);
        würfe.get(2).setImage(wuerfel3);
        würfe.get(3).setImage(wuerfel4);
        würfe.get(4).setImage(wuerfel5);

    }

    //Creates new dice and sets the imageViews to these random numbers. Also checks if checkboxes are selected
    @FXML
    private void wuerfeln(ActionEvent event) {
        lblRounds.setText("Runde: " + rounds);
        for (CheckBox cb : checkBoxes) {
            cb.setDisable(false);
        }
        if (abbruch < 3) {

            int wCounter = 0;
            for (Würfel w : würfe) {
                w.setTicked(checkBoxes[wCounter].isSelected());
                if (w.isTicked() == false) {
                    w.würfeln();
                    w.getImage().setImage(new Image(getClass().getResourceAsStream("/images/" + (Integer.toString(w.getWert())) + ".gif")));
                }
                wCounter++;
            }
            abbruch++;
            btnWuerfeln.setText("Würfeln [" + freieWürfe + "]");

            for (Würfel w : würfe) {
                rndNumbers.add(w.getWert());
            }
        }
        freieWürfe--;
    }

    //gets the dice 
    public ArrayList<Würfel> getWürfe() {
        return würfe;
    }

    //checks if the combination he wants to check is valid
    @FXML
    private void confirm(ActionEvent event) {
        int rbcounter = 0;
        for (JFXRadioButton rb : rbuttons) {
            if (rb.isSelected()) {
                rbcounter++;
            }
        }
        if (rbcounter == 0) {
            createAlert("Achtung", "Bitte wählen Sie eine Figur aus.");
        }
        model.setArrWürfe(würfe);

        if (rbEinser.isSelected() == true) {
            punkte = model.einer();
            lblEinser1.setText("" + punkte);
        } else if (rbZweier.isSelected() == true) {
            punkte = model.zweier();
            lblZweier1.setText("" + punkte);
        } else if (rbDreier.isSelected() == true) {
            punkte = model.dreier();
            lblDreier1.setText("" + punkte);
        } else if (rbVierer.isSelected() == true) {
            punkte = model.vierer();
            lblVierer1.setText("" + punkte);
        } else if (rbFünfer.isSelected() == true) {
            punkte = model.fünfer();
            lblFünfer1.setText("" + punkte);
        } else if (rbSechser.isSelected() == true) {
            punkte = model.sechser();
            lblSechser1.setText("" + punkte);
        } else if (rbDreierpasch.isSelected() == true) {
            punkte = model.dreierpasch();
            lbl3Pasch1.setText("" + punkte);
        } else if (rbViererpasch.isSelected() == true) {
            punkte = model.viererpasch();
            lbl4Pasch1.setText("" + punkte);
        } else if (rbFullHouse.isSelected() == true) {
            punkte = model.fullHouse();
            lblFullHouse1.setText("" + punkte);
        } else if (rbKleineStrasse.isSelected() == true) {
            punkte = model.kleineStrasse();
            lblKleineStrasse1.setText("" + punkte);
        } else if (rbGrosseStrasse.isSelected() == true) {
            punkte = model.grosseStrasse();
            lblGrosseStrasse1.setText("" + punkte);
        } else if (rbYahtzee.isSelected() == true) {
            punkte = model.yatzy();
            lblYahtzee1.setText("" + punkte);
        } else if (rbChance.isSelected() == true) {
            punkte = model.chance();
            lblChance1.setText("" + punkte);
        }

        for (JFXRadioButton rb : rbuttons) {
            if (rb.isSelected()) {
                rb.setSelected(false);
                rb.setOpacity(0.5);
                rb.setDisable(true);
            }
        }

        for (CheckBox cb : checkBoxes) {
            cb.setSelected(false);
        }

        for (Würfel w : würfe) {
            w.reset();
        }

        abbruch = 0;
        freieWürfe = 5;
        btnWuerfeln.setText("Würfeln [" + freieWürfe + "]");
        playBot();
        sum();
        rounds++;
        winTieLoss();

    }

    //checks if the player looses, wins or if it's a tie
    public void winTieLoss() {
        if (rounds > 13) {
            if (Integer.parseInt(lblTotal1.getText()) > Integer.parseInt(lblTotal2.getText())) {
                playerWins();

            } else if (Integer.parseInt(lblTotal1.getText()) < Integer.parseInt(lblTotal2.getText())) {
                playerLoses();

            } else if (Integer.parseInt(lblTotal1.getText()) == Integer.parseInt(lblTotal2.getText())) {
                playerTie();
            }
            backToHome(new ActionEvent());
        }
    }

    //Creates an alert to use throughout the whole Controller
    public Optional<ButtonType> createAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("");
        alert.setContentText(content);
        return alert.showAndWait();
    }

    //Main Method which allowes the bot to play
    public void playBot() {

        for (int k = 0; k < 3; k++) {
            bot.setK(k);
            bot.clearNumbers();
            wuerfeln(null);
            figur = bot.checkWeights(rndNumbers);
            hold.clear();
        }
        switchCase();
        setValues();
        setSelected();

        for (CheckBox cb : checkBoxes) {
            cb.setDisable(true);
        }
    }

    //gets the highest likelihood and checks the checkboxes to hold the dice
    public void switchCase() {
        int choice = 0;
        int counter = 0;
        int counter2 = 0;
        int c = 0;
        ArrayList<Integer> s;
        switch (figur.getName()) {
            case "einer":
                playNumber(1);
                break;
            case "zweier":
                playNumber(2);
                break;
            case "dreier":
                playNumber(3);
                break;
            case "vierer":
                playNumber(4);
                break;
            case "fünfer":
                playNumber(5);
                break;
            case "sechser":
                playNumber(6);
                break;
            case "dreierpasch":
                choice = 0;
                for (int i = 1; i <= 6; i++) {
                    if (Collections.frequency(rndNumbers, i) > choice) {
                        choice = Collections.frequency(rndNumbers, i);
                    }
                }

                for (CheckBox cb : checkBoxes) {
                    if (rndNumbers.get(c) == choice) {
                        cb.setSelected(true);
                    } else {
                        cb.setSelected(false);
                    }
                    c++;
                }
                break;
            case "viererpasch":
                choice = 0;
                for (int i = 1; i <= 6; i++) {
                    if (Collections.frequency(rndNumbers, i) > choice) {
                        choice = Collections.frequency(rndNumbers, i);
                    }
                }

                for (CheckBox cb : checkBoxes) {
                    if (rndNumbers.get(c) == choice) {
                        cb.setSelected(true);
                    } else {
                        cb.setSelected(false);
                    }
                    c++;
                }
                break;
            case "kleineStrasse":
                choice = 0;

                counter = 0;
                counter2 = 0;
                hold.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 2; j++) {
                        counter = 0;
                        s = new ArrayList();
                        if (rndNumbers.get(j) == i + 1) {
                            counter += 1;
                            s.add(i + 1);
                        }
                        if (rndNumbers.get(j + 1) == i + 2) {
                            counter += 1;
                            s.add(i + 2);
                        }
                        if (rndNumbers.get(j + 2) == i + 3) {
                            counter += 1;
                            s.add(i + 3);
                        }
                        if (rndNumbers.get(j + 3) == i + 4) {
                            counter += 1;
                            s.add(i + 4);
                        }
                        if (counter > counter2) {
                            counter2 = counter;
                            hold = s;
                        }

                    }

                }

                int index;

                for (CheckBox cb : checkBoxes) {
                    if (hold.contains(rndNumbers.get(c))) {
                        index = hold.indexOf(rndNumbers.get(c));
                        hold.remove(index);
                        cb.setSelected(true);
                    } else {
                        cb.setSelected(false);
                    }
                    c++;
                }
                break;
            case "grosseStrasse":
                choice = 0;

                counter = 0;
                counter2 = 0;
                hold.clear();
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 1; j++) {
                        counter = 0;
                        s = new ArrayList();
                        if (rndNumbers.get(j) == i + 1) {
                            counter += 1;
                            s.add(i + 1);
                        }
                        if (rndNumbers.get(j + 1) == i + 2) {
                            counter += 1;
                            s.add(i + 2);
                        }
                        if (rndNumbers.get(j + 2) == i + 3) {
                            counter += 1;
                            s.add(i + 3);
                        }
                        if (rndNumbers.get(j + 3) == i + 4) {
                            counter += 1;
                            s.add(i + 4);
                        }
                        if (rndNumbers.get(j + 4) == i + 5) {
                            counter += 1;
                            s.add(i + 5);
                        }
                        if (counter > counter2) {
                            counter2 = counter;
                            hold = s;
                        }

                    }

                }
                for (CheckBox cb : checkBoxes) {
                    if (hold.contains(rndNumbers.get(c))) {
                        index = hold.indexOf(rndNumbers.get(c));
                        hold.remove(index);
                        cb.setSelected(true);
                    } else {
                        cb.setSelected(false);
                    }
                    c++;
                }
                break;
            case "chance":
                break;
            case "yahtzee":
                choice = 0;
                int num = 0;
                for (int i = 1; i <= 6; i++) {
                    if (Collections.frequency(rndNumbers, i) > choice) {
                        choice = Collections.frequency(rndNumbers, i);
                        num = i;
                    }
                }
                for (CheckBox cb : checkBoxes) {
                    if (rndNumbers.get(c) == num) {
                        cb.setSelected(true);
                    } else {
                        cb.setSelected(false);
                    }
                    c++;
                }

                break;
        }
    }

    //sets the label values to the points the bot scored
    public void setValues() {
        model.setArrWürfe(würfe);
        String labelvalue = figur.getName();
        switch (labelvalue) {

            case "einer":
                punkte = model.einer();
                lblEinser2.setText("" + punkte);
                break;
            case "zweier":
                punkte = model.zweier();
                lblZweier2.setText("" + punkte);
                break;
            case "dreier":
                punkte = model.dreier();
                lblDreier2.setText("" + punkte);
                break;
            case "vierer":
                punkte = model.vierer();
                lblVierer2.setText("" + punkte);
                break;
            case "fünfer":
                punkte = model.fünfer();
                lblFünfer2.setText("" + punkte);
                break;
            case "sechser":
                punkte = model.sechser();
                lblSechser2.setText("" + punkte);
                break;
            case "dreierpasch":
                punkte = model.dreierpasch();
                lbl3Pasch2.setText("" + punkte);
                break;
            case "viererpasch":
                punkte = model.viererpasch();
                lbl4Pasch2.setText("" + punkte);
                break;
            case "fullhouse":
                punkte = model.fullHouse();
                lblFullHouse2.setText("" + punkte);
                break;
            case "kleineStrasse":
                punkte = model.kleineStrasse();
                lblKleineStrasse2.setText("" + punkte);
                break;
            case "grosseStrasse":
                punkte = model.grosseStrasse();
                lblGrosseStrasse2.setText("" + punkte);
                break;
            case "chance":
                punkte = model.chance();
                lblChance2.setText("" + punkte);
                break;
            case "yahtzee":
                punkte = model.yatzy();
                lblYahtzee2.setText("" + punkte);
                break;
        }
    }

    //sets the checkboxes to unselected
    public void setSelected() {
        for (CheckBox cb : checkBoxes) {
            cb.setSelected(false);
        }
        abbruch = 0;
    }

    //makes the sum of all the points the bot and the player scored
    private void sum() {
        int summe1 = 0;
        for (Label lbl : labels1) {
            summe1 += Integer.parseInt(lbl.getText());
        }

        int summe2 = 0;
        for (Label lbl : labels2) {
            summe2 += Integer.parseInt(lbl.getText());
        }

        lblTotal1.setText(Integer.toString(summe1));
        lblTotal2.setText(Integer.toString(summe2));

    }

    //sets the checkboxes to selected or unselected for the dice to be held
    private void playNumber(int n) {
        int c = 0;
        for (CheckBox cb : checkBoxes) {
            if (rndNumbers.get(c) == n) {
                cb.setSelected(true);
            } else {
                cb.setSelected(false);
            }
            c++;
        }

    }

    //By pressing this Button you will get back to the start page
    @FXML
    private void back(ActionEvent event) throws IOException {
        Optional<ButtonType> result = createAlert("Verlassen", "Sind Sie sicher, dass Sie das Spiel verlassen wollen?");
        if (result.get() == ButtonType.OK) {
            backToHome(event);
        }
    }

    //by pressing this button you will get back to the home screen
    private void backToHome(ActionEvent event) {
        try {
            Parent homeView = FXMLLoader.load(getClass().getResource("/fxml/Hello_Yatzy.fxml"));
            Scene spieleAuswahl = new Scene(homeView);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(spieleAuswahl);
            window.show();

        } catch (Exception e) {
        }

    }

    //starts if the palyer wins
    public void playerWins() {
        createAlert("Gewonnen", "Herzlichen Glückwunsch! Sie haben gewonnen!");
        btnNewGame.setOpacity(1.0);
        btnWuerfeln.setDisable(true);
        btnConfirm.setDisable(true);
        btnNewGame.setDisable(false);
    }

    //starts if the player looses
    public void playerLoses() {
        createAlert("Verloren", "Schade... Sie haben leider verloren. Vielleicht klappt es nächstes Mal besser.");
        btnNewGame.setOpacity(1.0);
        btnWuerfeln.setDisable(true);
        btnConfirm.setDisable(true);
        btnNewGame.setDisable(false);
    }

    //starts if the player gets a tie
    public void playerTie() {
        btnNewGame.setOpacity(1.0);
        btnWuerfeln.setDisable(true);
        btnConfirm.setDisable(true);
        createAlert("Unentschieden", "Sie haben ein Unentschieden klicken Sie oben links auf 'Neu Starten'");
        btnNewGame.setDisable(false);
    }

    //will appear when the game is finished
    @FXML
    private void newGame(ActionEvent event) throws IOException {
        

        Parent homeView = FXMLLoader.load(getClass().getResource("/fxml/Hello_Yatzy.fxml"));
        Scene spieleAuswahl = new Scene(homeView);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(spieleAuswahl);
        window.show();
    }
}
