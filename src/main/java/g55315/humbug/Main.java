package g55315.humbug;

import g55315.humbug.controller.Controller;
import g55315.humbug.model.Game;
import g55315.humbug.view.text.View;

/**
 * the main method of the whole game, it creates a new controller with a Game
 * and View for the game, and then starts the game.
 *
 * @author oscartison
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame(1);
    }
}
