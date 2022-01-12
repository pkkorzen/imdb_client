package service;

import model.MovieTitle;
import model.SearchResultTitle;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    List<SearchResultTitle> findByExpression(String expression) throws IOException;
    MovieTitle findById (String id) throws IOException;

}
