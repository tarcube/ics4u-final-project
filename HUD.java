/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Thursday, December 21st, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2c
    +HUD.java [6] (Frontend)
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

// TODO: Comment

public class HUD {
    public static String menu = "Title";
    public static int mx, my;
    public static Rectangle play;
    public static Rectangle settings;
    public static Rectangle op1, op2, op3, op4, op5, op6;

    public void tick() {}

    public void render(Graphics g) {
        Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        Rectangle rect = new Rectangle(0, 0, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+(Game.frames), rect, font, Color.white, Color.black);
        // Frames

        font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        rect = new Rectangle(0, Game.HEIGHT/16, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+((Game.timer-Game.init)/1000), rect, font, Color.white, Color.black);
        // Timer

        op1 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op2 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);
        op3 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op4 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2, Game.WIDTH/2, Game.HEIGHT/8);
        op5 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op6 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);
        // Options

        if (menu == "Title") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
            rect = new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/2);
            drawCenteredString(g, "Guess Who?", rect, font, Color.red, Color.blue);
            // Title

            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            play = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/20, Game.WIDTH/2, Game.HEIGHT/8);
            if (MouseInput.mouseOver(mx, my, play)) {drawCenteredString(g, "> Play <", play, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Play", play, font, Color.black, Color.white);
            // Play

            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            settings = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/5, Game.WIDTH/2, Game.HEIGHT/8);
            if (MouseInput.mouseOver(mx, my, settings)) {drawCenteredString(g, "> Settings <", settings, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Settings", settings, font, Color.black, Color.white);
            // Settings
        }

        if (menu == "Settings") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            if (MouseInput.mouseOver(mx, my, op1)) {drawCenteredString(g, "> 640x480 <", op1, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "640x480", op1, font, Color.black, Color.white);
            // 640x480

            if (MouseInput.mouseOver(mx, my, op2)) {drawCenteredString(g, "> 800x600 <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "800x600", op2, font, Color.black, Color.white);
            // 800x600

            if (MouseInput.mouseOver(mx, my, op3)) {drawCenteredString(g, "> 960x720 <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "960x720", op3, font, Color.black, Color.white);
            // 960x720

            if (MouseInput.mouseOver(mx, my, op4)) {drawCenteredString(g, "> BG Colour <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "BG Colour", op4, font, Color.black, Color.white);
            // Colour

            if (MouseInput.mouseOver(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
            // Back
        }

        if (menu == "Play") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseOver(mx, my, op1)) {drawCenteredString(g, "> Against AI <", op1, font, Color.gray, Color.gray);}
            else drawCenteredString(g, "Against AI", op1, font, Color.gray, Color.gray);
            // Against AI

            if (MouseInput.mouseOver(mx, my, op2)) {drawCenteredString(g, "> Pass and Play <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Pass and Play", op2, font, Color.black, Color.white);
            // Pass and Play

            if (MouseInput.mouseOver(mx, my, op3)) {drawCenteredString(g, "> Local Area Network <", op3, font, Color.gray, Color.gray);}
            else drawCenteredString(g, "Local Area Network", op3, font, Color.gray, Color.gray);
            // Local Area Network

            if (MouseInput.mouseOver(mx, my, op4)) {drawCenteredString(g, "> ??? <", op4, font, Color.gray, Color.gray);}
            else drawCenteredString(g, "???", op4, font, Color.gray, Color.gray);
            // ???

            if (MouseInput.mouseOver(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
            // Back
        }

        if (menu == "PnP") {
            if (Data.turn == 10) {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);
                drawCenteredString(g, "Pass device to player 1", play, font, Color.black, Color.white);
                drawCenteredString(g, "Press spacebar to continue", settings, font, Color.black, Color.white);
            }

            if (Data.turn == 11) {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);
                drawCenteredString(g, "Your character is "+Data.playerOneChar, op1, font, Color.black, Color.white);
                drawCenteredString(g, "They have "+Data.playerTwoCharGrid.size()+" characters to choose from", op2, font, Color.black, Color.white);
                drawCenteredString(g, "You have "+Data.playerTwoCharGrid.size()+" characters to choose from", op3, font, Color.black, Color.white);
                drawCenteredString(g, "Ask questions to narrow the number down", op4, font, Color.black, Color.white);
                drawCenteredString(g, "Press spacebar to continue", settings, font, Color.black, Color.white);
            }

            if (Data.turn == 12) {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);
                if (MouseInput.mouseOver(mx, my, op1)) {drawCenteredString(g, "> Hair Colour <", op1, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Hair Colour", op1, font, Color.black, Color.white);
                // Hair Colour

                if (MouseInput.mouseOver(mx, my, op2)) {drawCenteredString(g, "> Hair Length <", op2, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Hair Length", op2, font, Color.black, Color.white);
                // Hair Length

                if (MouseInput.mouseOver(mx, my, op3)) {drawCenteredString(g, "> Eye Colour <", op3, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Eye Colour", op3, font, Color.black, Color.white);
                // Eye Colour

                if (MouseInput.mouseOver(mx, my, op4)) {drawCenteredString(g, "> Accessories <", op4, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Accessories", op4, font, Color.black, Color.white);
                // Accessories

                if (MouseInput.mouseOver(mx, my, op5)) {drawCenteredString(g, "> Facial Features <", op5, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Facial Features", op5, font, Color.black, Color.white);
                // Facial Features

                if (MouseInput.mouseOver(mx, my, op6)) {drawCenteredString(g, "> Skin Type <", op6, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Skin Type", op6, font, Color.black, Color.white);
                // Skin Type
            }

            if (Data.turn == 13) {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);
                ArrayList<String> prompts = new ArrayList<String>(Data.questions.get(-Data.cata));

                if (prompts.get(0).contains("+")) {;}
                else if (MouseInput.mouseOver(mx, my, op1)) {drawCenteredString(g, "> "+prompts.get(0)+" <", op1, font, Color.black, Color.yellow);}
                else drawCenteredString(g, prompts.get(0), op1, font, Color.black, Color.white);
                // 1

                if (prompts.get(1).contains("+")) {;}
                else if (MouseInput.mouseOver(mx, my, op2)) {drawCenteredString(g, "> "+prompts.get(1)+" <", op2, font, Color.black, Color.yellow);}
                else drawCenteredString(g, prompts.get(1), op2, font, Color.black, Color.white);
                // 2

                if (prompts.get(2).contains("+")) {;}
                else if (MouseInput.mouseOver(mx, my, op3)) {drawCenteredString(g, "> "+prompts.get(2)+" <", op3, font, Color.black, Color.yellow);}
                else drawCenteredString(g, prompts.get(2), op3, font, Color.black, Color.white);
                // 3

                if (prompts.get(3).contains("+")) {;}
                else if (MouseInput.mouseOver(mx, my, op4)) {drawCenteredString(g, "> "+prompts.get(3)+" <", op4, font, Color.black, Color.yellow);}
                else drawCenteredString(g, prompts.get(3), op4, font, Color.black, Color.white);
                // 4

                if (prompts.get(4).contains("+")) {;}
                else if (MouseInput.mouseOver(mx, my, op5)) {drawCenteredString(g, "> "+prompts.get(4)+" <", op5, font, Color.black, Color.yellow);}
                else drawCenteredString(g, prompts.get(4), op5, font, Color.black, Color.white);
                // 5

                if (MouseInput.mouseOver(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
                else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
                // Back
            }

            if (Data.turn == 14) {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);
                drawCenteredString(g, "You have removed "+Data.counter+" characters from the grid", play, font, Color.black, Color.white);
                drawCenteredString(g, "Press spacebar to continue", settings, font, Color.black, Color.white);
            }
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