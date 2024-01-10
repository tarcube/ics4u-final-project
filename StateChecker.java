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

    public static void compareAttributes(int id) {
        System.out.println("bruh");
    }

    public static String getCamera() {return camera;}
    public static void setCamera(String camera) {StateChecker.camera = camera;}
}