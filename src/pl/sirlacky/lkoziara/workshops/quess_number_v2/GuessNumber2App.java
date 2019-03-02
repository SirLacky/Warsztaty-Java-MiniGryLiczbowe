package pl.sirlacky.lkoziara.workshops.guess_number;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber2App {

    public static void main(String[] args) {


        System.out.println("Witaj w grze w zgadywanie liczb. W tej wersji gry to ty wybierasz liczbę z zakresu 1-100 a komputer próbuje odgadnąć jaka to liczba.");
        try {

            int ourNum;
            int numberOfHits = 0;
            int hit;
            int min = 1;
            int max = 101;

            Scanner scan = new Scanner(System.in);

            //Wprowadzenie przez użytkowanika poszukiwanej liczby
            System.out.println("Proszę podać liczbę z zakresu 1-100: ");
            ourNum = scan.nextInt();


            if (ourNum < 1 || ourNum > 100) {
                System.out.println("Nieprawidłowa liczba. Proszę podać liczbę z zakresu 1-100: ");
                ourNum = scan.nextInt();
            }

            //Sekcja w której komputer zgaduje liczbę
            Random r = new Random();
            hit = (max + min + 1) / 2;

            do {
                if (hit == ourNum) {
                    System.out.println("Komputer odgadł liczbę po " + numberOfHits + " strzałach.");
                    break;

                } else if (hit > ourNum) {
                    max = hit - 1;
                    System.out.println("STRZAŁ! - " + hit);
                    hit = (max + min + 1) / 2;
                    numberOfHits++;
                } else {
                    System.out.println("STRZAŁ! - " + hit);
                    min = hit + 1;
                    hit = (max + min + 1) / 2;
                    numberOfHits++;
                }
            } while (true);
        } catch (InputMismatchException ime) {
            System.err.println("Nie podałeś prawidłowej liczby, spróbuj ponownie.");
        }

    }

}