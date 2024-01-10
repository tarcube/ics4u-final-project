/*
    +StateChecker.java [13] (Backend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.util.*;

public class StateChecker {
    public static Human playerHuman;
    public static Human computerHuman;
    public static String turn;
    private static String camera;
    public static ArrayList<Human> playerGrid;
    public static ArrayList<Human> computerGrid;
    public static HashMap<Integer, ArrayList<String>> questions = new HashMap<Integer, ArrayList<String>>();
    public static ArrayList<PromptQuestionButton> prompts = new ArrayList<>();
    public static int catagory;

    public static Boolean compareAttributes(int id) {
        catagory = 7;
        if (-11 == id) {return computerHuman.getHairColour() == "brown";}
        if (-12 == id) {return computerHuman.getHairColour() == "black";}
        if (-13 == id) {return computerHuman.getHairColour() == "blond";}
        if (-14 == id) {return computerHuman.getHairColour() == "white";}
        if (-15 == id) {return computerHuman.getHairColour() == "ginger";}
        if (-21 == id) {return computerHuman.getHairLength() == "long";}
        if (-22 == id) {return computerHuman.getHairLength() == "tied";}
        if (-23 == id) {return computerHuman.getHairLength() == "short";}
        if (-24 == id) {return computerHuman.getHairLength() == "none";}
        if (-31 == id) {return computerHuman.getEyeColour() == "brown";}
        if (-32 == id) {return computerHuman.getEyeColour() == "green";}
        if (-33 == id) {return computerHuman.getEyeColour() == "blue";}
        if (-41 == id) {return computerHuman.getGlasses();}
        if (-42 == id) {return computerHuman.getEarrings();}
        if (-43 == id) {return computerHuman.getHeadGear();}
        if (-44 == id) {return computerHuman.getFacialHair();}
        if (-51 == id) {return computerHuman.getSkinColour() == "pale";}
        if (-52 == id) {return computerHuman.getSkinColour() == "dark";}
        if (-53 == id) {return computerHuman.getGender() == "male";}
        if (-54 == id) {return computerHuman.getGender() == "female";}
        if (-61 == id) {return computerHuman.getVisibleTeeth();}
        return null;
    }

    public static String getCamera() {return camera;}
    public static void setCamera(String camera) {StateChecker.camera = camera;}
}