import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player1 = new Player(sc.nextLine(), 'x');
        Player player2 = new Player(sc.nextLine(), 'o');
    }
}