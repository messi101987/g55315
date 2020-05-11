package g55315.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author oscartison
 */
public class Level {

    final private Board board;

    final private Animal[] animals;

    final private int nMoves;

    /**
     * a constructor for the class Level
     *
     * @param board a certain board for a level
     * @param animals the array of animals of a level
     * @param nMoves the number of moves for a level
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * a simple constructor for level
     */
    private Level() {
        this.board = null;
        this.animals = null;
        this.nMoves = 0;
    }

    /**
     * a simple getter for the board
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * reads a level in the jsonFiles
     *
     * @param n the level that needs to be loaded
     * @return the right level
     */
    private static Level readLevel(int n) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + n + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * computes levels between 1 and 3
     *
     * @param n the level you want to create
     * @return the initialised level
     */
    public static Level getLevel(int n) {
        return readLevel(n);
    }

    /**
     * a simple getter for the animals in a level
     *
     * @return an array of animals
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * a simple getter for the number of moves of a level
     *
     * @return the number of moves.
     */
    public int getnMoves() {
        return nMoves;
    }

}
