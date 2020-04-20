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
public class Level {

    final private Board board;

    final private Animal[] animals;

    final private int nMoves;

    /**
     * a constructor for the class Level
     *
     * @param board a certain board for a level
     * @param animals the array of animals of a level
     * @param nMoves the number of moves for a level
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * a simple getter for the board
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * computes levels between 1 and 3
     * @param n the level you want to create
     * @return the initialised level
     */
    public static Level getLevel(int n) {
        Board b;
        int moves;
        Level lev;
        switch (n) {
            case 1:
                {
                    b = Board.getInitialBoard();
                    Animal[] animals = {new Snail(new Position(0, 0))};
                    moves = 4;
                    lev = new Level(b, animals, moves);
                    break;
                }
            case 2:
                {
                    Square[][] tab = {{new Square(SquareType.GRASS), new Square(SquareType.GRASS), null},
                        {null, new Square(SquareType.STAR), null},
                        {new Square(SquareType.STAR), new Square(SquareType.GRASS), new Square(SquareType.STAR)},
                        {null, new Square(SquareType.GRASS), null}};
                    b = new Board(tab);
                    Animal[] animals = {new Snail(new Position(0, 0)), new Snail(new Position(2, 1)), new Snail(new Position(3, 1))};
                    moves = 5;
                    lev = new Level(b, animals, moves);
                    break;
                }
            case 3:
                {
                    Square sqN = new Square(SquareType.GRASS);
                    sqN.setNorthWall(true);
                    Square sqE = new Square(SquareType.GRASS);
                    sqE.setEastWall(true);
                    Square sqS = new Square(SquareType.GRASS);
                    sqS.setSouthWall(true);
                    Square sqW = new Square(SquareType.STAR);
                    sqW.setWestWall(true);
                    Square[][] tab = {{sqN, new Square(SquareType.GRASS) , sqE},
                        {new Square(SquareType.GRASS), null, new Square(SquareType.GRASS)},
                        {new Square(SquareType.GRASS), null, new Square(SquareType.GRASS)},
                        {sqW, new Square(SquareType.GRASS), sqS}};
                    b = new Board(tab);
                    Animal[] animals = {new Spider(new Position(2, 0))};
                    moves = 4;
                    lev = new Level(b, animals, moves);
                    break;
                }
            default:
                throw new IllegalArgumentException("not possible yet");
        }
        return lev;
    }

    /**
     * a simple getter for the animals in a level
     *
     * @return an array of animals
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * a simple getter for the number of moves of a level
     *
     * @return the number of moves.
     */
    public int getnMoves() {
        return nMoves;
    }

}
