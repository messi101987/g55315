/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug.main;

import g55315.humbug.controller.Controller;
import g55315.humbug.model.Game;
import g55315.humbug.view.text.View;

/**
 *
 * @author oscartison
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
