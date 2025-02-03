public class Players extends Person {
    private double money;

    Players() {
        super();
        money = 1000;
    }

    public void setMoney(double monInput) {
        money = monInput;
    }
    
    public double getMoney() {
        return money;
    }
    
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() + " $" + money;
    }
}
