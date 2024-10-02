public class TicTacToe extends Player {
    char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    char currentPlayer;

    public TicTacToe(String name, char symbol) {
        super(name, symbol);
    }


    public static void startGame(){

    }

    /**
     *
     * @param gameBoard
     */
    public static void printGameBoard(char[][] gameBoard){
        for (char[] row: gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


}
