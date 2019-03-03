//package pl.sirlacky.lkoziara.workshops.most_popular_words;
//
//import java.io.IOException;
//import java.sql.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class MostPopularWordSearcherApp {
//    public static void main(String[] args) {
//
//        Connection connect = Jsoup.connect("https://www.tvn24.pl");
//    try{
//        Document document = ((org.jsoup.Connection) connect).get();
//        Elements links = document.select("span.title");
//        for (Element elem :links){
//            System.out.println(elem.text());
//        }
//
//    }catch(IOException e){
//        e.printStackTrace();
//    }
//
//    }
//}
