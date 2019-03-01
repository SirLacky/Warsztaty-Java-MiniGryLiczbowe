package pl.sirlacky.lkoziara.workshops.guess_number;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberApp {

    public static void main(String[] args) {


        System.out.println("Witaj w grze w zgadywanie liczb. Program losuje liczbę od 1 do 100 twoim zadaniem jest próba odgadnięcia w jak najmniejszej liczbie kroków tej liczby");
        try {
            int x;
            int hit;
            int numberOfHits = 1;

            Random r = new Random();
            x = r.nextInt(101);

            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj liczbę: ");
            hit = scan.nextInt();

            do {
                if (hit == x) {
                    System.out.println("ZGADŁEŚ GRATULACJE!! trafienie nastąpiło po: " + numberOfHits + "strzałów");
                    break;

                } else if (hit > x) {
                    System.out.println("Niestety strzał chybiony, poszukiwana liczba jest mniejsza. Podaj kolejny strzał:");
                    hit = scan.nextInt();
                    numberOfHits++;
                } else {
                    System.out.println("Niestety strzał chybiony, poszukiwana liczba jest większa. Podaj kolejny strzał:");
                    hit = scan.nextInt();
                    numberOfHits++;
                }
            } while (true);
        } catch (InputMismatchException ime) {
            System.err.println("Nie podałeś prawidłowej liczby, spróbuj ponownie.");
        }

    }

}