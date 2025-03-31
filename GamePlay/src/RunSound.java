import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class RunSound {
    public static void playBackMusic(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(1000);
        } catch (UnsupportedAudioFileException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch(LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public static void playNoise(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(0);
        } catch (UnsupportedAudioFileException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch(LineUnavailableException e) {
            System.out.println(e);
        }
    }
}
