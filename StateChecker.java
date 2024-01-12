/*
    +StateChecker.java [13] (Backend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.util.*;
import java.io.*;

public class StateChecker {
    public static Human computerHuman;
    public static String turn;
    private static String camera;
    public static ArrayList<Human> playerGrid;
    public static ArrayList<Human> computerGrid;
    public static HashMap<Integer, ArrayList<String>> questions = new HashMap<Integer, ArrayList<String>>();
    public static ArrayList<PromptQuestionButton> prompts = new ArrayList<>();
    public static int catagory;
    public static String output = "";
    public static int max_id;
    public static String log = "";
    public static ArrayList<Integer> idCheckComputed = new ArrayList<Integer>();
    public static ArrayList<Boolean> userResponses = new ArrayList<Boolean>();
    // Initialise random number generator
    private static Random r = new Random();

    public static Boolean compareAttributes(int id, boolean ai, int j) {
        Human human = computerGrid.get(j);
        if (!ai) {human = computerHuman;}
        catagory = -7;
        if (-11 == id) {return human.getHairColour() == "brown";}
        if (-12 == id) {return human.getHairColour() == "black";}
        if (-13 == id) {return human.getHairColour() == "blond";}
        if (-14 == id) {return human.getHairColour() == "white";}
        if (-15 == id) {return human.getHairColour() == "ginger";}
        if (-21 == id) {return human.getHairLength() == "long";}
        if (-22 == id) {return human.getHairLength() == "tied";}
        if (-23 == id) {return human.getHairLength() == "short";}
        if (-24 == id) {return human.getHairLength() == "none";}
        if (-31 == id) {return human.getEyeColour() == "brown";}
        if (-32 == id) {return human.getEyeColour() == "green";}
        if (-33 == id) {return human.getEyeColour() == "blue";}
        if (-41 == id) {return human.getGlasses();}
        if (-42 == id) {return human.getEarrings();}
        if (-43 == id) {return human.getHeadGear();}
        if (-44 == id) {return human.getFacialHair();}
        if (-51 == id) {return human.getSkinColour() == "pale";}
        if (-52 == id) {return human.getSkinColour() == "dark";}
        if (-53 == id) {return human.getGender() == "male";}
        if (-54 == id) {return human.getGender() == "female";}
        if (-61 == id) {return human.getVisibleTeeth();}
        return null;
    }

    public static void aiGreedyAlgorithm() {
        int[] ids = new int[] {-11, -12, -13, -14, -15, -21, -22, -23, -24, -31, -32, -33, -41, -42, -43, -44, -51, -52, -53, -54, -61};
        float min_range = computerGrid.size();
        max_id = 0;
        for (int i = 0; i < ids.length; i++) {
            int count = 0;
            for (int j = 0; j < computerGrid.size(); j++) {
                if (compareAttributes(ids[i], true, j)) {
                    count++;
                }
            }
            int range = Math.abs(count - (computerGrid.size()-count));
            if (range == min_range && r.nextInt(2) == 1) {
                min_range = range;
                max_id = ids[i];
            }
            if (range < min_range) {
                min_range = range;
                max_id = ids[i];
            }
        }
        if (computerGrid.size() == 1) {
            BoardInitialiser.Computer.setName("'Is your character " + computerGrid.get(0).getName() + "?'");
            turn = "Done?";
            try {
                FileWriter fw = new FileWriter("log.txt", true);
                fw.write("\n\nComputer asked " + ("'Is your character " + computerGrid.get(0).getName() + "?'") +" - " + Game.timer);
                fw.close();
            }
            catch (IOException e) {System.out.println(e);}
        }
        else {
            BoardInitialiser.Computer.setName("'" + questions.get((int)(max_id/10)).get(-max_id%10-1) +"'");
            try {
                FileWriter fw = new FileWriter("log.txt", true);
                fw.write("\n\nComputer asked " + ("'" + questions.get((int)(max_id/10)).get(-max_id%10-1) +"'") +" - " + Game.timer);
                fw.close();
            }
            catch (IOException e) {System.out.println(e);}
            idCheckComputed.add(max_id);
        }
    }

    public static void aiRemoveHumansFromGrid(boolean answer, int id) {
        ArrayList<Human> namesToRemove = new ArrayList<Human>();
        for (int j = 0; j < computerGrid.size(); j++) {
            if (compareAttributes(id, true, j)) {
                if (!answer) namesToRemove.add(computerGrid.get(j));
            }
            if (!compareAttributes(id, true, j)) {
                if (answer) namesToRemove.add(computerGrid.get(j));
            }
        }
        for (int j = 0; j < namesToRemove.size(); j++) {
            computerGrid.remove(namesToRemove.get(j));
        }
        userResponses.add(answer);
    }

    public static void errorCheck(String name) {
        int playerHuman = 0;
        computerGrid = BoardInitialiser.humans;
        for (int i = 0; i < playerGrid.size(); i++) {
            if (name.toUpperCase().contains(playerGrid.get(i).getName())) {
                playerHuman = i;
            }
        }
        int numberOfQuestionsAndResponses = idCheckComputed.size() + userResponses.size();
        String errors = "";
        for (int i = 0; i < numberOfQuestionsAndResponses/2; i++) {
            if (compareAttributes(idCheckComputed.get(i), false, playerHuman) != userResponses.get(i)) {
                errors += "Computer asked '" + questions.get((int)(idCheckComputed.get(i)/10)).get(-idCheckComputed.get(i)%10-1) +"'\n";
                errors += "Player answered " + userResponses.get(i) + ", when it should be " + !userResponses.get(i) + ".\n";
            }
        }
        catagory = -7;
        turn = "Done";
        output = errors;
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            fw.write("\n\nStart of Error Detection Check Log\n\n" + errors + "\nEnd of Error Detection Check Log - " + Game.timer);
            fw.close();
        }
        catch (IOException e) {System.out.println(e);}
        for (int i = 0; i < BoardInitialiser.humans.size(); i++) {
            BoardInitialiser.humans.get(i).setDx(-Game.WIDTH/40);
        }
        for (int i = 0; i < StateChecker.prompts.size(); i++) {
            StateChecker.prompts.get(i).setDx(-Game.WIDTH/40);
        }
        for (int j = 0; j < BoardInitialiser.humans.size(); j++) {
            BoardInitialiser.humans.get(j).setDy(-Game.HEIGHT/30);
        }
    }

    public static String getCamera() {return camera;}
    public static void setCamera(String camera) {StateChecker.camera = camera;}
}