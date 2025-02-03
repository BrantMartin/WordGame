import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {
        Scanner scan = new Scanner(System.in);
        int numToGuess = host.getRandomNum();
        int guess = 500;

        if (!player.getLastName().equals("")) {
        System.out.println(host.getFirstName() + " " + host.getLastName() + " says, \"" + player.getFirstName() + " "
                + player.getLastName() + ", enter your guess for my random number between 0 and 100\"");
        }
        else {
        System.out.println(host.getFirstName() + " " + host.getLastName() + "says, \"" + player.getFirstName() + ", enter your guess for my random number between 0 and 100\"");
        }
        guess = scan.nextInt();
        host.compareNumber(guess);
        if (guess == numToGuess) {
            System.out.println("You win $1000.00");
            player.setMoney(player.getMoney() + 1000);
            System.out.println(player.toString());
            return true;
        } else {
            System.out.println("You lose $200.00");
            player.setMoney(player.getMoney() - 200);
            System.out.println(player.toString());
            return false;
        }
    }
}
