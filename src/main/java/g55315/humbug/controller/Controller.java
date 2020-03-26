/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug.controller;

import g55315.humbug.model.Direction;
import g55315.humbug.model.Game;
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
    
    public Controller(Game game, View view){
        this.game = game;
        this.view = view;
    }
    
    public void startGame(){
        game.startLevel(1);
        while(!game.levelIsOver()){
            view.displayBoard(game.getBoard(), game.getAnimals());
            Position pos = view.askPosition();
            Direction dir = view.askDirection();
            try {
                                game.move(pos, dir);

            } catch(Exception e) {
                view.displayError("not moved");
            }
        }
    }
}
