package g55315.humbug.view.text;

import g55315.humbug.model.Animal;
import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
import g55315.humbug.model.Game;
import g55315.humbug.model.Position;
import g55315.humbug.model.SquareType;
import java.util.Scanner;

/**
 *
 * @author oscartison
 */
public class View implements InterfaceView {

    /**
     * makes a 2D array of Strings of the game board
     *
     * @param board the board that needs to be changed in an array
     * @param animals the animals on the board
     * @return the 2d array of Strings
     */
    public static String[][] makeStringBoard(Board board, Animal... animals) {
        String[][] boardString = new String[4 * board.getNbRow() + 1][4 * board.getNbColumn() + 1];
        for (String[] boardString1 : boardString) {
            for (int j = 0; j < boardString[0].length; j++) {
                boardString1[j] = " ";
            }
        }
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int j = 0; j < board.getNbColumn(); j++) {
                Position pos = new Position(i, j);
                if (board.isInside(pos)) {
                    int pos_col = j * 4;
                    int pos_row = i * 4;
                    for (int x = 0; x < 5; x++) {
                        boardString[pos_row][pos_col + x] = "\033[42;38;1m-\033[0m";
                    }
                    pos_row++;
                    for (int y = 0; y < 3; y++) {
                        for (int x = 0; x < 5; x++) {
                            if ((pos_col + x) % 4 == 0) {
                                boardString[pos_row][pos_col + x] = "\033[42;38;1m|\033[0m";
                            } else {
                                boardString[pos_row][pos_col + x] = "\033[42;38;1m \033[0m";
                            }
                        }
                        pos_row++;
                    }
                    for (int x = 0; x < 5; x++) {
                        boardString[pos_row][pos_col + x] = "\033[42;38;1m-\033[0m";
                    }
                    for (Animal a : animals) {
                        if (a.getPositionOnBoard().equals(pos) && !a.isOnStar()) {
                            boardString[i * 4 + 2][j * 4 + 2] = "\033[42;38;1m" + a.toString() + "\033[0m";
                        }
                    }
                    if (board.getSquareType(pos) == SquareType.STAR) {
                        boardString[i * 4 + 2][j * 4 + 2] = "\033[42;38;1m\033[31m*\033[30m\033[0m";
                    }

                    if (board.hasSquareWallDirection(pos, Direction.NORTH)) {
                        boardString[i * 4 + 1][j * 4 + 2] = "\033[41;38;1m \033[0m";
                    }
                    if (board.hasSquareWallDirection(pos, Direction.SOUTH)) {
                        boardString[i * 4 + 3][j * 4 + 2] = "\033[41;38;1m \033[0m";
                    }
                    if (board.hasSquareWallDirection(pos, Direction.WEST)) {
                        boardString[i * 4 + 2][j * 4 + 1] = "\033[41;38;1m \033[0m";
                    }
                    if (board.hasSquareWallDirection(pos, Direction.EAST)) {
                        boardString[i * 4 + 2][j * 4 + 3] = "\033[41;38;1m \033[0m";
                    }
                }
            }
        }
        return boardString;
    }

    /**
     * prints the content of a Board
     *
     * @param board the board that needs to be displayed
     * @param animals the animals in the game board
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] boardString = makeStringBoard(board, animals);
        for (int i = 0; i < boardString.length; i++) {
            for (int j = 0; j < boardString[0].length; j++) {
                System.out.print(boardString[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * displays an error message
     *
     * @param message the error message to display
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * displays the remaining moves.
     */
    @Override
    public void displayRemainingMoves(Game game) {
        System.out.println(game.getRemainingMoves() + " remaining move(s)");
    }

    /**
     * reads an integer from the user. (I had already written this code during
     * DEV1)
     *
     * @param message the message to show to ask an integer to the user
     * @return the integer given by the user
     */
    public int readInt(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.println(message);
        while (!clavier.hasNextInt()) {
            clavier.next();
            System.out.println("The given number is not an integer");
            System.out.println(message);
        }
        return clavier.nextInt();
    }

    /**
     * asks a position to the user.
     *
     * @return an object Position with the values given by the user.
     */
    @Override
    public Position askPosition() {
        int pos_x = readInt("please enter a row position ");
        int pos_y = readInt("Please enter an column position ");
        return new Position(pos_x, pos_y);
    }

    /**
     * asks a direction to the user
     *
     * @return the direction given by the user.
     */
    @Override
    public Direction askDirection() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Please enter a direction: ");
        String dir = clavier.next().toUpperCase();
        Direction d;
        while (!(dir.equals("NORTH") || dir.equals("SOUTH") || dir.equals("EAST") || dir.equals("WEST"))) {
            System.out.println("Wrong direction , please try again ");
            dir = clavier.next().toUpperCase();
        }
        switch (dir) {
            case "NORTH":
                d = Direction.NORTH;
                break;
            case "SOUTH":
                d = Direction.SOUTH;
                break;
            case "WEST":
                d = Direction.WEST;
                break;
            default:
                d = Direction.EAST;
                break;
        }
        return d;
    }

}
