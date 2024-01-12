/*
    +KeyInput.java [9] (Frontend)

    Registers key input
    
*/

// Imports
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// This class extends KeyAdapter to handle keyboard inputs
public class KeyInput extends KeyAdapter {
    // ! Package calls for a keysPressed HashSet or the code will not work
    public static HashSet<Integer> keysPressed = new HashSet<Integer>();
    // Reference the AudioPlayer class
    public static AudioPlayer audioplayer;
    // String that a user would type/input
    public static String typedInput = "";
    // Length of typedInput (stable state checker)
    private static int i = 0;
    // StateChecker whether or not the user needs to type/input
    public static boolean typing = false;

    // Constructor to initialize the audioplayer object
    public KeyInput() {
        audioplayer = new AudioPlayer();
    }

    @Override
    // Overridden method to handle key press events
    public void keyPressed(KeyEvent e) {
        // Get the key code of the key pressed
        int key = e.getKeyCode();
        // Add it to the hashset
        keysPressed.add(key);
        if (key >= 32 && typing) {
            typedInput += (char) key;
            i++;
        }
        else if (key == 10 && typing) {
            StateChecker.errorCheck(typedInput);
        }
        else if (key == 8 && i > 0) {
            typedInput = typedInput.substring(0,i-1);
            i--;
        }

        // If the escape key was pressed
        if (key == KeyEvent.VK_ESCAPE) {
            System.out.println("Force quitting...");
            // Exit the program
            System.exit(1);
        }

        // ! For debugging purposes only, not intended for user client
        // If the comma key was pressed
        if (key == KeyEvent.VK_COMMA && Game.WIDTH > 480 && Game.HEIGHT > 360) {
            // Decrease the resolution size of the window
            Game.WIDTH -= 40;
            Game.HEIGHT -= 30;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }

        // ! For debugging purposes only, not intended for user client
        // If the period key was pressed
        if (key == KeyEvent.VK_PERIOD && Game.WIDTH < 960 && Game.HEIGHT < 720) {
            // Increase the resolution size of the window
            Game.WIDTH += 40;
            Game.HEIGHT += 30;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }

        // ! For debugging purposes only, not intended for user client
        // If the slash key was pressed
        if (key == KeyEvent.VK_SLASH) {
            // Switch the colour theme
            switchColourTheme();
        }
    }

    @Override
    // Overridden method to handle key release events
    public void keyReleased(KeyEvent e) {
        // Get the key code of the key released
        int key = e.getKeyCode();
        // Remove it from the hashset
        keysPressed.remove(key);
    }

    // Method to switch the colour theme
    private void switchColourTheme() {
        Game.red = (int) (Math.random()*128+64);
        Game.green = (int) (Math.random()*128+64);
        Game.blue = (int) (Math.random()*128+64);
        Game.randomColor = new Color(Game.red, Game.green, Game.blue);
        Game.randomColorBy2 = new Color(Game.red/2, Game.green/2, Game.blue/2);
        // Play a sound effect
        String file = "sfx/colon_3.wav";
        audioplayer.play(file);
    }
}