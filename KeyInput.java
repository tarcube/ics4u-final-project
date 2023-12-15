/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1a
    +Handler.java [5]
*/

/* Imports */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;
/* Imports */

public class KeyInput extends KeyAdapter {
// This class extends KeyAdapter to handle keyboard inputs
    private Handler handler;
    // Handler object to manage game objects
    public static HashSet<Integer> keysPressed = new HashSet<>();
    // HashSet to store the keys currently pressed

    public KeyInput(Handler handler) {
        this.handler = handler;
    } // Constructor to initialize the handler object

    public static void clickSFX() {
    // Method to play a sound effect
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Game.class.getResource("colon_3.wav"));
            // Get the audio input stream from the resource file
            Clip sound = AudioSystem.getClip();
            // Get a Clip object from the AudioSystem
            sound.open(audioInputStream);
            // Open the Clip object with the audio input stream
            sound.start();
            // Start playing the sound
        } catch (Exception err) {
            System.out.println(err);
            // Print any exceptions that occur
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    // Overridden method to handle key press events
        int key = e.getKeyCode();
        // Get the key code of the key pressed
        keysPressed.add(key);
        // Add the key code to the keysPressed HashSet
        for (int i = 0; i < handler.object.size(); i++) {
        // Loop through all game objects
            GameObject tempObject = handler.object.get(i);
            // Get the current game object
            if (tempObject.getId() == ID.Temporary) {
            // If the game object is temporary
                if (key == KeyEvent.VK_SPACE) {
                // If the space key was pressed
                    switchColourTheme();
                    // Switch the color theme
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
        // If the escape key was pressed
            System.out.println("Force quitting...");
            System.exit(1);
            // Exit the program
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    // Overridden method to handle key release events
        int key = e.getKeyCode();
        // Get the key code of the key released
        keysPressed.remove(key);
        // Remove the key code from the keysPressed HashSet
    }

    private void switchColourTheme() {
    // Method to switch the color theme
        Game.red = (int) (Math.random()*255);
        Game.green = (int) (Math.random()*255);
        Game.blue = (int) (Math.random()*255);
        // Generate random values for red, green, and blue
        Game.randomColor = new Color(Game.red, Game.green, Game.blue);
        Game.randomColorBy2 = new Color(Game.red/2, Game.green/2, Game.blue/2);
        // Create new Color objects with the generated values
        clickSFX();
        // Play the sound effect
    }
}