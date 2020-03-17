package g55315.humbug.model;


/**
 *
 * @author oscartison
 */
public class Board {
    private Square[][] squares;
    
    Board(Square[][] board){
        squares = board;
    }
    
    public static Board getInitialBoard(){
        Square[][] tab = {{new Square(SquareType.GRASS),new Square(SquareType.GRASS), null}, 
                          {null,new Square(SquareType.GRASS),new Square(SquareType.GRASS)}, 
                          {null, null,new Square(SquareType.STAR)}}; 
        return new Board(tab);
    }
    
    public boolean isInside(Position pos){
        if(pos == null){
            throw new IllegalArgumentException("null is not a position");
        }
        return (squares[pos.getRow()][pos.getColumn()] != null);
    }
    
    public SquareType getSquareType(Position pos){
        if (!isInside(pos)){
            throw new IllegalArgumentException("Position is not inside the board");
        }
        return squares[pos.getRow()][pos.getColumn()].getType();
    }
    
    public int getNbRow(){
        return squares[0].length;
    }
    
    public int getNbColumn(){
        return squares.length;
    }
}
