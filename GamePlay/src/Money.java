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
            if (!player.getLastName().equals("")) {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " " + player.getLastName() + " that letter is in the phrase. You won $1000!");
                return money + 1000;
            }
            else {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " that letter is in the phrase. You won $1000!");
                return money + 1000;
            }
        }
        else {
            if (!player.getLastName().equals("")) {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " " + player.getLastName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
            else {
                JOptionPane.showConfirmDialog(null, player.getFirstName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
        }
    }
}
