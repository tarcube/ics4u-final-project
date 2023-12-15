/*
    Ian F., Kevin X., Matthew X.
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1
    +Handler.java [6]
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

// TODO: Comment the rest of the code in this class

public class Object extends GameObject {
    public Object(int x, int y, int w, int h, ID id, int velX, int velY, int dW, int dH, int z) {
        super(x, y, w, h, id, velX, velY, dW, dH, z);
    }

    public void tick(int ticks) {
        if (id == ID.Object) {
            x += velX;
            y += velY;
            w += dW;
            h += dH;
            if (x < 0 || x > Game.WIDTH-w) {velX *= -1;}
            if (y < 0 || y > Game.HEIGHT-h) {velY *= -1;}
            if (KeyInput.keysPressed.contains((int)'W')) {
                y -= velY;
            }
            if (KeyInput.keysPressed.contains((int)'S')) {
                y += velY;
            }
        }
    }

    public void render(Graphics g) {
        if (id == ID.Object) {
            g.setColor(Game.randomColor);
            g.fillRect(x, y, w, h);
        }
    }
}