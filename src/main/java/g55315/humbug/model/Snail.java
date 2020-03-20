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
        int i = 0;
        while (animals[i] != this) {
            i++;
        }
        Animal snail = animals[i];
        Position pos = snail.getPositionOnBoard();
        boolean move = true;
        if (board.isInside(pos.next(direction))) {
            for (Animal a : animals) {
                if (a.getPositionOnBoard().equals(pos.next(direction))) {
                    move = false;
                } else {
                    move = move && true;
                }
            }
            if (move) {
                pos = snail.getPositionOnBoard().next(direction);
                snail.setPositionOnBoard(pos);
            }
        } else {
            pos = null;
            snail.setPositionOnBoard(null);
        }
        if (board.getSquareType(pos) == SquareType.STAR) {
            snail.setOnStar(true);
            board.setSquareGrass(pos);
        }
        return pos;
    }

}
