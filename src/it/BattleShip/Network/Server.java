package it.BattleShip.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network implements Runnable{
    private int port;

    public Server(int port){
        this.port = port;
    }


    @Override
    public void connect(int port) {
        try {
             ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             System.out.println(socket.getInputStream().read());

        } catch (IOException e){
            disconnect();
        }
    }

    @Override
    protected void disconnect()  {

    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return 0;
    }

    @Override
    public void listenForData() {

    }

    @Override
    public void sendData(String data) {

    }

    @Override
    public void run() {
        connect(port);
    }
}
