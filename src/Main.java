import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe");
        System.out.println("Enter name of player 1 (X)");
        Player player1 = new Player(sc.nextLine(), 'X');

        System.out.println("Enter name of player 2 (O)");
        Player player2 = new Player(sc.nextLine(), 'O');
        TicTacToe game = new TicTacToe(player1, player2);
        Menu menu = new Menu();

        // Do While to continue playing until showMenu returns false
        do {
            game.startGame();
            game.resetGameBoard();
        }while (menu.showMenu(player1, player2));
    }

}

