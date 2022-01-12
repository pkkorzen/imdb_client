package service.impl;

import com.google.gson.Gson;
import model.MovieTitle;
import model.SearchResult;
import model.SearchResultTitle;
import service.MovieService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class IMDBService implements MovieService {

    private final String apiKey = "";
    private final String movieExpressionSearchAddress = "https://imdb-api.com/en/API/SearchMovie/" + apiKey + "/";
    private final String movieTitleSearchAddress = "https://imdb-api.com/en/API/Title/" + apiKey + "/";
    private InputStreamReader reader;

    @Override
    public List<SearchResultTitle> findByExpression(String expression) throws IOException {
        URL expressionURL = new URL(movieExpressionSearchAddress + expression);
        reader = new InputStreamReader(expressionURL.openStream());
        SearchResult searchResult = new Gson().fromJson(reader, SearchResult.class);
        return searchResult.getTitles();
    }

    @Override
    public MovieTitle findById(String id) throws IOException {
        URL titleURL = new URL(movieTitleSearchAddress + id);
        reader = new InputStreamReader(titleURL.openStream());
        return new Gson().fromJson(reader, MovieTitle.class);
    }
}
