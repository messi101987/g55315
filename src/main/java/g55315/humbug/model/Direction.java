package g55315.humbug.model;

/**
 * Direction in which an animal moves
 *
 * @author oscartison
 */
public enum Direction {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);

    final private int deltaRow;
    final private int deltaColumn;

    /**
     * Constructor of the class Direction
     *
     * @param deltaRow the change in rows of the movement
     * @param deltaColumn the change in columns of the movement
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    /**
     * a simple getter
     *
     * @return the value of deltaColumn
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * a simple getter
     *
     * @return the value of deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * gives the opposite direction
     * @return the opposite of the current direction
     */
    public Direction opposite() {
        Direction d;
        switch (this) {
            case NORTH:
                d = SOUTH;
                break;
            case SOUTH:
                d = NORTH;
                break;
            case EAST:
                d = WEST;
                break;
            default:
                d = EAST;
        }
        return d;
    }

}
