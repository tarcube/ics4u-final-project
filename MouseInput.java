/*
    +MouseInput.java [10] (Frontend)
    
    This program handles all mouse action
*/

// Imports
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Handles all mouse activities 
public class MouseInput extends MouseAdapter {

    public static AudioPlayer audioplayer;

    // Constructor to initialise the audioplayer object
    public MouseInput() {
        audioplayer = new AudioPlayer();
    }

    // Actions when mouse is pressed
    public void mousePressed(MouseEvent err) {

        // Sound feedback everytime mouse is pressed
        String file = "sfx/colon_3.wav";
        audioplayer.play(file);

        // Actions in Title page
        if (HUD.getMenu() == "Title") {

            // When mouse clicks on set coordinates, change page according to input
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) HUD.setMenu("Play");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) HUD.setMenu("Settings");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op5)) HUD.setMenu("Information");
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Credits");
        }

        // Actions in Settings page
        else if (HUD.getMenu() == "Settings") {

            // Whem mouse clicks on set coordinates, change window size according to input
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

        // Actions in Play page
        else if (HUD.getMenu() == "Play") {

            // When mouse clicks on set coordinates, go to selected window

            // Player vs Computer: Type 0 means player goes first
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op1)) {
                HUD.setMenu("PvC");
                BoardInitialiser.initialisePlayerVsComputer(0);
            }

            // Player vs Computer: Type 1 means computer goes first
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op2)) {
                HUD.setMenu("PvC");
                BoardInitialiser.initialisePlayerVsComputer(1);
            }

            // How to Play page
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op3)) {
                HUD.setMenu("H2P");
            }

            // View Match History page
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op4)) {
                HUD.setMenu("VMH");
            }
            else if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "Information") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "Credits") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Title");
        }

        else if (HUD.getMenu() == "H2P") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Play");
        }

        else if (HUD.getMenu() == "VMH") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) HUD.setMenu("Play");
        }

        else if (HUD.getMenu() == "PvC") {
            if (MouseInput.mouseCollideRect(HUD.mx, HUD.my, new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8))) {
                BoardInitialiser.finishSetup(BoardInitialiser.type);
            }
        }

        // Return to "Play" page when pressed done
        else if (StateChecker.turn == "Done") {
            if (mouseCollideRect(HUD.mx, HUD.my, HUD.op6)) {
                BoardInitialiser.removeGameplay();
                StateChecker.turn = "";
                HUD.setMenu("Play");
            }
        }

        else if (StateChecker.turn == "Done?") {
            for (int i = 0; i < StateChecker.playerGrid.size(); i++) {
                if (StateChecker.playerGrid.get(i).mouseOverHuman(HUD.mx, HUD.my)) {

                    // If computer won actions
                    if (StateChecker.playerGrid.get(i).getId() == ID.Yes) {
                        StateChecker.turn = "Done";
                        BoardInitialiser.Computer.setName("Computer wins, good game!");

                        // Write "computer won" message to log.txt
                        try {
                            FileWriter fw = new FileWriter("log.txt", true);
                            fw.write("\n\nComputer guessed right and won - " + Game.timer);
                            fw.close();
                        }
                        catch (IOException e) {System.out.println(e);}
                    }

                    // If computer lost actions
                    if (StateChecker.playerGrid.get(i).getId() == ID.No) {
                        StateChecker.turn = "ErrorCheck";

                        // Retrieve 
                        BoardInitialiser.Computer.setName("Type below human's name, then hit enter.");

                        // Write "computer lost" message to log.txt
                        try {
                            FileWriter fw = new FileWriter("log.txt", true);
                            fw.write("\n\nComputer guessed wrong and lost - " + Game.timer);
                            fw.close();
                        }
                        catch (IOException e) {System.out.println(e);}
                        KeyInput.typing = true;
                    }
                }
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
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer asked '" + StateChecker.questions.get(StateChecker.catagory).get(0) +"' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-1, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'Yes.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                            else {
                                StateChecker.output += "\n The answer is 'No.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'No.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button2) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(1) +"'";
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer asked '" + StateChecker.questions.get(StateChecker.catagory).get(1) +"' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-2, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'Yes.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                            else {
                                StateChecker.output += "\n The answer is 'No.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'No.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button3) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(2) +"'";
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer asked '" + StateChecker.questions.get(StateChecker.catagory).get(2) +"' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-3, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'Yes.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                            else {
                                StateChecker.output += "\n The answer is 'No.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'No.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button4) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(3) +"'";
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer asked '" + StateChecker.questions.get(StateChecker.catagory).get(3) +"' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-4, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'Yes.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                            else {
                                StateChecker.output += "\n The answer is 'No.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'No.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                        }

                        if (StateChecker.prompts.get(i).getId() == ID.Button5) {
                            StateChecker.output += "You asked \n'" + StateChecker.questions.get(StateChecker.catagory).get(4) +"'";
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer asked '" + StateChecker.questions.get(StateChecker.catagory).get(4) +"' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                            if (StateChecker.compareAttributes(StateChecker.catagory*10-5, false, 0)) {
                                StateChecker.output += "\n The answer is 'Yes.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'Yes.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
                            else {
                                StateChecker.output += "\n The answer is 'No.' \n";
                                try {
                                    FileWriter fw = new FileWriter("log.txt", true);
                                    fw.write("\n\nComputer responded with 'No.' - " + Game.timer);
                                    fw.close();
                                }
                                catch (IOException e) {System.out.println(e);}
                            }
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
                        if (StateChecker.turn == "Guessing") {
                            StateChecker.turn = "Done";
                            int count = 0;
                            for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                if (BoardInitialiser.humans.get(j).getIfSelected()) {
                                    count++;
                                }
                            }
                            if (count != 1) StateChecker.turn = "Player";
                            if (count == 1) {
                                for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                    BoardInitialiser.humans.get(j).setDy(Game.HEIGHT/30);
                                    if (BoardInitialiser.humans.get(j).getIfSelected()) {
                                        if (BoardInitialiser.humans.get(j) == StateChecker.computerHuman) {
                                            BoardInitialiser.Computer.setName(BoardInitialiser.humans.get(j).getName() + " is right!");
                                            try {
                                                FileWriter fw = new FileWriter("log.txt", true);
                                                fw.write("\n\nPlayer guessed right and won - " + Game.timer);
                                                fw.close();
                                            }
                                            catch (IOException e) {System.out.println(e);}
                                        }
                                        else {
                                            BoardInitialiser.Computer.setName(BoardInitialiser.humans.get(j).getName() + " is wrong. Right one was " + StateChecker.computerHuman.getName());
                                            try {
                                                FileWriter fw = new FileWriter("log.txt", true);
                                                fw.write("\n\nPlayer guessed wrong and lost - " + Game.timer);
                                                fw.close();
                                            }
                                            catch (IOException e) {System.out.println(e);}
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            StateChecker.turn = "Guessing";
                        }
                    }

                    else if (StateChecker.turn == "Computer") {
                        if (StateChecker.playerGrid.get(i).getId() == ID.Yes) {
                            StateChecker.aiRemoveHumansFromGrid(true, StateChecker.max_id);
                            for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                BoardInitialiser.humans.get(j).setDy(-Game.HEIGHT/30);
                            }
                            StateChecker.turn = "Player";
                            StateChecker.catagory = 0;
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer responded 'Yes.' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
                        }
                        else if (StateChecker.playerGrid.get(i).getId() == ID.No) {
                            StateChecker.aiRemoveHumansFromGrid(false, StateChecker.max_id);
                            for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
                                BoardInitialiser.humans.get(j).setDy(-Game.HEIGHT/30);
                            }
                            StateChecker.turn = "Player";
                            StateChecker.catagory = 0;
                            try {
                                FileWriter fw = new FileWriter("log.txt", true);
                                fw.write("\n\nPlayer responded 'No.' - " + Game.timer);
                                fw.close();
                            }
                            catch (IOException e) {System.out.println(e);}
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