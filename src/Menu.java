import java.util.Scanner;

public class Menu {
    private final Scanner sc;

    public Menu() {
        this.sc = new Scanner(System.in);
    }

    public boolean showMenu(Player player1, Player player2){
        System.out.println(player1.getName() + " has " + player1.getWins() + " Wins!");
        System.out.println(player2.getName() + " has " + player2.getWins() + " Wins!");
        System.out.println("Enter '1' to play again!");
        System.out.println("Enter '2' to exit");

        String input = sc.nextLine();
        switch (input) {
            case "1":
                return true; //Continues the game
            case "2":
                return false; //Exits the application
            default:
                System.out.println("Invalid input!"); //Re-prints the menu
                return showMenu(player1, player2);
        }
    }
}

