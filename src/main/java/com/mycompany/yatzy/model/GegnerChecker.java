package com.mycompany.yatzy.model;

import java.util.Arrays;

/**
 *
 * @author Joel Meier
 */
public class GegnerChecker {
    Bot bot = new Bot();
    //gets the dice of the bot and puts them into an array
    public int[] gegnerWürfe(){
        return null;
    }
    //sums all the dice with the same value though a parameter
    public int summeBasic(int wert) {
        int[] würfel = gegnerWürfe();
        int summe = 0;
        for (int i = 0; i < würfel.length; i++) {
            if (würfel[i] == wert) {
                summe += würfel[i];
            }
        }
        return summe;
    }
    //sumbasic with ones and checks if its valid
    public int einer() {
        return summeBasic(1);
    }
    //sumbasic with twos and checks if its valid
    public int zweier() {
        return summeBasic(2);
    }
    //sumbasic with threes and checks if its valid
    public int dreier() {
        return summeBasic(3);
    }
    //sumbasic with fours and checks if its valid
    public int vierer() {
        return summeBasic(4);
    }
    //sumbasic with fives  and checks if its valid
    public int fünfer() {
        return summeBasic(5);
    }
    //sumbasic with sixes  and checks if its valid
    public int sechser() {
        return summeBasic(6);
    }
    //gets the points for four of a kind with certain dices and checks if its valid
    public int viererpasch() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);

        int tmp = 0, tmp2 = 0, tmp3 = 0;
        for (int d : würfel) {
            if (d == tmp) {
                if (d == tmp2) {
                    if (d == tmp3) {
                        return d * 4;
                    }
                    tmp3 = d;
                    continue;
                }
                tmp2 = d;
                continue;
            }
            tmp = d;
        }
        return 0;

    }
    //gets the points for three of a kind with certain dices and checks if its valid
    public int dreierpasch() {
        int i = 0, j = 0;
        int[] würfe = gegnerWürfe();
        Arrays.sort(würfe);
        for (int d : würfe) {
            if (d == i) {
                if (d == j) {
                    return d * 3;
                }
                j = d;
                continue;
            }
            i = d;
        }
        return 0;
    }
    //gets the points for a small straight and checks if its valid
    public int kleineStrasse() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);
      if (((würfel[0] == 1) && (würfel[1] == 2) && (würfel[2] == 3) && (würfel[3] == 4))
                || ((würfel[0] == 2) && (würfel[1] == 3) && (würfel[2] == 4) && (würfel[3] == 5))
                || ((würfel[0] == 3) && (würfel[1] == 4) && (würfel[2] == 5) && (würfel[3] == 6))
                || ((würfel[1] == 1) && (würfel[2] == 2) && (würfel[3] == 3) && (würfel[4] == 4))
                || ((würfel[1] == 2) && (würfel[2] == 3) && (würfel[3] == 4) && (würfel[4] == 5))
                || ((würfel[1] == 3) && (würfel[2] == 4) && (würfel[3] == 5) && (würfel[4] == 6))) {
           return 30;
        }else return 0;

    }
    //gets the points for a large straight and checks if its valid
    public int grosseStrasse() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);
        if (würfel[0]==1 && würfel[1]==2 && würfel[2]==3 && würfel[3]==4 && würfel[4]==5
            || würfel[0]== 2 && würfel[1]==3 && würfel[2]==4 && würfel[3]==5 && würfel[4]==6) {
            return 40;
        }else return 0;
    }
    //gets one pair and checks if its valid
    public int paar() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);
        for (int i = würfel.length - 1; i > 0; i--) {
            if (würfel[i] == würfel[i - 1]) {
                return würfel[i] + würfel[i - 1];
            }
        }
        return 0;
    }
    //gets the points for a full house and checks if its valid
    public int fullHouse() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);
        if (würfel[0] == würfel[1] && würfel[1] == würfel[2] && würfel[3] == würfel[4] && würfel[2] != würfel[3]) {
            return 25;
        } else if (würfel[0] == würfel[1] && würfel[2] == würfel[3] && würfel[3] == würfel[4]&& würfel[1]!= würfel[2]) {
            return 25;
        }else return 0;
    }
    //gets the points for a chance
    public int chance() {
        int[] würfel = gegnerWürfe();
        int summe = 0;
        for (int i = 0; i < 5; i++) {
            summe += würfel[i];
        }
        return summe;
    }
    //gets the points for a yahtzee and checks if its valid
    public int yatzy() {
        int[] würfel = gegnerWürfe();
        Arrays.sort(würfel);
        if (würfel[0] == würfel[4]) {
            return 50;
        }
        return 0;
    }



}
