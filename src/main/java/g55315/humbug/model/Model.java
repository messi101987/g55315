package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public interface Model {

    /**
     * a simple getter for the board
     *
     * @return the board
     */
    Board getBoard();

    /**
     * a simple getter for the array of animals
     *
     * @return the array of animals
     */
    Animal[] getAnimals();

    /**
     * a getter for the remaining moves of the level
     *
     * @return the remaining moves
     */
    int getRemainingMoves();

    /**
     * starts the game at a certain level
     *
     * @param level the chosen level
     */
    void startLevel(int level);

    /**
     * gets the status of the level
     *
     * @return the status in which the level is currently is.
     */
    LevelStatus getLevelStatus();

    /**
     * checks if there is an animal at a certain position
     *
     * @param pos the position where we check if there is an animal
     * @return true if there is an animal at this position, false if not
     */
    boolean isAnimalPos(Position pos);

    /**
     * tries to move the animals in the game
     *
     * @param position the position where you want the animal to go
     * @param direction the direction in which the animal has to move.
     */
    void move(Position position, Direction direction);

    /**
     * decrements the remaining moves
     */
    void decrRemainingMoves();

}
