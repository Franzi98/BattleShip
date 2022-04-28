package it.BattleShip.Network;

import java.io.IOException;
import java.net.Socket;

public class Client extends Network implements  Runnable{
    private String ip;
    private int port;

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect(int port) throws IOException {
        try{
            Socket socket = new Socket("localhost", port);
            socket.getOutputStream().write(5);
        } catch (IOException e){
            disconnect();
        }
    }

    @Override
    protected void disconnect() throws IOException {

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
        try {
            connect(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
