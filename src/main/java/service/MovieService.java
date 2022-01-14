package service;

import dto.MovieDTO;
import dto.SearchResultTitleDTO;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    List<SearchResultTitleDTO> findByExpression(String expression) throws IOException;
    MovieDTO findById (String id) throws IOException;

}
