package it.BattleShip.gui.server;

import it.BattleShip.Network.Server;
import it.BattleShip.gui.homePage.HomePage;

import javax.swing.*;
import java.io.IOException;

public class ServerPage {
    private JLabel jLabel;
    private JPanel panel;


    public ServerPage(){

    }


    public static void main(int port) throws IOException {
        JFrame frame = new JFrame("Battleship");
        Server.main(port);
        frame.setDefaultCloseOperation(3);
        frame.setContentPane(new ServerPage().panel);
        frame.pack();
        frame.setSize(500,400);

        frame.setVisible(true);
    }
}
