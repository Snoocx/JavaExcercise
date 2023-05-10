import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Movie;

public class Inventory implements IInventory {
    private List<Movie> movieInventory;

    public Inventory(){
        movieInventory = new ArrayList<Movie>();
    }

    private Movie searchInventory(String movieTitle) {
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

    private void deleteFromInventory(Movie movieToDelete) {
        if(movieToDelete == null)
            return;

           movieInventory.remove(movieToDelete);
           System.out.println("Der Film \"" + movieToDelete.title + "\" wurde aus dem Inventar gelöscht.");
    }

    private void rentMovie(Movie movieToRent) {
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

    private void addToInventory(String movieTitle) {
        if(movieTitle.equals(""))
            return;

        Movie movie = new Movie();
        movie.title = movieTitle;
        movie.isRented = false;

        movieInventory.add(movie);
        System.out.println("Der Film \"" + movie.title + "\" wurde zum Inventar hinzugefügt.");
    }

    private void takeBackMovie(Movie movieToTakeBack) {
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

    @Override
    public void addMovie(Scanner input){
        System.out.println("Wie ist der Filmtitel?");
        String movieTitle = input.nextLine();
        addToInventory(movieTitle);
    }

    @Override
    public void deleteMovie(Scanner input){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll gelöscht werden?");
        String movieTitle = input.nextLine();
        Movie movieToDelete = searchInventory(movieTitle);
        deleteFromInventory(movieToDelete);
    }

    @Override
    public void rentMovie(Scanner input){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll ausgeliehen werden?");
        String movieTitle = input.nextLine();
        Movie movieToRent = searchInventory(movieTitle);
        rentMovie(movieToRent);
    }

    @Override
    public void takeBackMovie(Scanner input){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll zurück genommen werden?");
        String movieTitle = input.nextLine();
        Movie movieToTakeBack = searchInventory(movieTitle);
        takeBackMovie(movieToTakeBack);
    }

    @Override
    public void printMovieInventory(){
        int i = 0;
        for (Movie movie : movieInventory) {
            i++;
            System.out.println("#" + i);
            System.out.println("Filmtitel: " + movie.title);
            System.out.println("Ausgeliehen: " + (movie.isRented ? "Ja" : "Nein"));
            System.out.println();
        }
        if(i == 0)
            System.out.println("Es wurden keine Filme gefunden.");
    }
}
