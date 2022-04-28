package it.BattleShip.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Client extends Network{
    private int port;
    private String ip;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;


    public  Client(Socket socket, String username, String ip, int port){

        try {
            this.socket = socket;
            this.username = username;
            this.port = port;
            this.ip = ip;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    @Override
    public void connect() throws IOException {


        try {
            Socket socket = new Socket(ip, port);
            System.out.println("Client connesso");
            //send message
            socket.getOutputStream().write(5);
            socket.close();

        } catch (Exception e){
            e.printStackTrace();
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                String data;
                while (socket.isConnected()){
                    try {
                        data = bufferedReader.readLine();
                        System.out.println(data);
                    } catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    @Override
    public void sendData(String data) {
        try {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {

        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String ip, int port, String username, String data) throws IOException {
        Socket socket = new Socket(ip, port);
        Client client = new Client(socket,username, ip, port );
        client.listenForData();
        client.sendData(data);
    }
}
