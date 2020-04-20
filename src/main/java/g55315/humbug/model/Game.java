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
     * the remaining moves of the level
     */
    private int remainingMoves;

    /**
     * the current level
     */
    private int currentLevel;

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
     * a getter for the remaining moves
     *
     * @return the remaining moves
     */
    @Override
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * checks the status of the level
     *
     * @return win if the game is won, in_progress if it is still in progress,
     * fail if the game was lost and not_started if it was not started yet.
     */
    @Override
    public LevelStatus getLevelStatus() {
        LevelStatus status;
        if (animals == null || board == null) {
            status = LevelStatus.NOT_STARTED;
        } else {
            boolean fell = false;
            for (Animal a : animals) {
                if (a.getPositionOnBoard() == null) {
                    fell = true;
                }
            }
            if (fell) {
                status = LevelStatus.FAIL;
            } else {
                boolean over = true;
                for (Animal a : animals) {
                    if (!a.isOnStar()) {
                        over = false;
                    }
                }
                if (over) {
                    status = LevelStatus.WIN;
                } else if (remainingMoves == 0) {
                    status = LevelStatus.FAIL;
                } else {
                    status = LevelStatus.IN_PROGRESS;
                }
            }
        }
        return status;
    }

    /**
     * starts the game at a certain level
     *
     * @param level the chosen level
     */
    @Override
    public void startLevel(int level) {
        Level l = Level.getLevel(level);
        this.board = l.getBoard();
        this.animals = l.getAnimals();
        this.remainingMoves = l.getnMoves();
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
     * decrements the remaining moves
     */
    @Override
    public void decrRemainingMoves(){
        this.remainingMoves--;
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
        if (getLevelStatus() == LevelStatus.IN_PROGRESS) {
            for (Animal a : animals) {
                if (a.getPositionOnBoard().equals(position) && !a.isOnStar()) {
                    Position pos = a.move(board, direction, animals);
                }
            }
        } else {
            throw new IllegalArgumentException("Game is not in progress");
        }
    }

}
