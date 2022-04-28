package it.BattleShip.gui.homePage;

import it.BattleShip.Network.Server;
import it.BattleShip.gui.server.ServerPage;
import it.BattleShip.utils.AdressChecker;
import it.BattleShip.utils.NetworkUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomePage {
    private JTextField ipField;
    private JTextField portField;
    private JButton clientButton;
    private JPanel panel;
    private JButton startServer;
    private JLabel ipLabel;
    private JFrame frame;

    public HomePage(JFrame frame) {
        this.frame = frame;
        try{
            ipLabel.setText(NetworkUtils.getExternalIP());
        } catch (IOException e){
            ipLabel.setText("Impossibile reperire IP");
        }
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(ipField.getText());
                if (checkData(ipField.getText(), portField.getText())){
                    frame.dispose();
                    try {
                        ServerPage.main(Integer.parseInt(portField.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                } else System.out.println("dati errati");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomePage");
        frame.setDefaultCloseOperation(3);
        frame.setContentPane(new HomePage(frame).panel);
        frame.pack();
        frame.setSize(500,400);

        frame.setVisible(true);
    }

    private boolean checkData(String ip, String port){
        if(AdressChecker.isCorrect(ip) && AdressChecker.isValidPort(Integer.parseInt(port))){
            return true;
        } else return false;
    }
}
