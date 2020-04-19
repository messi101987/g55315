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
public class Grasshopper extends Animal {

    
    public Grasshopper(Position pos){
        super(pos);
    }
    
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = moveOneJumping(board, direction, animals);
        return pos;
    }

    
    @Override
    public String toString() {
        return "G";
    }
    
    
    
    
}
