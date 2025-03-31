import javax.swing.JOptionPane;

public class Money implements Award{
    private int money = 1000;

    public void setMoney(int change) {
        money = change;
    }
    
    public int getMoney() {
        return money;
    }

    public int displayWinnings(Players player, boolean bool) {
        if (bool == true) {
            RunSound.playNoise("WordGame/GamePlay/music/correct.wav");
            if (!player.getLastName().equals("")) {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " " + player.getLastName() + " that letter is in the phrase. You won $1000!");
                return money + 1000;
            }
            else {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " that letter is in the phrase. You won $1000!");
                return money + 1000;
            }
        }
        else {
            RunSound.playNoise("WordGame/GamePlay/music/incorrect.wav");
            if (!player.getLastName().equals("")) {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " " + player.getLastName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
            else {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
        }
    }
}
