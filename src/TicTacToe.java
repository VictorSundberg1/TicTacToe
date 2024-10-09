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
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    //resetting the gameboard and all player positions
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
            playerTurn(currentPlayer);

            String result = checkWinner();
            if (!result.isEmpty()) {
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }
            //Switching currentPlayer after each turn to the other player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private void playerTurn(Player player){
        Scanner sc = new Scanner(System.in);
        int playerPosition;
        while (true) {
            printGameBoard(gameBoard);
            System.out.println(player.getName() + " Choose a square (1-9) ");
            //Try Catch used to avoid any character that's not an int for the playerposition input
            try {
                playerPosition = sc.nextInt();
                //Checking if the square is already taken, then try again
                if (player1Positions.contains(playerPosition) || player2Positions.contains(playerPosition)) {
                    System.out.println("Square already occupied, please choose a new square ");
                    continue;
                }
                makeMove(gameBoard, playerPosition);
                break;
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9");
                sc.next();
            }
        }
    }

    //Checking for winning conditions after every turn
    public String checkWinner() {

        //All possible win conditions listed
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1= Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> winningConditions = new ArrayList<>();

        //Adding win conditions to a list
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        //checking the playerpositions lists for possible match with win conditions
        for (List<Integer> l : winningConditions) {
            if (player1Positions.containsAll(l)) {
                player1.setWins(player1.getWins() + 1);
                return player1.getName() + " Won!";
            } else if (player2Positions.containsAll(l)) {
                player2.setWins(player2.getWins() + 1);
                return player2.getName() + " Won!";
            }
        }

        //checking if all positions are taken equals a draw
        if (player1Positions.size() + player2Positions.size() == 9) {
            return " It was a draw!";
        }

        return "";
    }

    //Method for placing a piece depending on current player
    public void makeMove(char[][] gameBoard, int position) {

        char symbol = currentPlayer.getSymbol();

        //Checking who is the currentplayer and then adding the according symbol to the position of the input
        if (currentPlayer.equals(player1)){
            player1Positions.add(position);
        } else {
            player2Positions.add(position);
        }

        // All positions in the array where you can place a piece
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
