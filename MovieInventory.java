// business logik

import java.util.ArrayList;
import java.util.List;

import Model.Movie;

public class MovieInventory implements IInventory {
    private List<Movie> movieInventory;

    public MovieInventory(){
        movieInventory = new ArrayList<Movie>();
    }

    public List<Movie> getMovieInventory(){
        return movieInventory;
    }

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

    public void deleteFromInventory(Movie movieToDelete) {
        if(movieToDelete == null)
            return;

           movieInventory.remove(movieToDelete);
           System.out.println("Der Film \"" + movieToDelete.title + "\" wurde aus dem Inventar gelöscht.");
    }

    public void rentMovie(Movie movieToRent) {
        if(movieToRent == null)
            return;

        for (Movie movie : movieInventory) {
            if(movieToRent.title == movie.title && movie.isRented == false){
                movie.isRented = true;
                System.out.println("Der Film \"" + movie.title + "\" wurde erfolgreich ausgeliehen.");
            }else if(movie.isRented == true){
                System.out.println("Der Film \"" + movie.title + "\" ist bereits ausgeliehen.");
            }
        }
    }

    public void addToInventory(String movieTitle) {
        if(movieTitle.equals(""))
            return;

        Movie movie = new Movie();
        movie.title = movieTitle;
        movie.isRented = false;

        movieInventory.add(movie);
        System.out.println("Der Film \"" + movie.title + "\" wurde zum Inventar hinzugefügt.");
    }

    public void takeBackMovie(Movie movieToTakeBack) {
        if(movieToTakeBack == null)
            return;

        for (Movie movie : movieInventory) {
            if(movieToTakeBack.title == movie.title && movie.isRented == true){
                movie.isRented = false;
                System.out.println("Der Film \"" + movie.title + "\" wurde erfolgreich zurück genommen.");
            }else if(movie.isRented == false){
                System.out.println("Der Film \"" + movie.title + "\" ist bereits wieder im Inventar.");
            }
        }
    }


}
