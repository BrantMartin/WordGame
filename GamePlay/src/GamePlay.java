import java.util.Scanner;

public class GamePlay {
    private static Person exPerson = new Person();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fName = "";
        String lName = "";
        int guess = 500;
        int randNum = 0;

        System.out.println("Hello welcome to WordGame. You will be playing this game with a name.");
        System.out.println("Please enter your first name.");
        fName = scan.nextLine();
        System.out.println("Would you like to enter a last name? Leave blank if not.");
        lName = scan.nextLine();
        if (lName.equals("")) {
            exPerson.setFirstName(fName);
        } else {
            exPerson.setFirstName(fName);
            exPerson.setLastName(lName);
        }

        Numbers numbClass = new Numbers();
        numbClass.generateNumber();
        randNum = numbClass.getRandomNum();

        while (guess != randNum) {
            if (lName.equals("")) {
                System.out.println(exPerson.getFirstName()
                        + ", guess what number I picked between 0 and 100.");
            } else {
                System.out.println(exPerson.getFirstName() + " " + exPerson.getLastName()
                        + ", guess what number I picked between 0 and 100.");
            }
            guess = scan.nextInt();
            numbClass.compareNumber(guess);
        }

        scan.close();
    }
}
