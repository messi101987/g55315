package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public class Grasshopper extends Animal {

    /**
     * a constructor for the grasshoper
     *
     * @param pos the position in which the grasshoper is created
     */
    public Grasshopper(Position pos) {
        super(pos);
    }

    /**
     * a constructor for the grasshoper
     */
    public Grasshopper() {
        super();
    }

    /**
     * moves the Grasshoper
     *
     * @param board the board on which the grasshoper is
     * @param direction the direction in which it will move
     * @param animals the animals on the board
     * @return the new position of the grasshoper
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.moveOneAerial(board, direction, animals);
        setOnStar(board, pos);
        return pos;
    }

    /**
     * returns the sign to print on the board
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "\uD83E\uDD97";
    }

}
