/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Thursday, December 21st, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2c
    +MouseInput.java [9] (Frontend)
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

public class MouseInput extends MouseAdapter {
    public static AudioPlayer audioplayer;

    public MouseInput() {
        audioplayer = new AudioPlayer();
    }
    // Constructor to initialize the audioplayer object

    public void mousePressed(MouseEvent e) {
        String file = "colon_3.wav";
        audioplayer.play(file);
        if (mouseOver(HUD.mx, HUD.my, HUD.play) && HUD.menu == "Title") {HUD.menu = "Play";}
        else if (mouseOver(HUD.mx, HUD.my, HUD.settings) && HUD.menu == "Title") {HUD.menu = "Settings";}
        else if (mouseOver(HUD.mx, HUD.my, HUD.op1) && HUD.menu == "Settings") {
            Game.WIDTH = 640;
            Game.HEIGHT = 480;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op2) && HUD.menu == "Settings") {
            Game.WIDTH = 800;
            Game.HEIGHT = 600;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op3) && HUD.menu == "Settings") {
            Game.WIDTH = 960;
            Game.HEIGHT = 720;
            Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
            Window.frame.setLocationRelativeTo(null);
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op4) && HUD.menu == "Settings") {
            Game.red = (int) (Math.random()*128+64);
            Game.green = (int) (Math.random()*128+64);
            Game.blue = (int) (Math.random()*128+64);
            Game.randomColor = new Color(Game.red, Game.green, Game.blue);
            Game.randomColorBy2 = new Color(Game.red/2, Game.green/2, Game.blue/2);
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op6) && (HUD.menu == "Settings" || HUD.menu == "Play")) {HUD.menu = "Title";}
        else if (mouseOver(HUD.mx, HUD.my, HUD.op1) && HUD.menu == "Play") {
            // TODO: menu = "PvE";
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op2) && HUD.menu == "Play") {
            HUD.menu = "PnP";
            Data.InitPnP();
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op3) && HUD.menu == "Play") {
            // TODO: menu = "LAN";
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op4) && HUD.menu == "???") {
            // TODO: menu = "???";
        }

        else if (mouseOver(HUD.mx, HUD.my, HUD.op1) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 1;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op2) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 2;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op3) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 3;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op4) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 4;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op5) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 5;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op6) && Data.turn == 12) {
            Data.turn = 13;
            Data.cata = 6;
        }

        else if (mouseOver(HUD.mx, HUD.my, HUD.op1) && Data.turn == 13 && !Data.questions.get(-Data.cata).get(0).contains("+")) {
            Data.removeCharactersFromGrid(Data.attributes.get(-(10*Data.cata+1)), 1);
            Data.turn = 14;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op2) && Data.turn == 13 && !Data.questions.get(-Data.cata).get(0).contains("+")) {
            Data.removeCharactersFromGrid(Data.attributes.get(-(10*Data.cata+2)), 1);
            Data.turn = 14;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op3) && Data.turn == 13 && !Data.questions.get(-Data.cata).get(0).contains("+")) {
            Data.removeCharactersFromGrid(Data.attributes.get(-(10*Data.cata+3)), 1);
            Data.turn = 14;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op4) && Data.turn == 13 && !Data.questions.get(-Data.cata).get(0).contains("+")) {
            Data.removeCharactersFromGrid(Data.attributes.get(-(10*Data.cata+4)), 1);
            Data.turn = 14;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op5) && Data.turn == 13 && !Data.questions.get(-Data.cata).get(0).contains("+")) {
            Data.removeCharactersFromGrid(Data.attributes.get(-(10*Data.cata+5)), 1);
            Data.turn = 14;
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op6) && Data.turn == 13) {
            Data.turn = 12;
            Data.cata = 0;
        }
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        HUD.mx = e.getX();
        HUD.my = e.getY();
    }

    public static boolean mouseOver(int mx, int my, Rectangle rect) {
        if ((HUD.mx > rect.x && HUD.mx < rect.x + rect.width) && (HUD.my > rect.y && HUD.my < rect.y + rect.height)) {
            return true;
        }
        else {
            return false;
        }
    }
}