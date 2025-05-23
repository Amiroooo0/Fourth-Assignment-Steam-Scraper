import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OscarParser {
    static List<Movie> movies;

    public void sortByTitle(){

        movies.sort(Comparator.comparing(Movie::getTitle));

    }

    public void sortByAwards(){

        movies.sort((movie1 , movie2) -> Double.compare(movie2.getAwards(), movie1.getAwards()));

    }

    public void sortByNominations(){

        movies.sort((movie1 , movie2) -> Integer.compare(movie2.getNominations(), movie1.getNominations()));

    }

    public void setUp() {
        String url = "https://www.scrapethissite.com/pages/ajax-javascript/?ajax=true&year=2015";
        Gson gson = new Gson();
        try {
            String json = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
            Type movieListType = new TypeToken<List<Movie>>(){}.getType();
            OscarParser.movies = gson.fromJson(json, movieListType);
            try (FileWriter fw = new FileWriter("D:\\AP\\Fourth-Assignment-Steam-Scraper\\src\\Resources\\movies.json")) {
                gson.toJson(movies, fw);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while connecting to the URL: " + e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        OscarParser parser = new OscarParser();
        parser.setUp();
        if(movies == null) {
            System.out.println("No movies found");
        }
        else {
            while (true) {
                System.out.println("sort method : ");
                System.out.println("1.title\n2.nominations\n3.Awards");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }
                else if (choice == 1) {
                    parser.sortByTitle();
                    break;
                } else if (choice == 2) {
                    parser.sortByNominations();
                    break;
                } else if (choice == 3) {
                    parser.sortByAwards();
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            }
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }
}
