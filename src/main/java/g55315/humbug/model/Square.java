package g55315.humbug.model;

import g55315.humbug.model.SquareType;
import java.util.logging.Logger;

/**
 * 
 * Square on the board. A square has a type grass or star and it’s all. A square
 * doesn’t know where it is on the board.
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class Square {

    final private SquareType type;

    private boolean northWall;

    private boolean southWall;

    private boolean eastWall;

    private boolean westWall;

    /**
     * Constructor of Square on board. 
     *
     * @param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
        this.eastWall = false;
        this.westWall = false;
        this.northWall = false;
        this.southWall = false;
    }

    /**
     * Constructor of Square on board. 
     */
    public Square() {
        this.type = SquareType.GRASS;
        this.eastWall = false;
        this.westWall = false;
        this.northWall = false;
        this.southWall = false;
    }

    /**
     * a simple setter
     *
     * @param northWall the new boolean value
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * a simple setter
     *
     * @param southWall the new boolean value
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * a simple setter
     *
     * @param eastWall the new boolean value
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    /**
     * a simple setter
     *
     * @param westhWall the new boolean value
     */
    public void setWestWall(boolean westhWall) {
        this.westWall = westhWall;
    }

    /**
     * Simple getter of type. 
     *
     * @return type of Square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * checks if there is a wall in a certain direction
     *
     * @param d the direction that needs to be checked for a wall
     * @return true if there is a wall in that direction, false if not.
     */
    public boolean hasWall(Direction d) {
        boolean hasWall;
        switch (d) {
            case NORTH:
                hasWall = northWall;
                break;
            case SOUTH:
                hasWall = southWall;
                break;
            case EAST:
                hasWall = eastWall;
                break;
            default:
                hasWall = westWall;
        }
        return hasWall;
    }
}
