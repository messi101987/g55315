package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public class Spider extends Animal {

    /**
     * a constructor for the class Spider
     *
     * @param pos the position on which the spider is created
     */
    public Spider(Position pos) {
        super(pos);
    }

    /**
     * moves the spider in a certain direction if possible
     *
     * @param board the board on which the spider is located
     * @param direction the direction in which the spider tries to move
     * @param animals an array of the other animals on the board
     * @return the new position of the spider
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        while (isNextFree(pos, direction, animals) && board.isInside(pos)) {
            pos = this.getPositionOnBoard().next(direction);
            this.setPositionOnBoard(pos);

        }
        if (!board.isInside(pos)) {
            pos = null;
            this.setPositionOnBoard(null);
        }
        if (board.getSquareType(pos) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(pos);
        }
        return pos;
    }

}
