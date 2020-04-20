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
public class Butterfly extends Animal {

    /**
     * the constructor for the butterfly
     *
     * @param pos the position in which the ladybird is created
     */
    public Butterfly(Position pos) {
        super(pos);
    }

    /**
     * the constructor for the butterfly
     */
    public Butterfly() {
        super();
    }

    /**
     * moves the butterfly 2 squares and stops before if there is an obstacle
     *
     * @param board the board on which the butterfly is
     * @param direction the direction in which it will move
     * @param animals the animals on the board.
     * @return the new position of the ladybird
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        pos = pos.next(direction).next(direction);
        this.setPositionOnBoard(pos);
        pos = moveOneFlying(board, direction, animals);
        if (this.getPositionOnBoard() != null && board.getSquareType(this.getPositionOnBoard()) == SquareType.STAR) {
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
        return "8";
    }

}
