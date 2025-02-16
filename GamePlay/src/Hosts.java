public class Hosts extends Person{
    private static Phrases gamePhrase = new Phrases();

    Hosts(){
        super();
    }
    
    Hosts(String fName, String lName) {
        super(fName, lName);
    }
    
    public void setPhrase(String newPhrase) {
        gamePhrase.setGamePhrase(newPhrase);
        gamePhrase.setPlayingPhrase(gamePhrase.getGamePhrase());
    }
    
    public String getPhrase() {
        return gamePhrase.getGamePhrase();
    }
    
    public String getPlayingPhrase() {
        return gamePhrase.getPlayingPhrase();
    }

    public boolean findLetters(String letter) throws MultipleLettersException {
        return gamePhrase.findLetters(letter);
    }

    public String toString() {
        return "firstName: " + super.getFirstName() + " lastName: " + super.getLastName();
    }
}