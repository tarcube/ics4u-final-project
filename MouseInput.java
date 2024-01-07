/*
    +MouseInput.java [10] (Frontend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.awt.*;
import java.awt.event.*;

// TODO: Comment

public class MouseInput extends MouseAdapter {
    public static AudioPlayer audioplayer;

    // Constructor to initialize the audioplayer object
    public MouseInput() {
        audioplayer = new AudioPlayer();
    }

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
            BoardInitialiser.parseHumanAttributes();
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op3) && HUD.menu == "Play") {
            // TODO: menu = "LAN";
        }
        else if (mouseOver(HUD.mx, HUD.my, HUD.op4) && HUD.menu == "???") {
            // TODO: menu = "???";
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