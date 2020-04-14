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

    /**
     * a simple getter for the board
     *
     * @return the board
     */
    Board getBoard();

    /**
     * a simple getter for the array of animals
     *
     * @return the array of animals
     */
    Animal[] getAnimals();

    /**
     * starts the game at a certain level
     *
     * @param level the chosen level
     */
    void startLevel(int level);

    /**
     * controls if the level is over or not
     *
     * @return true if the level is over, false if not
     */
    boolean levelIsOver();

    /**
     * checks if there is an animal at a certain position
     *
     * @param pos the position where we check if there is an animal
     * @return true if there is an animal at this position, false if not
     */
    boolean isAnimalPos(Position pos);

    /**
     * tries to move the animals in the game
     *
     * @param position the position where you want the animal to go
     * @param direction the direction in which the animal has to move.
     */
    void move(Position position, Direction direction);

}
