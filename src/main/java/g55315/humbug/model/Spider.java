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
public class Spider extends Animal {

    public Spider(Position pos) {
        super(pos);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = this.getPositionOnBoard();
        while (isNextFree(pos, direction, animals) && board.isInside(pos)) {
            pos = this.getPositionOnBoard().next(direction);
            this.setPositionOnBoard(pos);

        }
        if (!board.isInside(pos)) {
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
