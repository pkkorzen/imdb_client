package model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SearchResult {

    @SerializedName("searchType")
    @Expose
    private String searchType;
    @SerializedName("expression")
    @Expose
    private String expression;
    @SerializedName("results")
    @Expose
    private List<SearchResultTitle> titles = null;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<SearchResultTitle> getTitles() {
        return titles;
    }

    public void setTitles(List<SearchResultTitle> titles) {
        this.titles = titles;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
