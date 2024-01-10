/*
    +KeyInput.java [9] (Frontend)

    Registers key input
    
*/

// Imports
import java.awt.event.*;
import java.util.*;

// This class extends KeyAdapter to handle keyboard inputs
public class KeyInput extends KeyAdapter {
    // ! Package calls for a keysPressed HashSet or the code will not work for some reason
    public static HashSet<Integer> keysPressed = new HashSet<Integer>();
    public static AudioPlayer audioplayer;

    // Constructor to initialize the audioplayer object
    public KeyInput() {
        audioplayer = new AudioPlayer();
    }

    @Override
    // Overridden method to handle key press events
    public void keyPressed(KeyEvent e) {
        // Get the key code of the key pressed
        int key = e.getKeyCode();
        // If the escape key was pressed
        if (key == KeyEvent.VK_ESCAPE) {
            System.out.println("Force quitting...");
            // Exit the program
            System.exit(1);
        }
    }

    @Override
    // Overridden method to handle key release events
    public void keyReleased(KeyEvent e) {
        // Get the key code of the key released
        int key = e.getKeyCode();
    }
}