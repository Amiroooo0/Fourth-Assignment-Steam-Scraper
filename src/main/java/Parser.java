import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.print.Doc;

public class Parser {
    static List<Game> games = new ArrayList<>();

    public List<Game>  sortByName(){

        games.sort(Comparator.comparing(Game::getName));
        return Parser.games;

    }

    public List<Game> sortByRating(){

        games.sort((game1 , game2) -> Double.compare(game2.getRating(), game1.getRating()));
        return Parser.games;

    }

    public List<Game> sortByPrice(){

        games.sort((game1 , game2) -> Integer.compare(game2.getPrice(), game1.getPrice()));
        return Parser.games;

    }

    public void setUp() throws IOException {
        File input = new File("D:\\AP\\Fourth-Assignment-Steam-Scraper\\src\\Resources\\Video_Games.html");
        Document doc = Jsoup.parse(input , "UTF-8");
        Elements games = doc.select("div.game");

        for (Element game : games) {
            String name = game.selectFirst(".game-name").text();

            String priceText = game.selectFirst(".game-price").text();
            String priceValue = priceText.replace("€", "").replace(" ", "");
            int price = Integer.parseInt(priceValue);
            
            String ratingText = game.selectFirst(".game-rating").text();
            String ratingValue = ratingText.split("/")[0].trim();
            double rating = Double.parseDouble(ratingValue);

            Parser.games.add(new Game(name, rating, price));
        }
    }

    public static void saveToJson(List<Game> games , String path) throws IOException {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(path)) {
            gson.toJson(games, fileWriter);
        }
    }


    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        parser.setUp();
        System.out.println("sort method :");
        System.out.println("1.name\n2.rating\n3.price");
        while(true){
            int choice = scanner.nextInt();
            if(choice == 0) { break;}
            if(choice == 1){
                parser.sortByName();
                break;
            }
            else if(choice == 2){
                parser.sortByRating();
                break;
            }
            else if(choice == 3){
                parser.sortByPrice();
                break;
            }
            else
                System.out.println("invalid choice");
        }
        for(Game game : games) {
            System.out.println(game.toString());
        }
        saveToJson(games , "D:\\AP\\Fourth-Assignment-Steam-Scraper\\src\\Resources\\games.json");
    }
}
