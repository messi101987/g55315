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

    public Ladybird(Position pos) {
        super(pos);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        for (int i = 0; i < 2; i++) {
            pos = moveOneCrawling(board, direction, animals);
        }
        if (pos != null && board.getSquareType(pos) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(pos);
        }

        return pos;
    }

    @Override
    public String toString() {
        return "Q";
    }

}
