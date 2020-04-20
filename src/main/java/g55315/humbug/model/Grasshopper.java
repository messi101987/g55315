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
public class Grasshopper extends Animal {

    /**
     * a constructor for the grasshoper
     *
     * @param pos the position in which the grasshoper is created
     */
    public Grasshopper(Position pos) {
        super(pos);
    }

    /**
     * a constructor for the grasshoper
     */
    public Grasshopper() {
        super();
    }

    /**
     * moves the Grasshoper
     *
     * @param board the board on which the grasshoper is
     * @param direction the direction in which it will move
     * @param animals the animals on the board
     * @return the new position of the grasshoper
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = moveOneJumping(board, direction, animals);
        if (this.getPositionOnBoard() != null && board.getSquareType(this.getPositionOnBoard()) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(this.getPositionOnBoard());
        }
        return pos;
    }

    /**
     * returns the sign to print on the board
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "G";
    }

}
