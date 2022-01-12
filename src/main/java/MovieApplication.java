import model.MovieTitle;
import model.SearchResultTitle;
import service.MovieService;
import service.impl.IMDBService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide movie name in English");
        String searchExpression = scanner.next();
        MovieService movieService = new IMDBService();
        try {
            List<SearchResultTitle> titlesFound = movieService.findByExpression(searchExpression);
            for (SearchResultTitle title : titlesFound) {
                MovieTitle movieTitle = movieService.findById(title.getId());
                System.out.println(movieTitle.getTitle());
                System.out.println(movieTitle.getYear());
                System.out.println(movieTitle.getPlot());
                System.out.println("-------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
