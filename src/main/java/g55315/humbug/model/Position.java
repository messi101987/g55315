/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug.model;

import java.util.Objects;

/**  
 * this makes a Position out of the row and column where you are situated
 * 
 * @author oscartison
 */
public class Position {
    final private int row;
    final private int column;
    
    /**
     * Constructor of Position.
     * @param row the value of the row
     * @param column the value of the column 
     */
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    /**
     * a simple getter for the column
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * a simple getter for the row
     * @return the value of row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * computes the next position according to a Direction
     * @param d the direction in which the position moves
     * @return the new Position
     */
    public Position next(Direction d){
        return new Position(row + d.getDeltaRow(), column + d.getDeltaColumn());
    }
    
    /**
     * Checks if an object is equal to this Position
     * @param obj the object that what we will compare this Position
     * @return true is they have the same position, false if not 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        return row == other.row && column == other.column;
    }
    /**
     * Hashes an objet of the class Position
     * @return the hashed object
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "row: " + row + ", column: " + column;
    }
    
    
    
    

    
}
