package dk.easv.mrs.GUI.Model;
import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.BLL.MovieManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.List;

public class MovieModel {

    private ObservableList<Movie> moviesToBeViewed;

    private MovieManager movieManager;

    public MovieModel() throws Exception {
        movieManager = new MovieManager();
        moviesToBeViewed = FXCollections.observableArrayList();
        moviesToBeViewed.addAll(movieManager.getAllMovies());
    }



    public ObservableList<Movie> getObservableMovies() {
        return moviesToBeViewed;
    }

    public void searchMovie(String query) throws Exception {
        List<Movie> searchResults = movieManager.searchMovies(query);
        moviesToBeViewed.clear();
        moviesToBeViewed.addAll(searchResults);
    }

    public void createMovie (Movie m) throws Exception {
        Movie createdMovie = movieManager.createMovie(m);
        moviesToBeViewed.add(createdMovie);
    }

    public void updateMovie(Movie updatedMovie) throws Exception {
        movieManager.updateMovie(updatedMovie);
    }

    public void deleteMovie(Movie movieToBeDeleted) throws Exception {
        movieManager.deleteMovie(movieToBeDeleted);
        moviesToBeViewed.remove(movieToBeDeleted);
    }
}
