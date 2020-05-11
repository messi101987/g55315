package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public class Bumbelbee extends Animal {

    /**
     * a constructor for the class Bumbelbee
     *
     * @param pos the position of the bumbelbee
     */
    public Bumbelbee(Position pos) {
        super(pos);
    }

    /**
     * a constructor for the class Bumbelbee
     */
    public Bumbelbee() {
        super();
    }

    /**
     * moves a bumbelbee 2 cases
     *
     * @param board the board on which the bumblebee is
     * @param direction the direction in which it has to move
     * @param animals the animals on the board
     * @return the new position of the bumbelbee
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        pos = pos.next(direction);
        this.setPositionOnBoard(pos);
        pos = this.moveOneAerial(board, direction, animals);
        setOnStar(board, pos);
        return pos;
    }

    /**
     *
     * @return the string printed on the board
     */
    @Override
    public String toString() {
        return "\uD83D\uDC1D";
    }

}
