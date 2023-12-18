/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Wednesday, December 20th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2
    +Handler.java [6] (Frontend)
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

public class Object extends GameObject {
// This class extends the GameObject class and represents an object in the game
    public Object(int x, int y, int w, int h, ID id, /*int velX, int velY, int dW, int dH,*/ int z) {
    // Constructor for the Object class
        super(x, y, w, h, id, /*velX, velY, dW, dH,*/ z);
        // Calling the superclass constructor with the given parameters
    }

    public void tick(int ticks) {
    // Method to update the state of the object
        if (id == ID.Object) {
        // If the object's ID is Object, update its position and dimensions
            ////x += velX;
            ////y += velY;
            ////w += dW;
            ////h += dH;
            ////if (x < 0 || x > Game.WIDTH-w) {velX *= -1;}
            //// If the object's x position is less than 0 or greater than the game's width minus its width, reverse its x velocity
            //// if (y < 0 || y > Game.HEIGHT-h) {velY *= -1;}
            //// If the object's y position is less than 0 or greater than the game's height minus its height, reverse its y velocity
            /*
            if (KeyInput.keysPressed.contains((int)'W')) {
                y -= velY;
            } // If the 'W' key is pressed, move the object up
            if (KeyInput.keysPressed.contains((int)'A')) {
                x -= velX;
            } // If the 'A' key is pressed, move the object up
            if (KeyInput.keysPressed.contains((int)'S')) {
                y += velY;
            } // If the 'S' key is pressed, move the object down
            if (KeyInput.keysPressed.contains((int)'D')) {
                x += velX;
            } // If the 'D' key is pressed, move the object up
            */
        }
    }

    public void render(Graphics g) {
    // Method to render the object
        if (id == ID.Object) {
            g.setColor(Game.randomColor);
            g.fillRect(x, y, w, h);
        } // If the object's ID is Object, draw a rectangle at its position with its dimensions and a random color
    }
}