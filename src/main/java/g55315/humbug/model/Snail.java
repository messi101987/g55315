package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public class Snail extends Animal {

    /**
     * a constructor for the class snail
     *
     * @param pos the position on which the snail is created
     */
    public Snail(Position pos) {
        super(pos);
    }

    /**
     * moves the snail in a certain direction if possible
     *
     * @param board the board on which the snail is located
     * @param direction the direction in which the snail tries to move
     * @param animals an array of the other animals on the board
     * @return the new position of the snail
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        if (board.isInside(pos.next(direction))) {
            if (isNextFree(pos, direction, animals)) {
                pos = this.getPositionOnBoard().next(direction);
                this.setPositionOnBoard(pos);
                // APA : **LA**
            }
        } else {
            pos = null;
            this.setPositionOnBoard(null);
        }
        if (pos != null && board.getSquareType(pos) == SquareType.STAR) {
            // APA : Pourquoi ne pas faire ça la **LA**
            this.setOnStar(true);
            board.setSquareGrass(pos);
        }
        return pos;
    }

    @Override
    public String toString() {
        return "@";
    }

}
