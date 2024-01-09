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

        if (HUD.menu == "Title") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) HUD.menu = "Play";
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) HUD.menu = "Settings";
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op5)) HUD.menu = "Information";
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.menu = "Credits";
        }

        else if (HUD.menu == "Settings") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op1)) {
                Game.WIDTH = 640;
                Game.HEIGHT = 480;
                Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
                Window.frame.setLocationRelativeTo(null);
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op2)) {
                Game.WIDTH = 800;
                Game.HEIGHT = 600;
                Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
                Window.frame.setLocationRelativeTo(null);
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) {
                Game.WIDTH = 960;
                Game.HEIGHT = 720;
                Window.frame.setSize(Game.WIDTH+Game.SPACEX, Game.HEIGHT+Game.SPACEY);
                Window.frame.setLocationRelativeTo(null);
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) {
                Game.red = (int) (Math.random()*128+64);
                Game.green = (int) (Math.random()*128+64);
                Game.blue = (int) (Math.random()*128+64);
                Game.randomColor = new Color(Game.red, Game.green, Game.blue);
                Game.randomColorBy2 = new Color(Game.red/2, Game.green/2, Game.blue/2);
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.menu = "Title";
        }

        else if (HUD.menu == "Play") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op1)) {
                HUD.menu = "PvC";
                BoardInitialiser.initialisePlayerVsComputer();
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op2)) {
                // TODO: HUD.menu = "PvC2";
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) {
                // TODO: HUD.menu = "PnP";
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) {
                // TODO: HUD.menu = "LAN";
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.menu = "Title";
        }

        else if (HUD.menu == "Information") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.menu = "Title";
        }

        else if (HUD.menu == "Credits") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.menu = "Title";
        }

        else if (HUD.menu == "PvC") {
            if (MouseInput.mouseCollideRect(HUD.mx, HUD.my, new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8))) {
                BoardInitialiser.finishSetup(0);
            }
            else for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
                if (BoardInitialiser.humans.get(i).mouseOverHuman(HUD.mx, HUD.my)) {
                    BoardInitialiser.humans.get(i).setIfSelected(true);
                    StateChecker.playerHuman = BoardInitialiser.humans.get(i);
                    for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                        if (i != j) BoardInitialiser.humans.get(j).setIfSelected(false);
                    }
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        HUD.mx = e.getX();
        HUD.my = e.getY();
        if (StateChecker.turn == "Player") {
            if (e.getX() < Game.WIDTH/10 && StateChecker.camera == "PromptQuestions") {
                for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
                    BoardInitialiser.humans.get(i).setDx(Game.WIDTH/40);
                }
                for (int i = 0; i < StateChecker.prompts.size(); i++) {
                    StateChecker.prompts.get(i).setDx(Game.WIDTH/40);
                }
                StateChecker.camera = "HumansGrid";
            }
            if (e.getX() > Game.WIDTH-Game.WIDTH/10 && StateChecker.camera == "HumansGrid") {
                for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
                    BoardInitialiser.humans.get(i).setDx(-Game.WIDTH/40);
                }
                for (int i = 0; i < StateChecker.prompts.size(); i++) {
                    StateChecker.prompts.get(i).setDx(-Game.WIDTH/40);
                }
                StateChecker.camera = "PromptQuestions";
            }
        }
    }

    public static boolean mouseCollideRect(int mx, int my, Rectangle rect) {
        if ((mx > rect.x && mx < rect.x + rect.width) && (my > rect.y && my < rect.y + rect.height)) {
            return true;
        }
        else {
            return false;
        }
    }
}