import java.util.Random;

import javax.swing.JOptionPane;

public class Physical implements Award{
    private String[] prizes = {"Car", "Vacation", "Game Console", "Gift Card", "Smartphone"};
    Random rand  = new Random();
    String prize = "";
    
    public int getRandomPrize(){
        return (int) (rand.nextInt(5));
    }
    
    public int displayWinnings(Players player, boolean bool) {
        if (bool == true) {
            if (!player.getLastName().equals("")) {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " " + player.getLastName() + " that letter is in the phrase!");
                prize = prizes[getRandomPrize()];
                JOptionPane.showConfirmDialog(null, "Your prize is a " + prize + ".");
                return 0;
            }
            else {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " that letter is in the phrase!");
                prize = prizes[getRandomPrize()];
                JOptionPane.showConfirmDialog(null, "Your prize is a " + prize + ".");
                return 0;
            }
        }
        else {
            if (!player.getLastName().equals("")) {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " " + player.getLastName() + " that is incorrect!");
                prize = prizes[getRandomPrize()];
                JOptionPane.showConfirmDialog(null, "Your prize would have been a " + prize + ".");
                return 0;
            }
            else {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " that is incorrect!");
                prize = prizes[getRandomPrize()];
                JOptionPane.showConfirmDialog(null, "Your prize would have been a " + prize + ".");
                return 0;
            }
        }
    }
}
