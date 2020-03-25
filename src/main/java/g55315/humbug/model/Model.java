/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug.model;

/**
 *
 * @author oscartison
 */
public interface Model {
    Board getBoard();
    Animal[] getAnimals();
    void startLevel(int level);
    boolean levelIsOver();
    void move(Position position, Direction direction);
    
}
