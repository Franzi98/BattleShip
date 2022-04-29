package it.BattleShip.game;

import it.BattleShip.Network.Client;
import it.BattleShip.Network.Server;

import java.net.Socket;

public class GameController {

    private Client client;
    private Server server;
    private final int enemyShips = 5;
    private final int friendShips = 5;
    private boolean preparationPhase;

    private enum TURN{
        SERVER,
        HOST
    }
    private TURN turn;

    public GameController(Server server, Client client ){
        this.client = client;
        this.server = server;
        turn = TURN.SERVER;
        preparationPhase = true;
    }
    /*
    start server and client in two separated threads
     */
    public void startThreads(Server server, Client client){
        Thread threadServer = new Thread(server);
        Thread threadClient = new Thread(client);
        threadServer.start();
        threadClient.start();
    }

    /*
    @return: true if there are other ship on the field
     */
    public boolean isGame(){
        if(enemyShips == 0 || friendShips == 0 && isPreparationPhase()==false){
            return false;
        } else {
            return true;
        }

    }
    /*
    if true players have to place own ships on field
     */
    public boolean isPreparationPhase(){
        return preparationPhase;
    }

    public void setPreparationPhase(boolean preparationPhase) {
        this.preparationPhase = preparationPhase;
    }
}
