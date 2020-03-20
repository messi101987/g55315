package g55315.humbug.model;

/**
 * an abstract class Animal
 *
 * @author oscartison
 */
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * the constructor of the class
     *
     * @param position the position of the animal when it's initialized
     */
    public Animal(Position position) {
        this.positionOnBoard = position;
        this.onStar = false;
    }

    /**
     * a simple getter for the position of the animal
     *
     * @return the current position of the animal
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * a simple getter to check if the animal is located on a star.
     *
     * @return true if it is on a star, false otherwise
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * a setter for the position of the animal.
     *
     * @param poisitonOnBoard the new position of the animal
     */
    public void setPositionOnBoard(Position poisitonOnBoard) {
        this.positionOnBoard = poisitonOnBoard;
    }

    /**
     * a setter to set onStar on true or false
     *
     * @param onStar true or false
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * checks if the next position of an animal is free
     *
     * @param pos the current position of the animal.
     * @param direction the direction in which the animal will try to move
     * @param animals an array of the other animals on the board
     * @return true if the next position is free, false otherwise
     */
    public boolean isNextFree(Position pos, Direction direction, Animal... animals) {
        boolean move = true;
        for (Animal a : animals) {
            if (a.getPositionOnBoard().equals(pos.next(direction))) {
                move = false;
            } else {
                move = move && true;
            }
        }
        return move;
    }

    public abstract Position move(Board board, Direction direction, Animal... animals);

}
