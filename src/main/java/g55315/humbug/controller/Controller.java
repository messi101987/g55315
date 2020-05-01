package g55315.humbug.controller;

import g55315.humbug.model.Direction;
import g55315.humbug.model.Game;
import g55315.humbug.model.LevelStatus;
import g55315.humbug.model.Model;
import g55315.humbug.model.Position;
import g55315.humbug.view.text.InterfaceView;
import g55315.humbug.view.text.View;

/**
 *
 * @author oscartison
 */
public class Controller {

    Model game;
    InterfaceView view;

    /**
     * constructor of the game
     *
     * @param game the game created you want to use
     * @param view the view you want to use
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * starts the game by initializing it on level 1, and starts a game loop
     *
     * @param nLevel the level you want to play
     */
    public void startGame(int nLevel) {
        game.startLevel(nLevel);
        while (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
            view.displayRemainingMoves((Game) game);
            view.displayBoard(game.getBoard(), game.getAnimals());
            Position pos = view.askPosition();
            while (!game.isAnimalPos(pos)) {
                view.displayError("there is no animal at this position, try again");
                pos = view.askPosition();
            }
            Direction dir = view.askDirection();

            game.move(pos, dir);
            game.decrRemainingMoves();

        }
        if (game.getLevelStatus() == LevelStatus.WIN) {
            view.displayError("You've won!");
            try {
                startGame(++nLevel);
            } catch (Exception e) {
                view.displayError("Game is finished");
            }
        } else if (game.getLevelStatus() == LevelStatus.FAIL) {
            view.displayError("You've lost!");
            startGame(nLevel);
        }

    }
}
