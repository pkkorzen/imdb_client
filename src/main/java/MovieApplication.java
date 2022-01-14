import dto.MovieDTO;
import dto.SearchResultTitleDTO;
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
            List<SearchResultTitleDTO> titlesFound = movieService.findByExpression(searchExpression);
            for (SearchResultTitleDTO title : titlesFound) {
                MovieDTO movie = movieService.findById(title.getId());
                System.out.println(movie.getTitle());
                System.out.println(movie.getYear());
                System.out.println(movie.getPlot());
                System.out.println("-------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
