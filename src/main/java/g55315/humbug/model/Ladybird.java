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
public class Ladybird extends Animal {

    /**
     * the constructor for the ladybird
     *
     * @param pos the position in which the ladybird is created
     */
    public Ladybird(Position pos) {
        super(pos);
    }

    /**
     * the constructor for the ladybird
     */
    public Ladybird() {
        super();
    }

    /**
     * moves the ladybird 2 squares and stops before if there is an obstacle
     *
     * @param board the board on which the ladybird is
     * @param direction the direction in which it will move
     * @param animals the animals on the board.
     * @return the new position of the ladybird
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        for (int i = 0; i < 2; i++) {
            pos = moveOneCrawling(board, direction, animals);
            if(pos == null){
                i = 2;
            }
        }
        if (this.getPositionOnBoard() != null && board.getSquareType(this.getPositionOnBoard()) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(this.getPositionOnBoard());
        }

        return pos;
    }

    /**
     * returns the string that will be printed on the board
     *
     * @return the string that will be printed on the board
     */
    @Override
    public String toString() {
        return "\uD83D\uDC1E";
    }

}
