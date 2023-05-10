import java.util.Scanner;

import Model.Movie;

public class Main {
    public static void main(String[] args){

        System.out.println("Willkommen im InventarSystem der MovieVision GmbH.");

        Inventory movieInventory = new Inventory();
        Scanner input = new Scanner(System.in);
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
                    System.out.println("Wie ist der Filmtitel?");
                    movieTitle = input.nextLine();
                    movieInventory.addToInventory(movieTitle);
                    break;
                case 2:
                    System.out.println("Welcher Film soll gelöscht werden?");
                    movieTitle = input.nextLine();
                    Movie movieToDelete = movieInventory.searchInventory(movieTitle);
                    movieInventory.deleteFromInventory(movieToDelete);
                    break;
                case 3:
                    System.out.println("Welcher Film soll ausgeliehen werden?");
                    movieTitle = input.nextLine();
                    Movie movieToRent = movieInventory.searchInventory(movieTitle);
                    movieInventory.rentMovie(movieToRent);
                    break;
                case 4:
                    System.out.println("Welcher Film soll zurück genommen werden?");
                    movieTitle = input.nextLine();
                    Movie movieToTakeBack = movieInventory.searchInventory(movieTitle);
                    movieInventory.takeBackMovie(movieToTakeBack);
                    break;
                case 5:
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
}