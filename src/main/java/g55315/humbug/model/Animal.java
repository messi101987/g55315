package g55315.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * an abstract class Animal
 *
 * @author oscartison
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})
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
     * the constructor of the class
     *
     * @param position the position of the animal when it's initialized
     */
    public Animal() {
        this.positionOnBoard = new Position();
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

    public abstract Position move(Board board, Direction direction, Animal... animals);

    /**
     * moves a jumping animal 1 square
     *
     * @param board the board in which the animal is
     * @param direction the direction in which it will move
     * @param animals the animals on the board
     * @return the new position of the animal
     */
    protected Position moveOneJumping(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        while (!board.isNextFree(pos, direction, animals)) {
            pos = pos.next(direction);
        }
        pos = pos.next(direction);
        if (!board.isInside(pos)) {
            pos = null;
        }
        this.setPositionOnBoard(pos);
        return pos;
    }

    /**
     * moves a crawling animal 1 square
     *
     * @param board the board in which the animal is
     * @param direction the direction in which it will move
     * @param animals the animals on the board
     * @return the new position of the animal
     */
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        if (board.isInside(pos.next(direction))) {
            if (board.isNextFree(pos, direction, animals) && !(board.isNextWall(pos, direction))) {
                pos = this.getPositionOnBoard().next(direction);
            }
        } else {
            pos = null;
        }
        this.setPositionOnBoard(pos);

        return pos;
    }

    protected Position moveOneFlying(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        while (!board.isNextFree(pos, direction, animals)) {
            pos = pos.next(direction);
        }
        pos = pos.next(direction);
        if (!board.isInside(pos)) {
            pos = null;
        }
        this.setPositionOnBoard(pos);
        return pos;
    }

}
