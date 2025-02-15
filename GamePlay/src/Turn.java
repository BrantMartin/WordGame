import java.util.Scanner;
import java.util.Random;

public class Turn {
    static Scanner scan = new Scanner(System.in);
    public boolean takeTurn(Players player, Hosts host) {
        Random rand = new Random();
        Physical physPrize = new Physical();
        Money monPrize = new Money();
        int numToGuess = host.getRandomNum();
        int guess = 500;
        int prizeType = rand.nextInt(100) + 1;

        if (!player.getLastName().equals("")) {
            System.out
                    .println(host.getFirstName() + " " + host.getLastName() + " says, \"" + player.getFirstName() + " "
                            + player.getLastName() + ", enter your guess for my random number between 0 and 100\"");
        } else {
            System.out.println(host.getFirstName() + " " + host.getLastName() + "says, \"" + player.getFirstName()
                    + ", enter your guess for my random number between 0 and 100\"");
        }
        guess = scan.nextInt();
        if (prizeType % 2 == 0) {
            if (guess == numToGuess) {
                monPrize.setMoney(physPrize.displayWinnings(player, host.compareNumber(guess)));
                return true;
            } else {
                monPrize.setMoney(physPrize.displayWinnings(player, host.compareNumber(guess)));
                return false;
            }
        } else {
            if (guess == numToGuess) {
                monPrize.setMoney(monPrize.displayWinnings(player, host.compareNumber(guess)));
                return true;
            } else {
                monPrize.setMoney(monPrize.displayWinnings(player, host.compareNumber(guess)));
                return false;
            }
        }
    }
}
