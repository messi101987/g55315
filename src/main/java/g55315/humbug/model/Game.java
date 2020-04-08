package g55315.humbug.model;

/**
 * the class game implements the interface Model
 *
 * @author oscartison
 */
public class Game implements Model {

    /**
     * this is the board for the current level
     */
    private Board board;

    /**
     * this is an array with all the Animals in the board
     */
    private Animal[] animals;

    /**
     * a simple getter for the board
     *
     * @return the board
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * a simple getter for the array of animals
     *
     * @return the array of animals
     */
    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * starts the game at a certain level
     *
     * @param level the chosen level
     */
    @Override
    public void startLevel(int level) {
        Animal[] an = {new Snail(new Position(0, 0))};
        if (level == 1) {
            this.board = Board.getInitialBoard();
            this.animals = an;
        }
    }

    /**
     * controls if the level is over or not
     *
     * @return true if the level is over, false if not
     */
    @Override
    public boolean levelIsOver() {
        if (animals == null || board == null) {
            throw new IllegalStateException("the game was not started yet");
        }
        boolean over = true;
        // APA : Et si l'animal est tombé ? 
        for (Animal a : animals) {
            if (a.isOnStar()) {
                // APA : Tu n'as besoin que du else
                over = over && true;
            } else {
                over = false;
            }
        }
        return over;
    }

    /**
     * checks if there is an animal at a certain position
     *
     * @param pos the position where we check if there is an animal
     * @return true if there is an animal at this position, false if not
     */
    @Override
    public boolean isAnimalPos(Position pos) {
        boolean animal_present = false;
        for (Animal a : animals) {
            if (a.getPositionOnBoard().equals(pos)) {
                animal_present = true;
            }
        }
        return animal_present;
    }

    /**
     * tries to move the animals in the game
     *
     * @param position the position where you want the animal to go
     * @param direction the direction in which the animal has to move.
     */
    @Override
    public void move(Position position, Direction direction
    ) {
        if (animals == null || board == null) {
            throw new IllegalStateException("the game was not started yet");
        }
        for (Animal a : animals) {
            if (a.getPositionOnBoard().equals(position) && !a.isOnStar()) {
                Position new_pos = a.move(board, direction, animals);
                if (new_pos == null) {
                    // APA : Ce n'est pas une exception de tomber.
                    throw new IllegalStateException("move could not be made");
                }

            }
        }
    }

}
