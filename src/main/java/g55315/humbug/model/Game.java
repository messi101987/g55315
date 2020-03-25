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
public class Game implements Model {

    private Board board;

    private Animal[] animals;

    @Override
    public Board getBoard() {
        return this.board;
    }

    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    @Override
    public void startLevel(int level) {
        Animal[] an = {new Snail(new Position(0, 0))};
        if (level == 1) {
            this.board = Board.getInitialBoard();
            this.animals = an;
        }
    }

    @Override
    public boolean levelIsOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Position position, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
