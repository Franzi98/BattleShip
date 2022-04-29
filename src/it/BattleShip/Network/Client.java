package it.BattleShip.Network;

import it.BattleShip.Board.Coordinate;
import it.BattleShip.Board.Ship;
import it.BattleShip.game.Attack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Network implements  Runnable{
    private String ip;
    private int port;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect(int port) throws IOException {
        try{
            Socket socket = new Socket("localhost", port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            sendData(socket, new Attack(new Coordinate(0,0), new Ship(2, Ship.Direction.HORIZONTAL)));
        } catch (IOException e){
            disconnect();
        }
    }

    @Override
    protected void disconnect() {

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
    public void listenForData(Socket socket) {
        while (socket.isConnected()){
            try {
                System.out.println(socket.getInputStream().read());
            } catch (IOException e){
                disconnect();
            }
        }
    }


    @Override
    public void sendData(Socket socket, Attack attack) {
        try {
            outputStream.writeObject(attack);
        }catch (IOException e){
            disconnect();
        }
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
