package it.BattleShip.Network;

import it.BattleShip.game.Attack;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network implements Runnable{
    private int port;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public Server(int port){
        this.port = port;
    }


    @Override
    public void connect(int port) {
        try {
             ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             outputStream = new ObjectOutputStream(socket.getOutputStream());
             inputStream = new ObjectInputStream(socket.getInputStream());
             listenForData(socket);



        } catch (IOException e){
            disconnect();
        }
    }

    @Override
    protected void disconnect()  {
        System.out.println("E' successo qualcosa di strano e ora non funziona più niente");
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
                Attack attack = (Attack) inputStream.readObject();
                System.out.println(attack.toString());
            } catch (IOException e){
                disconnect();
            } catch (ClassNotFoundException e){
                System.out.println("vedi che non è arrivato niente coglione");
            }
        }
    }



    @Override
    public void sendData(Socket socket, Attack data) {
        try {
            socket.getOutputStream().write(14);
        } catch (IOException e){
            disconnect();
        }
    }

    @Override
    public void run() {
        connect(port);
    }
}
