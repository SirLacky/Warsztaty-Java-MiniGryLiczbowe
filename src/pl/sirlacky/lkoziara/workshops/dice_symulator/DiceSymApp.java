package pl.sirlacky.lkoziara.workshops.dice_symulator;

import java.util.Arrays;
import java.util.Random;

public class DiceSymApp {
    public static void main(String[] args) {


        
        int howMany = 10;
        int diceType = 100;
        int addition = 0;
        int [] result = new int[howMany];
        int diceResult;

        //Wybór kostki

        Random r = new Random();
        diceResult = r.nextInt(diceType)+1;

        do {
            if (diceType == 3) {
                result [howMany-1]= diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 4) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 6) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 8) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 10) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 12) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 20) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else if (diceType == 100) {
                result [howMany-1] = diceResult + addition;
                diceResult = r.nextInt(diceType)+1;
                howMany--;
            } else {
                System.out.println("Podano nieprawidłowy rodzaj kostki. Spróbuj ponowanie");
            }
        }while (howMany!=0);

        System.out.println("Wylosowane liczby: "+ Arrays.toString(result));

    }
}
