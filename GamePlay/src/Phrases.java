public class Phrases {
    private static String gamePhrase;
    private static String playingPhrase;
    private static String tempString;

    Phrases() {
        gamePhrase = "";
        playingPhrase = "";
    }

    public void setGamePhrase(String newGamePhrase) {
        gamePhrase = newGamePhrase;
    }
    
    public String getGamePhrase() {
        return gamePhrase;
    }

    public void setPlayingPhrase(String input) {
        playingPhrase = input;
        playingPhrase = playingPhrase.replaceAll("[a-zA-Z]", "_");
    }

    public String getPlayingPhrase() {
        return playingPhrase;
    }

    public boolean findLetters(String letter) throws MultipleLettersException {
        if (letter.length() > 1) {
            throw new MultipleLettersException();
        }
        tempString = gamePhrase;
        for (int i = 0; i < gamePhrase.length(); i++) {
            if (tempString.contains(letter)) {
                playingPhrase = playingPhrase.substring(0, tempString.indexOf(letter)) + letter + playingPhrase.substring(tempString.indexOf(letter) + 1);
                tempString = tempString.substring(0, tempString.indexOf(letter)) + "_" + tempString.substring(tempString.indexOf(letter) + 1);
            }
        }
        if (playingPhrase.contains(letter)) {
            return true;
        }
        else {
            return false;
        }
    }
}
