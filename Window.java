/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Wednesday, December 20th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2a
    +Handler.java [7] (Frontend)
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

public class Window extends Canvas {
// This class extends the Canvas class and represents a window for a game
    public static JFrame frame;

    Window(int width, int height, String title, Game Game) {
    // Constructor for the Window class
        frame = new JFrame(title);
        // Create a new JFrame with the given title
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width*2, height*2));
        frame.setMinimumSize(new Dimension(width/2, height/2));
        // Set the preferred, maximum, and minimum size of the frame
        try {
            File file = new File("preferences.txt");
            Scanner scanner = new Scanner(file);
            Game.WIDTH = scanner.nextInt();
            Game.HEIGHT = scanner.nextInt();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        // Get window dimension preferences
        Window.frame.setSize(new Dimension(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY));
        // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the default close operation to exit the application when the window is closed
        frame.setResizable(false);
        // Make the window non-resizable
        frame.setLocationRelativeTo(null);
        // Center the window on the screen
        frame.add(Game);
        // Add the game to the frame
        frame.setVisible(true);
        // Make the frame visible
        Game.start();
        // Start the game
    }
}