package g55315.humbug.view.text;

import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
import g55315.humbug.model.Position;

/**
 *
 * @author oscartison
 */
public interface InterfaceView {
    void displayBoard(Board b);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
    
}
