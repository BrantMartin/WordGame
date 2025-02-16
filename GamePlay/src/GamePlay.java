import java.util.Scanner;

public class GamePlay {
    public static Players[] currentPlayers = new Players[3];
    public static void main(String[] args) {
        currentPlayers[0] = new Players();
        currentPlayers[1] = new Players();
        currentPlayers[2] = new Players();
        String playAgain = "y";
        Scanner scan = new Scanner(System.in);
        while (playAgain.equals("y")) {
            String fName = "";
            String lName = "";
            String guessString = "";
            Hosts host = new Hosts("Bill", "Swiftman");
            boolean correct = false;

            System.out.println("Hello welcome to WordGame. You will be playing this game with a name.");
            for (int i = 0; i < currentPlayers.length; i++) {
                System.out.println("Please enter your first name Player #" + (i + 1));
                fName = scan.nextLine();
                System.out.println("Would you like to enter a last name? Leave blank if not.");
                lName = scan.nextLine();
                if (lName.equalsIgnoreCase("")) {
                    currentPlayers[i].setFirstName(fName);
                } else {
                    currentPlayers[i].setFirstName(fName);
                    currentPlayers[i].setLastName(lName);
                }
            }
            
            System.out.println("Enter the phrase for players to guess:");
            guessString = scan.nextLine();
            host.setPhrase(guessString);
            
            Turn gameTurn = new Turn();
            while (correct == false) {
                for (int i = 0; i < currentPlayers.length; i++) {
                    correct = gameTurn.takeTurn(currentPlayers[i], host);
                    if (correct == true) {
                        break;
                    }
                }
            }
            System.out.println("Would you like to play again?(y = again other = end)");
            playAgain = scan.nextLine();
            playAgain.toLowerCase();
        }
        scan.close();
    }
}
