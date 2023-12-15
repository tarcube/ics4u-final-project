/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1a
    +Handler.java [7]
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
    Window(int width, int height, String title, Game Game) {
    // Constructor for the Window class
        JFrame frame = new JFrame(title);
        // Create a new JFrame with the given title
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        // Set the preferred, maximum, and minimum size of the frame
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