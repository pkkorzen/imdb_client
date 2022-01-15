import dto.MovieDTO;
import dto.SearchResultTitleDTO;
import service.MovieService;
import service.impl.IMDBService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MovieApplication {
    //TODO: language choice (could be connected wtih properties)
    //TODO: exceptions
    public static void main(String[] args) {
        String[] searchExpressions;
        String path;
        if (args.length > 0) {
            path = args[0];
            searchExpressions = new String[args.length-1];
            System.arraycopy(args, 1, searchExpressions, 0, args.length-1);

        } else throw new IllegalArgumentException("No arguments provided");

        MovieService movieService = new IMDBService();
        try {
            for (String searchExpression : searchExpressions) {
                List<SearchResultTitleDTO> titlesFound = movieService.findByExpression(searchExpression);
                for (SearchResultTitleDTO title : titlesFound) {
                    MovieDTO movie = movieService.findById(title.getId());
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path +
                            movie.getTitle().replaceAll("[:|\\\\/]", "") + "-" + movie.getYear() + ".txt"));
                    writer.write(movie.toString());
                    writer.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
