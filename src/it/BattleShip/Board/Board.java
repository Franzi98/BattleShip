package it.BattleShip.Board;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Board {

    private HashMap<Coordinate, Ship> field;

    public Board(){
        field=new HashMap<>();

    }
    /*
    add a ship on the field in key coordinate
    if a ship take more than one space, automatically place the rest of ship near user coordinate
     */
    public void addShip(Coordinate c, Ship ship){

        field.put(c, ship);
        ship.setHealth(ship.getHealth() -1);
        while (ship.getHealth() > 0){
            if (ship.getDirection() == Ship.Direction.HORIZONTAL){

                field.put(new Coordinate(c.getxAxis() + 1, c.getyAxis()), ship);

            }
            ship.setHealth(ship.getHealth() -1);
        }

    }

    /*
    check if in coordinate c there is a ship
    @return: false if there is a ship else true
     */
    public boolean isFree(Coordinate c){
        if (field.get(c) != null){
            return  false;
        } else return true;
    }

    public void printConfig(){
        for(Ship i : field.values())
            System.out.println(i);
        for(Coordinate c : field.keySet())
            System.out.print("x:"+c.getxAxis() + " " +   "y:" + c.getyAxis() + "\n");
            ;
    }


}
