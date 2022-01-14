package service.impl;

import com.google.gson.Gson;
import converters.MovieDTOConverter;
import dto.MovieDTO;
import dto.SearchResultTitleDTO;
import model.Movie;
import model.SearchResult;
import model.SearchResultTitle;
import service.MovieService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IMDBService implements MovieService {

    private final String apiKey = "";
    private final String movieExpressionSearchAddress = "https://imdb-api.com/en/API/SearchMovie/" + apiKey + "/";
    private final String movieTitleSearchAddress = "https://imdb-api.com/en/API/Title/" + apiKey + "/";
    private InputStreamReader reader;
    private MovieDTOConverter movieDTOConverter;

    @Override
    public List<SearchResultTitleDTO> findByExpression(String expression) throws IOException {
        URL expressionURL = new URL(movieExpressionSearchAddress + expression);
        reader = new InputStreamReader(expressionURL.openStream());
        SearchResult searchResult = new Gson().fromJson(reader, SearchResult.class);
        List<SearchResultTitleDTO> searchResultTitles = new ArrayList<>();
        for (SearchResultTitle searchResultTitle : searchResult.getTitles()) {
            SearchResultTitleDTO searchResultTitleDTO = new SearchResultTitleDTO();
            searchResultTitleDTO.setTitle(searchResultTitle.getTitle());
            searchResultTitleDTO.setId(searchResultTitle.getId());
            searchResultTitles.add(searchResultTitleDTO);
        }
        return searchResultTitles;
    }

    @Override
    public MovieDTO findById(String id) throws IOException {
        URL titleURL = new URL(movieTitleSearchAddress + id);
        reader = new InputStreamReader(titleURL.openStream());
        Movie movieTitle = new Gson().fromJson(reader, Movie.class);
        movieDTOConverter = new MovieDTOConverter();
        return movieDTOConverter.apply(movieTitle);
    }
}
