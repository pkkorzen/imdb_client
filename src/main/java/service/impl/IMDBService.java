package service.impl;

import com.google.gson.Gson;
import converters.MovieDTOConverter;
import dto.MovieDTO;
import dto.SearchResultTitleDTO;
import model.Movie;
import model.SearchResult;
import model.SearchResultTitle;
import service.MovieService;
import utils.PropertiesLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IMDBService implements MovieService {

    private InputStreamReader reader;
    private MovieDTOConverter movieDTOConverter;

    @Override
    public List<SearchResultTitleDTO> findByExpression(String expression) throws IOException {
        //properties setting could be moved to constructor, which would allow language choice during object creation in
        //MovieApplication by providing an argument in command line; I guess dtoConverter could be moved there as well
        PropertiesLoader.setPropertiesFile("app.properties");
        final String movieExpressionSearchAddress = PropertiesLoader.getProperty("movieExpressionSearchAddress");
        final String apiKey = PropertiesLoader.getProperty("apiKey");
        URL expressionURL = new URL(movieExpressionSearchAddress + apiKey + "/" + expression);
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
        PropertiesLoader.setPropertiesFile("app.properties");
        final String movieTitleSearchAddress = PropertiesLoader.getProperty("movieTitleSearchAddress");
        final String apiKey = PropertiesLoader.getProperty("apiKey");
        URL titleURL = new URL(movieTitleSearchAddress + apiKey + "/" + id);
        reader = new InputStreamReader(titleURL.openStream());
        Movie movieTitle = new Gson().fromJson(reader, Movie.class);
        movieDTOConverter = new MovieDTOConverter();
        return movieDTOConverter.apply(movieTitle);
    }
}
