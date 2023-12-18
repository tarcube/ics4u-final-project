/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Monday, December 18th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2
    +Handler.java [8] (Frontend)
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

public class HUD extends MouseAdapter {
    public static String menu = "main";
    public static int mx, my;

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }

    private boolean mouseOver(int mx, int my, Rectangle rect) {
        if ((mx > rect.x && mx < rect.x + rect.width) && (my > rect.y && my < rect.y + rect.height)) {
            return true;
        }
        else return false;
    }

    public void tick() {}

    public void render(Graphics g) {
        if (menu == "main") {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
            Rectangle rect = new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/2);
            drawCenteredString(g, "Guess Who?", rect, font, Color.red, Color.blue);
            // Title
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            rect = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/16, Game.WIDTH/2, Game.HEIGHT/8);
            drawCenteredString(g, "Play", rect, font, Color.black, Color.white);
            if (mouseOver(mx, my, rect)) {
                drawCenteredString(g, "Play", rect, font, Color.black, Color.yellow);
            }
            // Play
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            rect = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);
            drawCenteredString(g, "Settings", rect, font, Color.black, Color.white);
            if (mouseOver(mx, my, rect)) {
                drawCenteredString(g, "Settings", rect, font, Color.black, Color.yellow);
            }
            // Settings
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
            rect = new Rectangle(0, 0, Game.WIDTH/16, Game.HEIGHT/16);
            drawCenteredString(g, ""+(Game.frames), rect, font, Color.white, Color.black);
            // Frames
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
            rect = new Rectangle(0, Game.HEIGHT/16, Game.WIDTH/16, Game.HEIGHT/16);
            drawCenteredString(g, ""+((Game.timer-Game.init)/1000), rect, font, Color.white, Color.black);
            // Timer
        }
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, Color color1, Color color2) {
    // ? https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
        FontMetrics metrics = g.getFontMetrics(font);
        // Get the FontMetrics
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the X coordinate for the text
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        g.setFont(font);
        // Set the font
        g.setColor(Game.randomColorBy2);
        // Set the colour
        g.drawString(text, x-(rect.width)/32, y+(Game.HEIGHT/50));
        g.drawString(text, x, y+(Game.HEIGHT/50));
        g.drawString(text, x+(rect.width)/32, y+(Game.HEIGHT/50));
        // Draw the String
        g.setColor(color2);
        // Set the colour
        g.drawString(text, x-(Game.WIDTH/100), y);
        g.drawString(text, x+(Game.WIDTH/100), y);
        g.drawString(text, x, y-(Game.HEIGHT/100));
        g.drawString(text, x, y+(Game.HEIGHT/100));
        g.drawString(text, x-(Game.WIDTH/100), y-(Game.HEIGHT/100));
        g.drawString(text, x+(Game.WIDTH/100), y+(Game.HEIGHT/100));
        g.drawString(text, x-(Game.WIDTH/100), y+(Game.HEIGHT/100));
        g.drawString(text, x+(Game.WIDTH/100), y-(Game.HEIGHT/100));
        // Draw the Strings
        g.setColor(color1);
        // Set the colour
        g.drawString(text, x, y);
        // Draw the String
    }
}