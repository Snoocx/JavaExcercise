import java.util.Scanner;

import Model.Movie;

public class InventoryConsoleHandler {
    private static Scanner input;
    private static MovieInventory movieInventory;

    public InventoryConsoleHandler(){
        movieInventory = new MovieInventory();
        input = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Willkommen im InventarSystem der MovieVision GmbH.");
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
                    printMovieInventory();
                    break;
                case 9:
                    input.close();
                    System.exit(0);
            }
        }
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

    public void addMovie(){
        System.out.println("Wie ist der Filmtitel?");
        String movieTitle = input.nextLine();
        movieInventory.addToInventory(movieTitle);
    }

    public void deleteMovie(){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll gelöscht werden?");
        String movieTitle = input.nextLine();
        Movie movieToDelete = movieInventory.searchInventory(movieTitle);
        movieInventory.deleteFromInventory(movieToDelete);
    }

    public void rentMovie(){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll ausgeliehen werden?");
        String movieTitle = input.nextLine();
        Movie movieToRent = movieInventory.searchInventory(movieTitle);
        movieInventory.rentMovie(movieToRent);
    }

    public void takeBackMovie(){
        //TODO add possibility to ask for id
        System.out.println("Welcher Film soll zurück genommen werden?");
        String movieTitle = input.nextLine();
        Movie movieToTakeBack = movieInventory.searchInventory(movieTitle);
        movieInventory.takeBackMovie(movieToTakeBack);
    }

    public void printMovieInventory(){
        int i = 0;
        for (Movie movie : movieInventory.getMovieInventory()) {
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
