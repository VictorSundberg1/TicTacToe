import java.util.ArrayList;
import java.util.Random;

public class AiPlayer extends Player{
    private final Random random;

    public AiPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    public int getNextMove(ArrayList<Integer> occupiedPositions) {
        int position;
        do {
            position = random.nextInt(9) + 1;
        }while(occupiedPositions.contains(position));
        return position;
    }
}
