package dto;

import model.Actor;
import model.Country;
import model.Genre;
import model.Person;

import java.util.List;

public class MovieDTO {
    private String id;
    private String title;
    private String year;
    private String runtime;
    private List<Genre> genreList;
    private String imDbRating;
    private String metacriticRating;
    private List<Person> directors;
    private List<Actor> actors;
    private List<Country> countries;
    private String plot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getMetacriticRating() {
        return metacriticRating;
    }

    public void setMetacriticRating(String metacriticRating) {
        this.metacriticRating = metacriticRating;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\n" + "Year: " + year +
                "\n" + "Runtime: " + runtime +
                "\n" + "Genres: " + genreList.toString().replace("[", "").replace("]", "") +
                "\n" + "IMDbRating: " + imDbRating +
                "\n" + "MetacriticRating: " + metacriticRating +
                "\n" + "Directors: " + directors.toString().replace("[", "").replace("]", "") +
                "\n" + "Countries: " + countries.toString().replace("[", "").replace("]", "") +
                "\n\n" + "Plot:\n" + plot +
                "\n\n" + "Actors: " + actors.toString().replace("[", "").replace("]", "");

    }
}
