package g55315.humbug.model;

import g55315.humbug.view.text.InterfaceView;

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
        return this.squares[0].length;
    }

    public int getNbColumn() {
        return this.squares.length;
    }

    public static void displayBoard(Board board) {
        String[][] boardString = new String[board.getNbRow()][board.getNbColumn()];
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int j = 0; j < board.getNbColumn(); j++) {
                Position pos = new Position(i, j);
                if (board.isInside(pos)) {
                    if (board.getSquareType(pos) == SquareType.GRASS) {
                        boardString[i][j] = "grass";
                    } else if (board.getSquareType(pos) == SquareType.STAR) {
                        boardString[i][j] = "star";

                    }
                } else {
                    boardString[i][j] = "null";
                }
            }
        }
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int x = 0; x < 5; x++) {
                for (int j = 0; j < board.getNbColumn(); j++) {
                    String star = "";
                    if (boardString[i][j].equals("star")) {
                        star = "*";
                    } else {
                        star = "";
                    }

                    if (x == 4 || x == 0) {
                        if (!boardString[i][j].equals("null") || (x == 4 && !boardString[i + 1][j].equals("null"))) {
                            System.out.print("\033[42;38;1m----\033[0m");

                        } else {
                            System.out.print("     ");
                        }
                    } else if (x != 4) {
                        if (!boardString[i][j].equals("null")) {
                            if (j != 0 && !boardString[i][j - 1].equals("null")) {
                                System.out.print("\033[42;38;1m " + star + "  |\033[0m");
                            } else {
                                System.out.print("\033[42;38;1m| " + star + "  |\033[0m");
                            }

                        } else {
                            System.out.print("    ");
                        }

                    }
                }
                System.out.println("");
                }
            }
        }

    

    public static void main(String[] args) {
        Board b = getInitialBoard();
        displayBoard(b);
    }
}
