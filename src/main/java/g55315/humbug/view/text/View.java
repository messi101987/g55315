/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.humbug.view.text;

import g55315.humbug.model.Board;
import g55315.humbug.model.Direction;
import g55315.humbug.model.Position;
import g55315.humbug.model.SquareType;
import java.util.Scanner;

/**
 *
 * @author oscartison
 */
public class View {

    /**
     * prints the content of a Board
     * @param board the board that needs to be displayed
     */
    public static void displayBoard(Board board) {
        String[][] boardString = new String[board.getNbRow()][board.getNbColumn()];
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int j = 0; j < board.getNbColumn(); j++) {
                Position pos = new Position(i, j);
                if (board.isInside(pos)) {
                    if (board.getSquareType(pos) == SquareType.GRASS) {
                        boardString[i][j] = "grass ";
                    } else if (board.getSquareType(pos) == SquareType.STAR) {
                        boardString[i][j] = "star ";

                    }
                } else {
                    boardString[i][j] = "      ";
                }
            }
        }
        int col = 0;
        int row = 0;
        for (int i = 0; i < board.getNbColumn() * board.getNbRow(); i++) {
            System.out.print(boardString[row][col]);
            col = col + 1;
            if (col == board.getNbColumn()) {
                col = 0;
                row = row + 1;
                System.out.println("");
            }
        }
    }
    
    /**
     * displays an error message
     * @param message the error message to display
     */
    public void displayError(String message){
        System.out.println("message");
    }
    
    /**
     * reads an integer from the user.
     * @param message the message to show to ask an integer to the user
     * @return the integer given by the user
     */
    public static int readInt(String message) {
        Scanner clavier = new Scanner(System.in); 
        System.out.println(message);
        while(!clavier.hasNextInt()) { 
            clavier.next(); 
            System.out.println("The given number is not an integer"); 
            System.out.println(message);
        }
        return clavier.nextInt();
    }
    
    /**
     * asks a position to the user.
     * @return an object Position with the values given by the user.
     */
    public Position askPosition(){
        int pos_x = readInt("please enter a x value ");
        int pos_y = readInt("Please enter an y value ");
        return new Position(pos_x, pos_y);
        }
    
    /**
     * asks a direction to the user
     * @return the direction given by the user.
     */
    public static Direction askDirection(){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez entrer une direction: ");
        String dir = clavier.next();
        Direction d;
        while(!(dir.equals("NORTH") || dir.equals("SOUTH") || dir.equals("EAST") || dir.equals("WEST"))){
            System.out.println("Direction incorrecte, veuillez ressayer. ");
            dir = clavier.next();
        }
        switch(dir){
            case "NORTH":
                    d = Direction.NORTH;
                    break;
            case "SOUTH":
                    d = Direction.SOUTH;
                    break;
            case "WEST":
                    d = Direction.WEST;
                    break;
            default:
                    d = Direction.EAST;
                    break;
        }
        return d;
    }
    
    
    public static void main(String[] args) {
        askDirection();
    }

}
