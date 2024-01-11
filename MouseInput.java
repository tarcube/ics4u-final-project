/*
    +MouseInput.java [10] (Frontend)
    
    This program handles all mouse action
*/

// Imports
import java.awt.*;
import java.awt.event.*;

// TODO: complete detailed comments 

// handles all mouse activities 
public class MouseInput extends MouseAdapter {
    public static AudioPlayer audioplayer;

    // Constructor to initialize the audioplayer object
    public MouseInput() {
        audioplayer = new AudioPlayer();
    }

    // actions when mouse is pressed
    public void mousePressed(MouseEvent e) {
        // sound feedback everytime mouse is pressed
        String file = "sfx/colon_3.wav";
        audioplayer.play(file);

        if (HUD.getMenu() == "Title") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) HUD.setMenu("Play");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) HUD.setMenu("Settings");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op5)) HUD.setMenu("Information");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Credits");
        }

        else if (HUD.getMenu() == "Settings") {
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
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "Play") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op1)) {
                HUD.setMenu("PvC");
                BoardInitialiser.initialisePlayerVsComputer();
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op2)) {
                // TODO: HUD.setMenu("CvP");
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) {
                // TODO: HUD.setMenu("H2P");
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) {
                // TODO: TODO: HUD.setMenu("VMH");
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "Information") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "Credits") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "PvC") {
            if (MouseInput.mouseCollideRect(HUD.mx, HUD.my, new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8))) {
                BoardInitialiser.finishSetup(0);
            }
        }

        else if (StateChecker.getCamera() == "PromptQuestions") {
            for (int i = 0; i < StateChecker.prompts.size(); i++) {
                if (StateChecker.prompts.get(i).mouseOverButton(HUD.mx, HUD.my) && !StateChecker.prompts.get(i).getIfUnavailable()) {
                    if (StateChecker.catagory == 0) {
                        if (StateChecker.prompts.get(i).getId() == ID.Button1) {
                            StateChecker.catagory = -1;
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button2) {
                            StateChecker.catagory = -2;
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button3) {
                            StateChecker.catagory = -3;
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button4) {
                            StateChecker.catagory = -4;
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button5) {
                            StateChecker.catagory = -5;
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button6) {
                            StateChecker.catagory = -6;
                        }
                    }
                    else {
                        if (StateChecker.prompts.get(i).getId() == ID.Button1) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(0) +"'";
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-1, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                            }
                            else {StateChecker.output += "\n The answer is 'No.' \n";}
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button2) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(1) +"'";
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-2, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                            }
                            else {StateChecker.output += "\n The answer is 'No.' \n";}
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button3) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(2) +"'";
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-3, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                            }
                            else {StateChecker.output += "\n The answer is 'No.' \n";}
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button4) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(3) +"'";
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-4, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                            }
                            else {StateChecker.output += "\n The answer is 'No.' \n";}
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button5) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(4) +"'";
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-5, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                            }
                            else {StateChecker.output += "\n The answer is 'No.' \n";}
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button6) {
                            StateChecker.catagory = 0;
                        }
                    }
                }
            }
        }

        else if (StateChecker.getCamera() == "HumansGrid") {
            for (int i = 0; i < StateChecker.playerGrid.size(); i++) {
                if (StateChecker.playerGrid.get(i).mouseOverHuman(HUD.mx, HUD.my)) {
                    if (StateChecker.playerGrid.get(i).getId() == ID.Human) {
                        if (!StateChecker.playerGrid.get(i).getIfSelected()) {
                            StateChecker.playerGrid.get(i).setIfSelected(true);
                        }
                        else if (StateChecker.playerGrid.get(i).getIfSelected()) {
                            StateChecker.playerGrid.get(i).setIfSelected(false);
                        }
                    }

                    else if (StateChecker.playerGrid.get(i).getId() == ID.Eliminate) {
                        for (int j = 0; j < StateChecker.playerGrid.size(); j++) {
                            if (StateChecker.playerGrid.get(j).getIfSelected()) {
                                StateChecker.playerGrid.get(j).setIfSelected(false);
                                if (!StateChecker.playerGrid.get(j).getIfOutlawed()) {
                                    StateChecker.playerGrid.get(j).setIfOutlawed(true);
                                }
                                else if (StateChecker.playerGrid.get(j).getIfOutlawed()) {
                                    StateChecker.playerGrid.get(j).setIfOutlawed(false);
                                }
                            }
                        }
                    }

                    else if (StateChecker.playerGrid.get(i).getId() == ID.Finish) {
                        StateChecker.turn = "Computer";
                        for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                            BoardInitialiser.humans.get(j).setDy(Game.HEIGHT/30);
                        }
                        StateChecker.aiGreedyAlgorithm();
                    }

                    else if (StateChecker.playerGrid.get(i).getId() == ID.Guess) {
                        StateChecker.turn = "Computer";
                        for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                            BoardInitialiser.humans.get(j).setDy(Game.HEIGHT/30);
                            if (BoardInitialiser.humans.get(j).getIfSelected()) {
                                if (BoardInitialiser.humans.get(j) == StateChecker.computerHuman) {
                                    System.out.println(StateChecker.computerHuman.getName() + " was right!");
                                }
                                else {
                                    System.out.println(BoardInitialiser.humans.get(j).getName() + " was wrong...");
                                }
                            }
                        }
                    }

                    else if (StateChecker.turn == "Computer") {
                        if (StateChecker.playerGrid.size() == 1) {
                            StateChecker.computer = "Good Game!";
                        }
                        else if (StateChecker.playerGrid.get(i).getId() == ID.Yes) {
                            StateChecker.aiRemoveHumansFromGrid(true, StateChecker.max_id);
                            for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                BoardInitialiser.humans.get(j).setDy(-Game.HEIGHT/30);
                            }
                            StateChecker.turn = "Player";
                            StateChecker.catagory = 0;
                        }
                        else if (StateChecker.playerGrid.get(i).getId() == ID.No) {
                            StateChecker.aiRemoveHumansFromGrid(false, StateChecker.max_id);
                            for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                BoardInitialiser.humans.get(j).setDy(-Game.HEIGHT/30);
                            }
                            StateChecker.turn = "Player";
                            StateChecker.catagory = 0;
                        }
                    }
                }
            }
        }
    }

    // actions when moused is released 
    public void mouseReleased(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        HUD.mx = e.getX();
        HUD.my = e.getY();
        if (StateChecker.turn == "Player") {
            if (e.getX() < Game.WIDTH/10 && StateChecker.getCamera() == "PromptQuestions") {
                for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
                    BoardInitialiser.humans.get(i).setDx(Game.WIDTH/40);
                }
                for (int i = 0; i < StateChecker.prompts.size(); i++) {
                    StateChecker.prompts.get(i).setDx(Game.WIDTH/40);
                }
                StateChecker.setCamera("HumansGrid");
            }
            if (e.getX() > Game.WIDTH-Game.WIDTH/10 && StateChecker.getCamera() == "HumansGrid") {
                for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
                    BoardInitialiser.humans.get(i).setDx(-Game.WIDTH/40);
                }
                for (int i = 0; i < StateChecker.prompts.size(); i++) {
                    StateChecker.prompts.get(i).setDx(-Game.WIDTH/40);
                }
                StateChecker.setCamera("PromptQuestions");
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