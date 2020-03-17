package g55315.humbug.model;


import g55315.humbug.model.SquareType;


/** 
 * * Square on the board. A square has a type grass or star and it’s all.
 * * A square doesn’t know where it is on the board.
 * *
 * * @author Oscar Tison
 *  */
public class Square {

    private SquareType type;

    /**
     * Constructor of Square on board. 
     * @param type Square is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Simple getter of type. 
     * @return type of Square
     */
    public SquareType getType() {
        return type;
    }
}
