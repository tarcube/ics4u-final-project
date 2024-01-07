/*
    +AudioPlayer.java [1] (Frontend)
    TODO: Add summary of contents in this class
*/

// TODO: Comment this class

// Imports
import javax.sound.sampled.*;

public class AudioPlayer {
    public static void play(String file) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Game.class.getResource(file));
            Clip sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}