import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;

public class Turn {
    static Scanner scan = new Scanner(System.in);

    public boolean takeTurn(Players player, Hosts host) {
        Random rand = new Random();
        Physical physPrize = new Physical();
        Money monPrize = new Money();
        String stringToGuess = host.getPhrase();
        String guess = "";
        int prizeType = rand.nextInt(100) + 1;

        if (!player.getLastName().equals("")) {
            guess = JOptionPane.showInputDialog(
                    host.getFirstName() + " " + host.getLastName() + " says, \"" + player.getFirstName() + " "
                            + player.getLastName() + ", enter your guess for a letter in my phrase.\"");
        } else {
            guess = JOptionPane.showInputDialog(host.getFirstName() + " " + host.getLastName() + " says, \"" + player.getFirstName()
                    + ", enter your guess for a letter in my phrase.\"");
        }
        if (prizeType % 2 == 0) {
            if (host.getPlayingPhrase().equals(stringToGuess)) {
                try {
                    monPrize.setMoney(physPrize.displayWinnings(player, host.findLetters(guess)));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "You entered more than one letter.");
                }
                return true;
            } else {
                try {
                    monPrize.setMoney(physPrize.displayWinnings(player, host.findLetters(guess)));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "You entered more than one letter.");
                }
                return false;
            }
        } else {
            if (host.getPlayingPhrase().equals(stringToGuess)) {
                try {
                    monPrize.setMoney(monPrize.displayWinnings(player, host.findLetters(guess)));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "You entered more than one letter.");
                }
                return true;
            } else {
                try {
                    monPrize.setMoney(monPrize.displayWinnings(player, host.findLetters(guess)));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "You entered more than one letter.");
                }
                return false;
            }
        }
    }
}
