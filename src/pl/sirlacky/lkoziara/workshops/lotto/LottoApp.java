package pl.sirlacky.lkoziara.workshops.lotto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LottoApp {

    public static void main(String[] args) {

        try {
            //Stworzenie tablicy i wypełnienie jej liczbami 1-49
            int[] liczby = new int[49];
            int nextVal = 1;
            for (int i = 0; i < liczby.length; i++) {
                liczby[i] = nextVal++;
            }

            int zakres = liczby.length;
            int[] wylosowane = new int[6];

            //Algorytm losujacy, przenoszacy wybrane liczby na koniec tablicy i dodajacy do nowej
            for (int i = 0; i < wylosowane.length; i++) {
                int uzytyindex = 0 + new Random().nextInt(zakres);
                wylosowane[i] = liczby[uzytyindex];
                int temp = liczby[uzytyindex];
                liczby[uzytyindex] = liczby[zakres - 1];
                liczby[zakres - 1] = temp;
                zakres--;
            }

            //Algorytm proszący o podanie 6 liczb z zakresu i sprawdzający czy liczby się nie powtarzają.
            int[] typowane = {543219, 543219, 543219, 543219, 543219, 543219};
            int temp;
            Scanner scan = new Scanner(System.in);
            for (int i = 1; i < typowane.length + 1; i++) {
                System.out.println("Podaj liczbę którą numer " + i + " z zakresu 1-49: ");
                temp = scan.nextInt();
                if (temp == typowane[0] || temp == typowane[1] || temp == typowane[2] || temp == typowane[3] || temp == typowane[4] || temp == typowane[5]) {
                    System.err.println("Niestety podałeś już tą liczbę, podaj inną.");
                    i--;
                } else {
                    if (temp < 1 || temp > 49) {
                        System.err.println("Niestety liczba nie mieści się w zakresie 1-49, spróbuj ponowanie.");
                        i--;
                    } else {
                        typowane[i - 1] = temp;
                    }

                }

            }

            //Algorytm sprawdzający czy zaistniały trafienia.

            int strzalyTrafione = 0;
            for (int i = 1; i < wylosowane.length; i++) {
                for (int j = 0; j < wylosowane.length; j++) {
                    if (typowane[i] == wylosowane[j]) {
                        strzalyTrafione++;
                    }
                }
            }

            //Wyswietlanie wynikow:
            Arrays.sort(wylosowane);
            Arrays.sort(typowane);
            String wyniki = Arrays.toString(wylosowane);
            String typy = Arrays.toString(typowane);
            System.out.println("Losowanie zakończone. \nWyniki losowania:" + wyniki + " \nTwoje typy: " + typy + "\nIlość trafień: " + strzalyTrafione);
        } catch (InputMismatchException ime) {
        System.err.println("Nie wprowadzono liczby, spróbuj od początku");
        }
    }
}
