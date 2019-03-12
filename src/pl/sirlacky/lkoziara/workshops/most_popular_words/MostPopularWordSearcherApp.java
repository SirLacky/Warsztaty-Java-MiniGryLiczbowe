package pl.sirlacky.lkoziara.workshops.most_popular_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

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

            


        } catch (FileNotFoundException fnfe) {
            System.err.println("Nie znaleziono plku");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


