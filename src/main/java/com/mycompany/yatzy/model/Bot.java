package com.mycompany.yatzy.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Joel Meier
 */
public class Bot {
    //Initializing the variables 
    ArrayList<Figur> figuren = new ArrayList();
    ArrayList<Integer> numbers = new ArrayList();
    ArrayList<String> alreadySelected = new ArrayList();
    int highest;
    Figur lastSelected = null;
    int k;
    
    //constructor
    public Bot() {

    }
    //sets K
    public void setK(int k) {
        this.k = k;
    }
    
    //Clears the old dice 
    public void clearNumbers() {
        numbers.clear();
    }
    //checks which of the combinations has the most value    
    public Figur checkWeights(ArrayList<Integer> numbers) {
        this.numbers = numbers;

        figuren.clear();

        Collections.sort(numbers);

        if (alreadySelected.contains("viererpasch") == false) {
            checkViererpasch();
        }
        if (alreadySelected.contains("dreierpasch") == false) {
            checkDreierpasch();
        }
        if (alreadySelected.contains("einer") == false) {
            checkEiner();
        }
        if (alreadySelected.contains("zweier") == false) {
            checkZweier();
        }
        if (alreadySelected.contains("dreier") == false) {
            checkDreier();
        }
        if (alreadySelected.contains("vierer") == false) {
            checkVierer();
        }
        if (alreadySelected.contains("fünfer") == false) {
            checkFünfer();
        }
        if (alreadySelected.contains("sechser") == false) {
            checkSechser();
        }
        if (alreadySelected.contains("fullhouse") == false) {
            checkFullHouse();
        }
        if (alreadySelected.contains("kleineStrasse") == false) {
            checkSmallStraight();
        }
        if (alreadySelected.contains("grosseStrasse") == false) {
            checkLargeStraight();
        }
        if (alreadySelected.contains("yahtzee") == false) {
            checkYahtzee();
        }
        
        highest = 0;
        if(k>1){
            
            double highestD = 0;
            
            Figur finalF = null;
                
                for(Figur f : figuren){
                    if(f.getValue()>highestD){
                        if(f.getComplete()){
                        finalF = f;
                        highestD = f.getValue();
                            
                        }
                    }
                }
                
                if(finalF == null){
                    if (alreadySelected.contains("chance") == false) {
                        checkChance();
                    }
                    finalF = figuren.get(figuren.size()-1);
                }
                
                alreadySelected.add(finalF.getName());
                
                return finalF;
                    
            
        } else {
        for (Figur f : figuren) {

            if (f.getValue() > highest) {
                highest = figuren.indexOf(f);
            }

        }
        return figuren.get(highest);
        
    }

    }
    //checks ones and gets a value
    public void checkEiner() {
        int counter = 0;
        boolean complete = false;
        for (int n : numbers) {
            if (n == 1) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("einer", (double) counter / 1 * 1, complete));
    }
    //checks twos and gets a value
    public void checkZweier() {
        boolean complete = false;
        int counter = 0;
        for (int n : numbers) {
            if (n == 2) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("zweier", (double) counter / 1 * 2, complete));
    }
    //checks threes and gets a value
    public void checkDreier() {
        boolean complete = false;
        int counter = 0;
        for (int n : numbers) {
            if (n == 3) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("dreier", (double) counter / 1 * 3, complete));
    }
    //checks fours and gets a value
    public void checkVierer() {
        boolean complete = false;
        int counter = 0;
        for (int n : numbers) {
            if (n == 4) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("vierer", (double) counter / 1 * 4, complete));
    } 
    //checks fives and gets a value
    public void checkFünfer() {
        boolean complete = false;
        int counter = 0;
        for (int n : numbers) {
            if (n == 5) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("fünfer", (double) counter / 1 * 5, complete));
    }
    //checks sixes and gets a value
    public void checkSechser() {
        boolean complete = false;
        int counter = 0;
        for (int n : numbers) {
            if (n == 6) {
                counter += 1;
            }
        }
        if (counter >= 1) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("sechser", (double) counter / 1 * 6, complete));
    }
    //checks three of a kind and gets a value
    public void checkDreierpasch() {
        boolean complete = false;
        int i = 0, j = 0;
        int counter = 0;
        int counter2 = 0;
        int count = 0;
        int count2 = 0;
        for (int d : numbers) {
            if (d == i) {
                if (d == j) {
                    counter = 3;
                } else {
                    counter = 2;
                    j = d;
                }
            } else {
                counter = 1;
                i = d;
            }
            count = d * 3;
            if(counter2 < counter){
                counter2 = counter;
            }
            if (count2 < count) {
                count2 = count;
            }
        }
        if (counter == 3) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("dreierpasch", (double) counter2 / 3 * (double) count2, complete));
    }
    //checks four of a kind and gets a value
    public void checkViererpasch() {
        boolean complete = false;
        int i = 0, j = 0, k = 0;
        int counter = 0;
        int counter2 = 0;
        int count = 0;
        int count2 = 0;
        for (int d : numbers) {
            if (d == i) {
                if (d == j) {
                    if (d == k) {
                        counter = 4;
                        count = d * 4;

                    } else {
                        counter = 3;
                        count = d * 3;
                        k = d;
                    }
                } else {
                    count = d * 2;
                    counter = 2;
                    j = d;
                }
            } else {
                count = d;
                counter = 1;
                i = d;
            }
            if(counter2 < counter){
                counter2 = counter;
            }
            if (count2 < count) {
                count2 = count;
            }
        }
        if (counter == 4) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("viererpasch", (double) counter2 / 4 * (double) count2, complete));

    }
    //checks small Straight and gets a value
    public void checkSmallStraight() {
        boolean complete = false;
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                counter = 0;
                if (numbers.get(j) == i + 1) {
                    counter += 1;
                }
                if (numbers.get(j + 1) == i + 2) {
                    counter += 1;
                }
                if (numbers.get(j + 2) == i + 3) {
                    counter += 1;
                }
                if (numbers.get(j + 3) == i + 4) {
                    counter += 1;
                }
                if (counter > counter2) {
                    counter2 = counter;
                }

            }

        }
        if (counter2 == 4) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("kleineStrasse", (double) counter2 / 4 * 30, complete));

    }
    //checks large Straight and gets a value
    public void checkLargeStraight() {
        boolean complete = false;
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < 2; i++) {
            counter = 0;
            
            for (int j = 0; j < 5; j++) {
                
            if (numbers.get(j) == i + j +1) {
                counter += 1;
            }
            }
            if (counter > counter2) {
                counter2 = counter;
            }

        }
        if (counter2 == 5) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("grosseStrasse", (double) counter2 / 5 * 40, complete));

    }
    //checks Full House and gets a value
    public void checkFullHouse() {
        boolean complete = false;
        int counter = 0;
        for (int i = 0; i < 1; i++) {
            if (numbers.get(i) == numbers.get(i + 1) && numbers.get(i + 1) == numbers.get(i + 2) && numbers.get(i + 3) == numbers.get(i + 4) && numbers.get(i + 2) != numbers.get(i + 3)) {

                counter = 5;

            } else if (numbers.get(i) == numbers.get(i + 2) && numbers.get(i + 2) == numbers.get(i + 3) && numbers.get(i + 3) == numbers.get(i + 4) && numbers.get(i + 1) != numbers.get(i + 2)) {

                counter = 5;
            }
        }
        if (counter == 5) {
            complete = true;
        }
        figuren.add(new Figur("fullhouse", (double) counter / 5 * 25, complete));

    }
    //checks chance and gets a value
    public void checkChance() {
        boolean complete = false;
        int count = 0;
        for (int n : numbers) {
            count += n;
        }
        complete = true;
        figuren.add(new Figur("chance", 5 / 5 * (double) count, complete));
    }
    //checks Yahtzee and gets a value
    public void checkYahtzee() {
        boolean complete = false;
        int counter = 0;
        int counter2 = 0;
        for (int i = 1; i <= 6; i++) {
            counter = 0;
            for (int n : numbers) {
                if (n == i) {
                    counter++;
                }
            }
            if (counter > counter2) {
                counter2 = counter;
            }
        }
        if (counter2 == 5) {
            complete = true;
        } else {
            complete = false;
        }
        figuren.add(new Figur("yahtzee", (double) counter2 / 5 * 50, complete));
    }
}
