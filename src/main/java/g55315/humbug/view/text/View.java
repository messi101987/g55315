package g55315.humbug.view.text;

import g55315.humbug.model.Animal;
import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
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
     * @param board the board that needs to  be changed in an array
     * @return the 2d array of Strings
     */
    public static String[][] makeStringBoard(Board board){
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
        String[][] boardString = makeStringBoard(board);
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int x = 0; x < 5; x++) {
                for (int j = 0; j < board.getNbColumn(); j++) {
                    String star;

                    if (boardString[i][j].equals("star") && x == 1) {
                        star = "\033[31m*\033[30m";
                    } else {
                        star = " ";
                    }
                    if (x == 1) {
                        for (Animal a : animals) {
                            if (a.getPositionOnBoard().equals(new Position(i, j))) {
                                star = a.toString();
                            }
                        }
                    }

                    if (x == 4 || (x == 0 && i == 0)) {
                        if (i == board.getNbRow() - 1) {
                            if (!boardString[i][j].equals("null")) {
                                System.out.print("\033[42;38;1m------\033[0m");
                            } else {
                                System.out.print("      ");
                            }
                        } else if (!boardString[i][j].equals("null") || (x == 4 && !boardString[i + 1][j].equals("null"))) {
                            System.out.print("\033[42;38;1m------\033[0m");

                        } else {
                            System.out.print("      ");
                        }
                    } else {
                        if (!boardString[i][j].equals("null")) {
                            if (j != 0 && !boardString[i][j - 1].equals("null")) {
                                System.out.print("\033[42;38;1m " + star + "  |\033[0m");
                            } else {
                                System.out.print("\033[42;38;1m|  " + star + " |\033[0m");
                            }

                        } else {
                            System.out.print("      ");
                        }

                    }
                }
                System.out.println("");
            }
        }
    }
   

    /**
     * displays an error message
     *
     * @param message the error message to display
     */
    @Override
    public void displayError(String message) {
        System.out.println("message");
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
        int pos_x = readInt("please enter a x position ");
        int pos_y = readInt("Please enter an y position ");
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
        String dir = clavier.next();
        Direction d;
        while (!(dir.equals("NORTH") || dir.equals("SOUTH") || dir.equals("EAST") || dir.equals("WEST"))) {
            System.out.println("Wrong direction , please try again ");
            dir = clavier.next();
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
