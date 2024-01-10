/*
    +AudioPlayer.java [1] (Frontend)
    This program contains the class that handles audio and SFX that are played in the game
*/

// Imports
import javax.sound.sampled.*;

public class AudioPlayer {
    // method that handles playing sound effect files (.wav)
    public static void play(String file) {
        // try catch in case sound file could not be found
        try {
            // sound file getter
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Game.class.getResource(file));
            Clip sound = AudioSystem.getClip();
            // plays the sound
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception err) {
            // error message
            System.out.println(err);
        }
    }
}