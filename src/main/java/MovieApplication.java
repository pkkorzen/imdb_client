import dto.MovieDTO;
import dto.SearchResultTitleDTO;
import service.MovieService;
import service.impl.IMDBService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    //TODO: language choice (could be connected wtih properties)
    //TODO: list of titles as arguments
    //TODO: exceptions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide movie name in English");
        String searchExpression = scanner.next();
        System.out.println("Provide path where files will be saved");
        String path = scanner.next();
        MovieService movieService = new IMDBService();
        try {
            List<SearchResultTitleDTO> titlesFound = movieService.findByExpression(searchExpression);
            for (SearchResultTitleDTO title : titlesFound) {
                MovieDTO movie = movieService.findById(title.getId());
                BufferedWriter writer = new BufferedWriter(new FileWriter(path +
                        movie.getTitle().replaceAll("[:|\\\\/]", "") + "-" + movie.getYear() + ".txt"));
                writer.write(movie.toString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
