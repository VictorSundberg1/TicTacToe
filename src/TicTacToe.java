import java.util.*;

public class TicTacToe{

    ArrayList<Integer> player1Positions = new ArrayList<>();
    ArrayList<Integer> player2Positions = new ArrayList<>();

    private char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }


    public void resetGameBoard(){
         char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
         player1Positions.clear();
         player2Positions.clear();
         setGameBoard(gameBoard);
    }
    //GameLoop
    public void startGame(){
        currentPlayer = player1;
        while (true) {
            if (currentPlayer == player1) {
                printGameBoard(gameBoard);
                Scanner sc = new Scanner(System.in);
                int playerPosition;

                try {
                    System.out.println(player1.getName() + " Choose a square (1-9) ");
                    playerPosition = sc.nextInt();
                    while (player1Positions.contains(playerPosition) || player2Positions.contains(playerPosition)) {
                        System.out.println("Square already occupied, please choose a new square ");
                        playerPosition = sc.nextInt();
                    }

                    makeMove(gameBoard, playerPosition);

                    String result = checkWinner();
                    if (!result.isEmpty()) {
                        printGameBoard(gameBoard);
                        System.out.println(result);
                        break;
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9");
                    sc.next();
                    continue;
                }
            }
            else if (currentPlayer == player2) {
                Scanner sc = new Scanner(System.in);
                try {
                    printGameBoard(gameBoard);
                    System.out.println(player2.getName() + " Choose a square (1-9) ");

                    int player2Position = sc.nextInt();

                    while (player2Positions.contains(player2Position) || player1Positions.contains(player2Position)) {
                        System.out.println("Square already occupied, please choose a new square ");
                        player2Position = sc.nextInt();
                    }
                    makeMove(gameBoard, player2Position);

                    String result = checkWinner();
                    if (!result.isEmpty()) {
                        printGameBoard(gameBoard);
                        System.out.println(result);
                        break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number between 1 and 9");
                    sc.next();
                    continue;
                }

            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    //Checking for winning conditions after every turn
    public String checkWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1= Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for (List<Integer> l : winningConditions) {
            if (player1Positions.containsAll(l)) {
                player1.setWins(player1.getWins() + 1);
                return player1.getName() + " Won!";
            } else if (player2Positions.containsAll(l)) {
                player2.setWins(player2.getWins() + 1);
                return player2.getName() + " Won!";
            }
        }

        if (player1Positions.size() + player2Positions.size() == 9) {
            return " It was a draw!";
        }

        return "";
    }


    public void makeMove(char[][] gameBoard, int position) {

        char symbol = ' ';

        if (currentPlayer.equals(player1)){
            symbol = player1.getSymbol();
            player1Positions.add(position);
        } else if (currentPlayer.equals(player2)) {
            symbol = player2.getSymbol();
            player2Positions.add(position);
        }

        switch (position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }


    public void printGameBoard(char[][] gameBoard){
        for (char[] row: gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


}
