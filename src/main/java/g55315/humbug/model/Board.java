package g55315.humbug.model;

/**
 * the board of the game
 *
 * @author oscartison
 */
public class Board {

    private Square[][] squares;

    /**
     * constructor of the class Board
     *
     * @param board a 2d array
     */
    public Board(Square[][] board) {
        this.squares = board;
    }

    /**
     * constructor of the class Board
     *
     */
    public Board() {
        this.squares = null;
    }

    /**
     * initialises the board for the first level
     *
     * @return the new board
     */
    public static Board getInitialBoard() {
        Square[][] tab = {{new Square(SquareType.GRASS), new Square(SquareType.GRASS), null},
        {null, new Square(SquareType.GRASS), new Square(SquareType.GRASS)},
        {null, null, new Square(SquareType.STAR)}};
        return new Board(tab);
    }

    /**
     * checks is there is a Square in a given position
     *
     * @param pos the position that needs to be checked
     * @return true if there is a square, false if not
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("null is not a position");
        }
        if (pos.getRow() < 0 || pos.getColumn() < 0 || pos.getColumn() >= getNbColumn() || pos.getRow() >= getNbRow()) {
            return false;
        }
        return (this.squares[pos.getRow()][pos.getColumn()] != null);
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
            if (!a.isOnStar() && a.getPositionOnBoard().equals(pos.next(direction))) {
                move = false;
            }
        }
        return move;
    }

    /**
     * checks if the next position is in the board
     *
     * @param pos the current position
     * @param dir the direction in which the animal tries to move
     * @return true if the next position is in the board, false if not.
     */
    boolean isNextInBoard(Position pos, Direction dir) {
        return isInside(pos.next(dir));
    }

    /**
     * checks if there is a wall in a certain direction
     *
     * @param pos the position that needs to be checked
     * @param dir the direction in which we have to check for a wall.
     * @return true if there is a wall in that direction, false otherwhise
     */
    public boolean isNextWall(Position pos, Direction dir) {
        return (squares[pos.getRow()][pos.getColumn()].hasWall(dir))
                || (isNextInBoard(pos, dir)
                && squares[pos.next(dir).getRow()][pos.next(dir).getColumn()].hasWall(dir.opposite()));
    }

    /**
     * checks if a square at a position has a wall in a certain direction
     *
     * @param pos the position of the square we want to check
     * @param dir the direction in which we want to check
     * @return true if there is a wall in that direction, false if not
     */
    public boolean hasSquareWallDirection(Position pos, Direction dir) {
        return squares[pos.getRow()][pos.getColumn()].hasWall(dir);
    }

    /**
     * returns the type of a Square in a given position
     *
     * @param pos the Position of the Square.
     * @return the type of the Square
     */
    public SquareType getSquareType(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Position is not inside the board");
        }
        return this.squares[pos.getRow()][pos.getColumn()].getType();
    }

    public void setSquareGrass(Position pos) {
        this.squares[pos.getRow()][pos.getColumn()] = new Square(SquareType.GRASS);
    }

    /**
     *
     * @return
     */
    public int getNbRow() {
        return this.squares.length;
    }

    public int getNbColumn() {
        return this.squares[0].length;
    }

    public Square[][] getSquares() {
        return squares;
    }

}
