package it.BattleShip.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network {
    private final ServerSocket serverSocket;
    private final int port;

    public Server(ServerSocket serverSocket, int port){
        this.serverSocket = serverSocket;
        this.port = port;

    }


    @Override
    public void connect(){
        try {
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("Nuovo client connesso");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread tread = new Thread(clientHandler);
                tread.start();
            }
        } catch (Exception e){

        }

    }

    @Override
    protected void disconnect() throws IOException {
        try {
            if (serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return "";
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public void listenForData() {

    }

    @Override
    public void sendData(String data) {

    }

    public static void main(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Server server = new Server(serverSocket, port);
        server.connect();
    }


}
