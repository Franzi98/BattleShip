package it.BattleShip.Network;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/*
This class is used to handle multiple clients at the same time.
This class is passed to thread class
 */
public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String clientUsername;

    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientUsername = "username";

            clientHandlers.add(this);

        } catch (IOException e){
            closeConnection(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String dataFromClient;

        while (socket.isConnected()){
            try {
                dataFromClient = bufferedReader.readLine();
            } catch (IOException e){
                closeConnection(socket, bufferedReader, bufferedWriter);
            }
        }


    }
    private void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the game!");
    }

    private void broadcastMessage(String messageToSend){
        try {
        for (ClientHandler clientHandler : clientHandlers){
            if (!clientHandler.clientUsername.equals(clientUsername)){
                clientHandler.bufferedWriter.write(messageToSend);
                clientHandler.bufferedWriter.newLine();
                clientHandler.bufferedWriter.flush();
            }
        }
        } catch (IOException e){

        }
    }
    private void closeConnection(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket!=null){
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
