import java.util.Scanner;

import Model.Movie;

public class Main {
    private static Scanner input;
    private static Inventory movieInventory;
    public static void main(String[] args){

        System.out.println("Willkommen im InventarSystem der MovieVision GmbH.");

        movieInventory = new Inventory();
        input = new Scanner(System.in);
        String movieTitle = "";

        showMenu();

        while(true){
            System.out.print("Wähle eine Zahl um den Menüpunkt aufzurufen: ");
            int menu = input.nextInt();

            input.nextLine(); // nextInt() doesn't consume '\n', so we need to consume \n before going further
            switch(menu){
                case 0:
                    showMenu();
                    break;
                case 1:
                    addMovie();
                    break;
                case 2:
                    deleteMovie();
                    break;
                case 3:
                    rentMovie();
                    break;
                case 4:
                    takeBackMovie();
                    break;
                case 5:
                    movieInventory.printMovieInventory();
                    break;
                case 9:
                    input.close();
                    System.exit(0);
            }
        }
    }

    private static void addMovie(){
        System.out.println("Wie ist der Filmtitel?");
        String movieTitle = input.nextLine();
        movieInventory.addToInventory(movieTitle);
    }
    
    private static void deleteMovie(){
        System.out.println("Welcher Film soll gelöscht werden?");
        String movieTitle = input.nextLine();
        Movie movieToDelete = movieInventory.searchInventory(movieTitle);
        movieInventory.deleteFromInventory(movieToDelete);
    }

    private static void rentMovie(){
        System.out.println("Welcher Film soll ausgeliehen werden?");
        String movieTitle = input.nextLine();
        Movie movieToRent = movieInventory.searchInventory(movieTitle);
        movieInventory.rentMovie(movieToRent);
    }

    private static void takeBackMovie(){
        System.out.println("Welcher Film soll zurück genommen werden?");
        String movieTitle = input.nextLine();
        Movie movieToTakeBack = movieInventory.searchInventory(movieTitle);
        movieInventory.takeBackMovie(movieToTakeBack);
    }

    private static void showMenu(){
        System.out.println("0) Zeige dieses Menü");
        System.out.println("1) Film hinzufügen");
        System.out.println("2) Film löschen");
        System.out.println("3) Film ausleihen");
        System.out.println("4) Film zurücknehmen");
        System.out.println("5) Alle Filme aus dem Inventar anzeigen");
        System.out.println("9) Beendet das Programm");
   }
}