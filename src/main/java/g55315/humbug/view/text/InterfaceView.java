/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
