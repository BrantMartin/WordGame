import java.util.Scanner;

public class GamePlay {
    private static Players exPlayer = new Players();

    public static void main(String[] args) {
        String playAgain = "y";
        while (playAgain == "y") {
            Scanner scan = new Scanner(System.in);
            String fName = "";
            String lName = "";
            Hosts host = new Hosts("Bill", "Swiftman");
            host.randomizeNum();
            boolean correct = false;

            System.out.println("Hello welcome to WordGame. You will be playing this game with a name.");
            System.out.println("Please enter your first name.");
            fName = scan.nextLine();
            System.out.println("Would you like to enter a last name? Leave blank if not.");
            lName = scan.nextLine();
            if (lName.equals("")) {
                exPlayer.setFirstName(fName);
            } else {
                exPlayer.setFirstName(fName);
                exPlayer.setLastName(lName);
            }

            Turn gameTurn = new Turn();
            while (correct == false) {
                correct = gameTurn.takeTurn(exPlayer, host);
            }
            System.out.println("Would you like to play again?(y = again other = end)");
            playAgain = scan.nextLine();
            playAgain.toLowerCase();
        }
    }
}
