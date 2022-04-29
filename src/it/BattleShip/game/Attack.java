package it.BattleShip.game;

import it.BattleShip.Board.Coordinate;
import it.BattleShip.Board.Ship;

import java.io.Serializable;

public class Attack implements Serializable {
    /*
    Questa classe è la rappresentazione di un attacco di un giocatore.
    @param: coordinate, ship
     */
    private Coordinate coordinate;
    private Ship ship;

    public Attack(Coordinate coordinate, Ship ship){
        this.coordinate = coordinate;
        this.ship = ship;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Ship getShip() {
        return ship;
    }
}
