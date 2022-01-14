package converters;

import dto.MovieDTO;
import model.Movie;

import java.util.function.Function;

public class MovieDTOConverter implements Function<Movie, MovieDTO> {

    @Override
    public MovieDTO apply(Movie movieTitle) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieTitle.getId());
        movieDTO.setTitle(movieTitle.getTitle());
        movieDTO.setYear(movieTitle.getYear());
        movieDTO.setRuntime(movieTitle.getRuntimeStr());
        movieDTO.setGenreList(movieTitle.getGenreList());
        movieDTO.setImDbRating(movieTitle.getImDbRating());
        movieDTO.setMetacriticRating(movieTitle.getMetacriticRating());
        movieDTO.setDirectors(movieTitle.getDirectorList());
        movieDTO.setActors(movieTitle.getActorList());
        movieDTO.setCountries(movieTitle.getCountryList());
        if (movieTitle.getPlotLocal() == null || movieTitle.getPlotLocal().equals("")) {
            movieDTO.setPlot(movieTitle.getPlot());
        } else {
            movieDTO.setPlot(movieTitle.getPlotLocal());
        }
        return movieDTO;
    }
}
