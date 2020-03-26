package g55315.humbug.model;

/**
 * the class game implements the interface Model
 * @author oscartison
 */
public class Game implements Model {
    
    /**
     * this is 
     */
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
        if (animals == null || board == null){
            throw new IllegalStateException("the game was not started yet");
        }
        boolean over = true;
        for (Animal a : animals) {
            if (a.isOnStar()) {
                over = over && true;
            } else {
                over = false;
            }
        }
        return over;
    }

    @Override
    public void move(Position position, Direction direction) {
        if (animals == null || board == null){
            throw new IllegalStateException("the game was not started yet");
        }
        for (Animal a : animals) {
            Position new_pos = a.move(board, direction, animals);
            if (new_pos.equals(position)){
                a.setPositionOnBoard(new_pos);
            }
        }
    }

}
