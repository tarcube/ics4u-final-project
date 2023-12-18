/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Wednesday, December 20th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2
    +Handler.java [5] (Frontend)
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

    public KeyInput() {}
    // Constructor to initialize the handler object

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
        if (key == KeyEvent.VK_COMMA && Game.WIDTH > 240 && Game.HEIGHT > 180) {
            Game.WIDTH -= 40;
            Game.HEIGHT -= 30;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }
        if (key == KeyEvent.VK_PERIOD && Game.WIDTH < 960 && Game.HEIGHT < 720) {
            Game.WIDTH += 40;
            Game.HEIGHT += 30;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    // Overridden method to handle key release events
        int key = e.getKeyCode();
        // Get the key code of the key released
    }
}