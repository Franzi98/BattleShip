import it.BattleShip.Network.Client;
import it.BattleShip.Network.Server;

import java.io.IOException;

public class BattleShip {
    public static void main(String[] args) throws IOException {
        //Board board = new Board(10);
        //board.showField(board);
        //Ship nave = new Ship(2);

        //board.placeShip(9,9, nave);
        //board.showField(board);
        //Server server = new Server("localhost", 9999);
        //Client client = new Client("localhost", 9999);
        /*
        Ship nave = new Ship(2, Ship.Direction.HORIZONTAL);
        Ship nave2 = new Ship(2, Ship.Direction.VERTICAL);
        Ship nave3 = new Ship(2, Ship.Direction.VERTICAL);
        Ship nave4 = new Ship(2, Ship.Direction.HORIZONTAL);
        Board board = new Board(5);
        board.placeShip(new int[]{1,4}, nave);
        board.placeShip(new int[]{4,1}, nave2);
        board.placeShip(new int[]{2,2}, nave3);
        board.placeShip(new int[]{0,1}, nave4);

        board.showField(board);

        board.removeShip(new int[]{0,1});
        System.out.println("***********************");

        board.showField(board);



         */
        //HomePage.main(new String[]{});


        Server server = new Server(1234);
        Client client = new Client("localhost", 1234);
        Thread threadServer = new Thread(server);
        Thread threadClient = new Thread(client);
        threadServer.start();
        threadClient.start();


    }
}
