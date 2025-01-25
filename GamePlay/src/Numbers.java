import java.util.Random;

public class Numbers {
    private int randomNum;
    Random rand = new Random();
    
    Numbers() {
        randomNum = 0;
    }
    
    public int getRandomNum() {
        return randomNum;
    }
    
    public void setRandomNum(int rNum) {
        randomNum = rNum;
    }
    
    public void generateNumber() {
        randomNum = rand.nextInt(101);
    }
    
    public boolean compareNumber(int guess) {
        if (guess == randomNum) {
            System.out.println("Congratulations, you guessed the number!");
            return true;
        }
        else if (guess > randomNum) {
            System.out.println("I'm sorry. That guess was too high.");
            return false;
        }
        else if (guess < randomNum) {
            System.out.println("I'm sorry. That guess was too low.");
            return false;
        }
        else {
            return false;
        }
    }
}
