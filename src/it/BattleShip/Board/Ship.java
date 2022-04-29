package it.BattleShip.Board;

import java.io.Serializable;

public class Ship implements Serializable {
    private int health;
    //ship direction
    private boolean isAlive;

    public enum Direction{
        HORIZONTAL,
        VERTICAL
    }
    private Direction direction;

    public Ship(int health, Direction direction){
        this.health = health;
        this.isAlive = true;
        this.direction = direction;
    }

    public int getHealth() {
        return health;
    }
    public boolean isAlive(){
        if(health == 0){
            return false;
        } else return true;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /*
    Destroy a ship
     */
    public void destroy() {
        isAlive = false;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
