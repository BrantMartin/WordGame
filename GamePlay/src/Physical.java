import java.util.Random;

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
                System.out.println(player.getFirstName() + " " + player.getLastName() + " that letter is in the phrase!");
                prize = prizes[getRandomPrize()];
                System.out.println("Your prize is a " + prize + ".");
                return 0;
            }
            else {
                System.out.println(player.getFirstName() + " that letter is in the phrase!");
                prize = prizes[getRandomPrize()];
                System.out.println("Your prize is a " + prize + ".");
                return 0;
            }
        }
        else {
            if (!player.getLastName().equals("")) {
                System.out.println(player.getFirstName() + " " + player.getLastName() + " that is incorrect!");
                prize = prizes[getRandomPrize()];
                System.out.println("Your prize would have been a " + prize + ".");
                return 0;
            }
            else {
                System.out.println(player.getFirstName() + " that is incorrect!");
                prize = prizes[getRandomPrize()];
                System.out.println("Your prize would have been a " + prize + ".");
                return 0;
            }
        }
    }
}
