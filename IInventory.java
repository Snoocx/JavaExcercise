import java.util.List;
import Model.Movie;

public interface IInventory {
    public void addToInventory(String movieTitle);
    public Movie searchInventory(String movieTitle);
    public void deleteFromInventory(Movie movieToDelete);
    public void rentMovie(Movie movieToRent);
    public void takeBackMovie(Movie movieToTakeBack);
}
