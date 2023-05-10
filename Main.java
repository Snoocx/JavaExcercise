import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static Inventory movieInventory;
    public static void main(String[] args){
        movieInventory = new Inventory();
        input = new Scanner(System.in);

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
                    movieInventory.addMovie(input);
                    break;
                case 2:
                    movieInventory.deleteMovie(input);
                    break;
                case 3:
                    movieInventory.rentMovie(input);
                    break;
                case 4:
                    movieInventory.takeBackMovie(input);
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