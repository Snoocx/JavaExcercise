import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

import Model.Movie;

public class Inventory implements IInventory {
    private List<Movie> movieInventory;

    public Inventory(){
        movieInventory = new ArrayList<Movie>();
    }

    public List<Movie> getMovieInventory(){
        return movieInventory;
    }

    @Override
    public Movie searchInventory(String movieTitle) {
        Movie movie = new Movie();
        if(movieTitle.equals(""))
            return null;

        for (Movie searchedMovie : movieInventory) {
            if(movieTitle.equals(searchedMovie.title)){
                movie = searchedMovie;
            }
        }
        return movie;
    }

    @Override
    public void deleteFromInventory(Movie movieToDelete) {
           movieInventory.remove(movieToDelete);
           System.out.println("Movie \"" + movieToDelete.title + "\" deleted.");
    }

    @Override
    public void rentMovie(Movie movieToRent) {
        for (Movie movie : movieInventory) {
            if(movieToRent.title == movie.title && movie.isRented == false){
                movie.isRented = true;
                System.out.println("Movie \"" + movie.title + "\" rent.");
            }else if(movie.isRented == true){
                System.out.println("Movie \"" + movie.title + "\" is already rented.");
            }
        }
    }

    @Override
    public void addToInventory(String movieTitle) {
        if(movieTitle.equals(""))
            return;

        Movie movie = new Movie();
        movie.title = movieTitle;
        movie.isRented = false;

        movieInventory.add(movie);
        System.out.println("Movie \"" + movie.title + "\" added to Inventory.");
    }

    @Override
    public void takeBackMovie(Movie movieToTakeBack) {
        for (Movie movie : movieInventory) {
            if(movieToTakeBack.title == movie.title && movie.isRented == true){
                movie.isRented = false;
                System.out.println("Movie \"" + movie.title + "\" taken back.");
            }else if(movie.isRented == false){
                System.out.println("Movie \"" + movie.title + "\" is already in stock.");
            }
        }
    }
}
