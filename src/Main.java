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

        game.startGame();
        game.resetGameBoard();

        boolean running = true;

        while(running){
            System.out.println(player1.getName() + " has " + player1.getWins() + " Wins!");
            System.out.println(player2.getName() + " has " + player2.getWins() + " Wins!");
            System.out.println("Enter '1' to play again!");
            System.out.println("Enter '2' to exit");


            String input = sc.nextLine();
            switch (input) {
                case "1":
                    game.startGame();
                    game.resetGameBoard();
                    break;
                case "2":
                    System.out.println("Thank you for playing");
                    running = false;
                    break;
            }
        }
    }

}