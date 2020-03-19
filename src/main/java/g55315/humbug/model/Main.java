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
public class Main {

    public static void main(String[] args) {
        Board b = Board.getInitialBoard();
        System.out.println(b.isInside(new Position(0, 0)));

        Board p = new Board(new Square[][]{
            {new Square(SquareType.GRASS), new Square(SquareType.GRASS), null},
            {null, new Square(SquareType.GRASS), new Square(SquareType.GRASS)},
            {null, null, new Square(SquareType.STAR)}
        });
        
        System.out.println(p.getNbRow());
    }

}
