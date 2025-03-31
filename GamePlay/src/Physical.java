import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Physical implements Award {
    private String[] prizes = { "Car", "Vacation", "Game Console", "Gift Card", "Smartphone" };
    Random rand = new Random();
    String prize = "";
    ImageIcon carImg = new ImageIcon("WordGame/GamePlay/images/car.jpg");
    ImageIcon vacaImg = new ImageIcon("WordGame/GamePlay/images/vacation.jpg");
    ImageIcon consoleImg = new ImageIcon("WordGame/GamePlay/images/gameconsole.jpg");
    ImageIcon cardImg = new ImageIcon("WordGame/GamePlay/images/giftcard.jpg");
    ImageIcon phoneImg = new ImageIcon("WordGame/GamePlay/images/smartphone.jpg");

    public int getRandomPrize() {
        return (int) (rand.nextInt(5));
    }

    public void displayPhysicalPrize(int prizeType) {
        switch (prizeType) {
            case 0:
                JOptionPane.showMessageDialog(null, "Car", "Car", JOptionPane.INFORMATION_MESSAGE, carImg);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Vacation", "Vacation", JOptionPane.INFORMATION_MESSAGE,
                        vacaImg);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Game Console", "Game Console",
                        JOptionPane.INFORMATION_MESSAGE, consoleImg);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Giftcard", "Giftcard", JOptionPane.INFORMATION_MESSAGE,
                        cardImg);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Smartphone", "Smartphone", JOptionPane.INFORMATION_MESSAGE,
                        phoneImg);
                break;
            default:
                break;
        }

    }

    public int displayWinnings(Players player, boolean bool) {
        if (bool == true) {
            RunSound.playNoise("WordGame/GamePlay/music/correct.wav");
            if (!player.getLastName().equals("")) {
                JOptionPane.showMessageDialog(null,
                        player.getFirstName() + " " + player.getLastName() + " that letter is in the phrase!");
                int prizeNum = getRandomPrize();
                prize = prizes[prizeNum];
                JOptionPane.showMessageDialog(null, "Your prize is a " + prize + ".");
                displayPhysicalPrize(prizeNum);
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " that letter is in the phrase!");
                int prizeNum = getRandomPrize();
                prize = prizes[prizeNum];
                JOptionPane.showMessageDialog(null, "Your prize is a " + prize + ".");
                displayPhysicalPrize(prizeNum);
                return 0;
            }
        } else {
            RunSound.playNoise("WordGame/GamePlay/music/incorrect.wav");
            if (!player.getLastName().equals("")) {
                JOptionPane.showMessageDialog(null,
                        player.getFirstName() + " " + player.getLastName() + " that is incorrect!");
                int prizeNum = getRandomPrize();
                prize = prizes[prizeNum];
                JOptionPane.showMessageDialog(null, "Your prize would have been a " + prize + ".");
                displayPhysicalPrize(prizeNum);
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, player.getFirstName() + " that is incorrect!");
                int prizeNum = getRandomPrize();
                prize = prizes[prizeNum];
                JOptionPane.showMessageDialog(null, "Your prize would have been a " + prize + ".");
                displayPhysicalPrize(prizeNum);
                return 0;
            }
        }
    }
}
