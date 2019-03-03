package pl.sirlacky.lkoziara.workshops.dice_symulator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DiceSymApp {
    public static void main(String[] args) {

        //Program działa, w następnej aktualizacji wprowadzić jednorazowy odczyt ze Stringa np 2D10+20;

        try {

            int howMany = 1;
            int diceType;
            int addition = 0;
            int diceResult;

            //Pobieranie danych od użytkownika
            Scanner scan = new Scanner(System.in);
            System.out.println("Rodzaj kostki (Dostępne: 3, 4, 6, 8, 10, 12, 20, 100): ");
            diceType = scan.nextInt();

            System.out.println("Ile razy mam rzucić? ");
            howMany = scan.nextInt();
            int[] result = new int[howMany];

            System.out.println(("Czy dodać coś do wyniku/ów? [tak/nie]"));
            Scanner scan2 = new Scanner(System.in);
            String ifAdd = scan2.nextLine();
            scan.nextLine();
            if (ifAdd.equals("tak")) {
                System.out.println("Jaką wartość dodać do wyników: ");
                addition = scan.nextInt();
            }


            //Obliczanie wyniku

            Random r = new Random();
            diceResult = r.nextInt(diceType) + 1;

            do {
                if (diceType == 3) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 4) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 6) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 8) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 10) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 12) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 20) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else if (diceType == 100) {
                    result[howMany - 1] = diceResult + addition;
                    diceResult = r.nextInt(diceType) + 1;
                    howMany--;
                } else {
                    System.out.println("Podano nieprawidłowy rodzaj kostki. Spróbuj ponowanie");
                }
            } while (howMany != 0);

            System.out.println("Wylosowane liczby: " + Arrays.toString(result));
        } catch (InputMismatchException ime) {
            System.err.println("Wprowadzono nieprawidłową wartość, spróbuj ponownie");
        }
    }
}
