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
public abstract class Animal {
    private Position positionOnBoard;
    private boolean onStar;
    
    public Animal(Position position){
        this.positionOnBoard = position;
        this.onStar = false;
    }

    public Position getPositionOnBoard() {
        return positionOnBoard;
    }
    
    public boolean isOnStar() {
        return onStar;
    }

    public void setPositionOnBoard(Position poisitonOnBoard) {
        this.positionOnBoard = poisitonOnBoard;
    }

    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }
    
    public abstract Position move(Board board, Direction direction, Animal... animals);
    
    
}
