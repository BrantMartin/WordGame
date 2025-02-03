public class Hosts extends Person{
    private Numbers rNum = new Numbers();

    Hosts(){
        super();
    }
    
    Hosts(String fName, String lName) {
        super(fName, lName);
    }

    public void randomizeNum() {
        rNum.generateNumber();        
    }
    
    public int getRandomNum() {
        return rNum.getRandomNum();
    }
    
    public boolean compareNumber(int guess) {
        return rNum.compareNumber(guess);
    }

    public String toString() {
        return "firstName: " + super.getFirstName() + " lastName: " + super.getLastName();
    }
}