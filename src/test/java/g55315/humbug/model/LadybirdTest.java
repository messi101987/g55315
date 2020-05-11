package g55315.humbug.model;

import static g55315.humbug.model.SquareType.GRASS;
import static g55315.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadybirdTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), null, new Square(STAR), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Ladybird(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 2));
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        animals[1].setPositionOnBoard(new Position(0, 2));
        Ladybird instance = (Ladybird) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_wall() {
        System.out.println("move, and go to a wall on square");
        board.getSquares()[0][1].setWestWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_wall_same() {
        System.out.println("move, and go to a wall on same square");
        board.getSquares()[0][0].setEastWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

}
