public class Money implements Award{
    private int money = 1000;

    public void setMoney(int change) {
        money = change;
    }
    
    public int getMoney() {
        return money;
    }

    public int displayWinnings(Players player, boolean bool) {
        if (bool == true) {
            if (!player.getLastName().equals("")) {
                System.out.println(player.getFirstName() + " " + player.getLastName() + " that is correct. You won $1000!");
                return money + 1000;
            }
            else {
                System.out.println(player.getFirstName() + " that is correct. You won $1000!");
                return money + 1000;
            }
        }
        else {
            if (!player.getLastName().equals("")) {
                System.out.println(player.getFirstName() + " " + player.getLastName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
            else {
                System.out.println(player.getFirstName() + " that is incorrect. You lost $200!");
                return money - 200;
            }
        }
    }
}
