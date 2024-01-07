/*
    +Window.java [12] (Frontend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

// This class extends the Canvas class and represents a window for a game
public class Window extends Canvas {
    public static JFrame frame;

    // Constructor for the Window class
    Window(int width, int height, String title, Game Game) {
        // Create a new JFrame with the given title
        frame = new JFrame(title);
        // Set the preferred, maximum, and minimum size of the frame
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width*2, height*2));
        frame.setMinimumSize(new Dimension(width/2, height/2));
        // Get window dimension preferences
        try {
            File file = new File("preferences.txt");
            Scanner scanner = new Scanner(file);
            Game.WIDTH = scanner.nextInt();
            Game.HEIGHT = scanner.nextInt();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        // Set the size of the window
        Window.frame.setSize(new Dimension(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY));
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the window non-resizable
        frame.setResizable(false);
        // Center the window on the screen
        frame.setLocationRelativeTo(null);
        // Add the game to the frame
        frame.add(Game);
        // Make the frame visible
        frame.setVisible(true);
        // Start the game
        Game.start();
    }
}