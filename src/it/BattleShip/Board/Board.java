package it.BattleShip.Board;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {
    private char[][] field;
    private char water = '-';
    private char occupato = 'D';
    private char notHitted = 'O';
    private char hitted = 'X';
    int length;



    public Board(int length){
        this.length = length;
        field = new char[length][length];
        this.field = makeField();

    }
    /*
    @output: fill all field with water char
     */
    private char[][] makeField() {

        for (char[] row : field){
            Arrays.fill(row, water);
        }
        return field;
    }

    public void showField(Board board){
        for (int i = 0; i<length; i++){
            for (int j = 0; j<length; j++){
                if (j == length-1){
                    System.out.println(field[i][j]);
                } else {
                    System.out.print(field[i][j]);
                }
            }
        }

    }
    /*
    input: coordinate, nave da collocare
    processing: piazzo automanticamente le navi se mi trovo nei casi
    output: la stessa Board con la nave piazzata
    tip: sta roba si può assolutamente migliorare e devo farlo perchè fa veramente schifo è illegibile
     */
    public void placeShip(int[] coordinate, Ship ship){
        if (ship.getDirection() == Ship.Direction.HORIZONTAL && coordinate[1] == length-1 && isFree(coordinate[0], coordinate[1])){
           field[coordinate[0]][coordinate[1]] = occupato;
           field[coordinate[0]][coordinate[1]-1] = occupato;
        } else if(ship.getDirection() == Ship.Direction.VERTICAL && coordinate[0] == length-1 && isFree(coordinate[0], coordinate[1])){
            field[coordinate[0]][coordinate[1]] = occupato;
            field[coordinate[0]-1][coordinate[1]] = occupato;
        } else {
            if (isFree(coordinate[0], coordinate[1]) && ship.getDirection() == Ship.Direction.HORIZONTAL){
                field[coordinate[0]][coordinate[1]] = occupato;
                field[coordinate[0]][coordinate[1]-1] = occupato;

            } else if(isFree(coordinate[0], coordinate[1]) && ship.getDirection() == Ship.Direction.VERTICAL){
                field[coordinate[0]][coordinate[1]] = occupato;
                field[coordinate[0]-1][coordinate[1]] = occupato;
            } else {
                System.out.println("La nave non può essere piazzata");
            }
        }
    }

    /*
    input: coordinate
    output: true if hitted a ship, else false
     */
    public boolean isHitted(int i, int j){
        if (field[i][j] == water){
            return false;
        } else if(field[i][j] == hitted){
            return false;
        } else if( field[i][j] == notHitted){
            return false;
        }
         else {
             return true;
        }
    }
    /*
    @input: coordinate
    @output: true if there is no ship
     */
    private boolean isFree(int i, int j){
        if (field[i][j] == water){
            return  true;
        } else return  false;
    }

    public void removeShip(int[] coordinate){
        if(isHitted(coordinate[0], coordinate[1])){
            field[coordinate[0]][coordinate[1]] = water;
        }
    }


}
