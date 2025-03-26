import javax.swing.*;
import java.awt.*;

public class GUI {
    public static Players[] currentPlayers = new Players[3];

    public static void main(String[] args) {
        currentPlayers[0] = new Players();
        currentPlayers[1] = new Players();
        currentPlayers[2] = new Players();
        Hosts host = new Hosts();
        Turn gameTurn = new Turn();

        JFrame aFrame = new JFrame("Word Game");
        aFrame.setSize(500, 500);
        aFrame.setVisible(true);
        aFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel playersLabel = new JLabel("Player 1: " + currentPlayers[0] + "\nPlayer 2: " + currentPlayers[1]
                + "\nPlayer 3: " + currentPlayers[2]);
        JLabel hostLabel = new JLabel("Host: " + host.getFirstName() + host.getLastName());
        JLabel gamePhraseLabel = new JLabel("The phrase to guess is: " + host.getPlayingPhrase());
        JButton playerButton = new JButton("Add Player");
        JButton hostButton = new JButton("Add Host");
        JButton turnButton = new JButton("Start Turn");

        aFrame.setLayout(new FlowLayout());
        aFrame.add(playersLabel);
        aFrame.add(playerButton);
        aFrame.add(hostLabel);
        aFrame.add(gamePhraseLabel);
        aFrame.add(hostButton);
        aFrame.add(turnButton);
        SwingUtilities.updateComponentTreeUI(aFrame);

        playerButton.addActionListener(_ -> {
            for (int i = 0; i < currentPlayers.length; i++) {
                String fName = JOptionPane.showInputDialog("Please enter your first name Player #" + (i + 1));
                String lName = JOptionPane.showInputDialog("Would you like to enter a last name? Leave blank if not.");
                if (lName.equalsIgnoreCase("")) {
                    currentPlayers[i].setFirstName(fName);
                } else {
                    currentPlayers[i].setFirstName(fName);
                    currentPlayers[i].setLastName(lName);
                }
                playersLabel.setText("Player 1: " + currentPlayers[0] + "\nPlayer 2: " + currentPlayers[1]
                        + "\nPlayer 3: " + currentPlayers[2]);
                SwingUtilities.updateComponentTreeUI(aFrame);
            }
        });

        hostButton.addActionListener(_ -> {
            host.setFirstName(JOptionPane.showInputDialog("Enter the host's first name"));
            host.setLastName(JOptionPane.showInputDialog("Enter the host's last name"));
            host.setPhrase(JOptionPane.showInputDialog("What will the phrase to guess be"));
            hostLabel.setText("Host: " + host.getFirstName() + " " + host.getLastName());
            gamePhraseLabel.setText("The phrase to guess is: " + host.getPlayingPhrase());
            SwingUtilities.updateComponentTreeUI(aFrame);
        });

        turnButton.addActionListener(_ -> {
            boolean correct = false;
            while (correct == false) {
                for (int i = 0; i < currentPlayers.length; i++) {
                    correct = gameTurn.takeTurn(currentPlayers[i], host);
                    gamePhraseLabel.setText("The phrase to guess is: " + host.getPlayingPhrase());
                    SwingUtilities.updateComponentTreeUI(aFrame);
                    if (correct == true) {
                        break;
                    }
                }
            }
        });
    }
}