package pl.sirlacky.lkoziara.workshops.most_popular_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MostPopularWordSearcherApp {
    public static void main(String[] args) {

        Connection connect = Jsoup.connect("https://www.onet.pl/");

        String[] excluded = new String[]{"oraz", "ponieważ", "albo",};
        String words = "";

        //SKANUJE PODANA STRONE I DODAJE ZNALEZIONE SLOWA DO PLIKU popular_words.txt

        try {
            Document document = ((org.jsoup.Connection) connect).get();

            PrintWriter printWriter = new PrintWriter("/home/sirlacky/Pulpit/Moje Projekty/Warsztaty-Java-MiniGryLiczbowe/src/pl/sirlacky/lkoziara/workshops/most_popular_words/popular_words.txt");
            Elements links = document.select("span.title");
            for (Element elem : links) {
                printWriter.println(elem.text());
            }

            //TWORZY STRINGA ZAWIERAJACEGO WSZYSTKIE SLOWA

            File file = new File("/home/sirlacky/Pulpit/Moje Projekty/Warsztaty-Java-MiniGryLiczbowe/src/pl/sirlacky/lkoziara/workshops/most_popular_words/popular_words.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                words += scan.nextLine();
            }

            //PRZEPISANIE STRINGA DO TABLICY UWZGLEDNIAJAC SLOWA FILTROWANE

            String[] wordsArray = new String[words.length()];
            wordsArray = words.split(" ");


            //FILTROWANIE STRINGA O SLOWA KROTSZE NIZ 3 LITEROWE ORAZ ZNAKI INTERPUNKCYJNE

            String[] wordsArrayFiltered = new String[wordsArray.length];

            for (int i = 0; i < wordsArray.length; i++) {
                if (wordsArray[i].length() > 3) {
                    wordsArrayFiltered[i] = wordsArray[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
                }
            }

            // SPRAWDZA CZY SLOWA NIE SA ZABRONIONE I ODFILTROWUJE NULLE Z TABLICY, NASTEPNIE ZAPISUJE DO PLIKU

            PrintWriter printWriter1 = new PrintWriter("/home/sirlacky/Pulpit/Moje Projekty/Warsztaty-Java-MiniGryLiczbowe/src/pl/sirlacky/lkoziara/workshops/most_popular_words/filtered_popular_words.txt");
            for (int i = 0; i < wordsArrayFiltered.length; i++) {
                if (wordsArrayFiltered[i] != excluded[0] && wordsArrayFiltered[i] != excluded[1] && wordsArrayFiltered[i] != excluded[2] && wordsArrayFiltered[i] != null) {
                    //TEST                   System.out.println(wordsArrayFiltered[i]);
                    printWriter1.println(wordsArrayFiltered[i]);
                }
            }
            printWriter1.close();

        } catch (FileNotFoundException fnfe) {
            System.err.println("Nie znaleziono plku");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


