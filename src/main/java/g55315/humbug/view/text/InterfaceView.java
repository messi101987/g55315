package g55315.humbug.view.text;

import g55315.humbug.model.Animal;
import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
import g55315.humbug.model.Position;

/**
 *
 * @author oscartison
 */
public interface InterfaceView {
    void displayBoard(Board board, Animal... animals);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
    
}
