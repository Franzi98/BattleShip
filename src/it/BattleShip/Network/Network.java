package it.BattleShip.Network;

import it.BattleShip.game.Attack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Network {

    public abstract void connect(int port) throws IOException;
    /*
    Connect to Server or Client
     */
    protected abstract void disconnect();
    /*
    disconnect to server or client
     */
    protected abstract boolean isServer();
    /*
    @return: true if server else false
     */
    protected abstract String getIP();
    /*
    @return: String ip
     */
    protected abstract int getPort();
    /*
    @return int port
     */
    public abstract void listenForData(Socket socket);


    public abstract void sendData(Socket socket, Attack attack);
}
