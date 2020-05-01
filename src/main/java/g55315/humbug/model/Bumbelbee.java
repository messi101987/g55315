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
public class Bumbelbee extends Animal {

    public Bumbelbee(Position pos) {
        super(pos);
    }

    public Bumbelbee() {
        super();
    }

    /**
     * moves a bumbelbee 2 cases
     *
     * @param board the board on which the bumblebee is
     * @param direction the direction in which it has to move
     * @param animals the animals on the board
     * @return the new position of the bumbelbee
     */ 
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        pos = pos.next(direction);
        this.setPositionOnBoard(pos);
        pos = this.moveOneFlying(board, direction, animals);
        if (pos != null && board.getSquareType(pos) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(this.getPositionOnBoard());
        }
        return pos;
    }

    /**
     *
     * @return the string printed on the board
     */
    @Override
    public String toString() {
        return "B";
    }

}
