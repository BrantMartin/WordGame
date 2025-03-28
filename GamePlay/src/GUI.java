import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUI {
    public static Players[] currentPlayers = new Players[3];

    public static void main(String[] args) {
        currentPlayers[0] = new Players();
        currentPlayers[1] = new Players();
        currentPlayers[2] = new Players();
        Hosts host = new Hosts();
        Turn gameTurn = new Turn();

        JFrame aFrame = new JFrame("Word Game");
        aFrame.setSize(800, 300);
        aFrame.setVisible(true);
        aFrame.setLayout(new GridLayout());
        aFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aFrame.setLocationRelativeTo(null);
        
        JPanel playerPanel = new JPanel(new GridBagLayout());
        JPanel hostPanel = new JPanel(new GridBagLayout());
        JPanel startPanel = new JPanel(new GridBagLayout());
        

        JLabel playerOneLabel = new JLabel("Player 1: " + currentPlayers[0]);
        JLabel playerTwoLabel = new JLabel("Player 2: " + currentPlayers[1]);
        JLabel playerThreeLabel = new JLabel("Player 3: " + currentPlayers[2]);
        JLabel hostLabel = new JLabel("Host: " + host.getFirstName() + host.getLastName());
        JLabel gamePhraseLabel = new JLabel("Phrase: " + host.getPlayingPhrase());

        JButton turnButton = new JButton("Start Turn");
        
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem addPlayerItem = new JMenuItem("Add Player(s)");
        JMenuItem addHostItem = new JMenuItem("Add Host");
        JMenu aboutMenu = new JMenu("About");
        JMenuItem layoutItem = new JMenuItem("Layout");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        playerPanel.add(playerOneLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        playerPanel.add(playerTwoLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        playerPanel.add(playerThreeLabel, gbc);


        gbc.gridx = 0;
        gbc.gridy = 0;
        hostPanel.add(hostLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        hostPanel.add(gamePhraseLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        startPanel.add(turnButton, gbc);
        
        aFrame.add(playerPanel);
        aFrame.add(hostPanel);
        aFrame.add(startPanel);
        
        aFrame.setJMenuBar(menuBar);
        menuBar.add(gameMenu);
        gameMenu.add(addPlayerItem);
        gameMenu.add(addHostItem);
        menuBar.add(aboutMenu);
        aboutMenu.add(layoutItem);
        gameMenu.setMnemonic(KeyEvent.VK_G);
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        
        SwingUtilities.updateComponentTreeUI(aFrame);

        addPlayerItem.addActionListener(_ -> {
            for (int i = 0; i < currentPlayers.length; i++) {
                String fName = JOptionPane.showInputDialog("Please enter your first name Player #" + (i + 1));
                String lName = JOptionPane.showInputDialog("Would you like to enter a last name? Leave blank if not.");
                if (lName.equalsIgnoreCase("")) {
                    currentPlayers[i].setFirstName(fName);
                } else {
                    currentPlayers[i].setFirstName(fName);
                    currentPlayers[i].setLastName(lName);
                }
                playerOneLabel.setText("Player 1: " + currentPlayers[0]);
                playerTwoLabel.setText("Player 2: " + currentPlayers[1]);
                playerThreeLabel.setText("Player 3: " + currentPlayers[2]);
                SwingUtilities.updateComponentTreeUI(aFrame);
            }
        });

        addHostItem.addActionListener(_ -> {
            host.setFirstName(JOptionPane.showInputDialog("Enter the host's first name"));
            host.setLastName(JOptionPane.showInputDialog("Enter the host's last name"));
            host.setPhrase(JOptionPane.showInputDialog("What will the phrase to guess be"));
            hostLabel.setText("Host: " + host.getFirstName() + " " + host.getLastName());
            gamePhraseLabel.setText("Phrase: " + host.getPlayingPhrase());
            SwingUtilities.updateComponentTreeUI(aFrame);
        });
        
        layoutItem.addActionListener(_ -> {
            JOptionPane.showMessageDialog(null, "I used the GridBagLayout because I was able to have more control\nover the layout of my application through the options that it provides.");
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