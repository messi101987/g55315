package g55315.humbug.view.text;

import g55315.humbug.model.Animal;
import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
import g55315.humbug.model.Game;
import g55315.humbug.model.Position;

/**
 *
 * @author oscartison
 */
public interface InterfaceView {

    /**
     * prints the content of a Board
     *
     * @param board the board that needs to be displayed
     * @param animals the animals in the game board
     */
    void displayBoard(Board board, Animal... animals);

    /**
     * asks a position to the user.
     *
     * @return an object Position with the values given by the user.
     */
    Position askPosition();

    /**
     * asks a direction to the user
     *
     * @return the direction given by the user.
     */
    Direction askDirection();

    /**
     * displays an error message
     *
     * @param message the error message to display
     */
    void displayError(String message);

    /**
     * displays the remaining moves.
     *
     * @param game the game that is currently played
     */
    void displayRemainingMoves(Game game);
}
