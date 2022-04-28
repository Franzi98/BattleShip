package it.BattleShip.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Network {

    public abstract void connect(int port) throws IOException;
    /*
    Connect to Server or Client
     */
    protected abstract void disconnect() throws IOException;
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
    public abstract void listenForData();
    public abstract void sendData(String data);
}
