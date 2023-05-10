import java.util.Scanner;

public interface IInventory {
    public void addMovie(Scanner input);
    public void deleteMovie(Scanner input);
    public void rentMovie(Scanner input);
    public void takeBackMovie(Scanner input);
    public void printMovieInventory();
}
