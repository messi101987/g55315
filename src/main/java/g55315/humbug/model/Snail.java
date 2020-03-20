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
public class Snail extends Animal {

    public Snail(Position pos) {
        super(pos);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        if (board.isInside(pos.next(direction))) {
            if (isNextFree(pos, direction, animals)) {
                pos = this.getPositionOnBoard().next(direction);
                this.setPositionOnBoard(pos);
            }
        } else {
            pos = null;
            this.setPositionOnBoard(null);
        }
        if (board.getSquareType(pos) == SquareType.STAR) {
            this.setOnStar(true);
            board.setSquareGrass(pos);
        }
        return pos;
    }

}
