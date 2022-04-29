package it.BattleShip.game;

import it.BattleShip.Network.Client;
import it.BattleShip.Network.Server;

import javax.swing.*;

public class Player {
    private String username;
    private Icon profileImg;
    private int shipOnLife;
    private boolean isMyTurn;

    private boolean isServer;
    private Client client;
    private Server server;

    public Player(String username,  boolean isMyTurn, boolean isServer){
        this.isMyTurn = isMyTurn;
        this.shipOnLife = 5;
        this.username = username;

    }

    public Icon getProfileImg() {
        return profileImg;
    }

    public int getShipOnLife() {
        return shipOnLife;
    }

    public String getUsername() {
        return username;
    }

    public void setMyTurn(boolean myTurn) {
        isMyTurn = myTurn;
    }

    public void setShipOnLife(int shipOnLife) {
        this.shipOnLife = shipOnLife;
    }
}
