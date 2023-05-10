import Model.Movie;

public interface IInventory {
    public Movie searchInventory(String movieTitle);
    public void deleteFromInventory(Movie movieToDelete);
    public void rentMovie(Movie movieToRent);
    public void addToInventory(String movieTitle);
    public void takeBackMovie(Movie movieToTakeBack);
}
