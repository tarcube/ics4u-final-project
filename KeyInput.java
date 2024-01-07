/*
    +KeyInput.java [9] (Frontend)
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
    public static HashSet<Integer> keysPressed = new HashSet<Integer>();
    // ! Package calls for a keysPressed HashSet or the code will not work for some reason
    public static AudioPlayer audioplayer;

    public KeyInput() {
        audioplayer = new AudioPlayer();
    }
    // Constructor to initialize the audioplayer object

    @Override
    public void keyPressed(KeyEvent e) {
    // Overridden method to handle key press events
        int key = e.getKeyCode();
        // Get the key code of the key pressed
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
    }
}