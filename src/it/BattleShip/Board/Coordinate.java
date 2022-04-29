package it.BattleShip.Board;

import java.io.Serializable;

public class Coordinate implements Serializable {

    private int xAxis;
    private int yAxis;

    public Coordinate(int xAxis, int yAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }
}
