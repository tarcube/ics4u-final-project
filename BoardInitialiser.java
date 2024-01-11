/*
    +BoardInitialiser.java [2] (Backend)
    
    This class initializes all the necessary components for creating the character board
*/

// Imports
import java.util.*;
import java.io.*;

public class BoardInitialiser {
    // Initialise random number generator
    private static Random r = new Random();
    // ArrayList of humans
    public static ArrayList<Human> humans = new ArrayList<>();
    // Handler for managing game objects
    private static Handler handler;
    // Computer text output object
    public static Human Computer;

    public BoardInitialiser(Handler handler) {
        this.handler = handler;
    }

    // This method parses a text file to gather information about which attributes humans have
    public static void parseHumanAttributes() {
        try {
            // Creates ArrayList that stores all of the character names
            ArrayList<String> humanNames = new ArrayList<String>(24);
            String line = "";
            // This Scanner Class identifies all the character names from the text file and inputs them into the ArrayList
            File file = new File("HumanAttribute.txt");
            Scanner reader = new Scanner(file);
            line = reader.nextLine();
            while (line != "") {
                line = reader.nextLine();
                if (line != "") humanNames.add(line);
            }

            // This hashmap handles all the names that each attribute contains
            HashMap<String, ArrayList<String>> attributes = new HashMap<>();
            String attribute = "";
            ArrayList<String> names = new ArrayList<String>();
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.startsWith("_")) {
                    attributes.put(attribute, new ArrayList<String>(names));
                    names.clear();
                    attribute = line;
                }
                else {
                    if (line != "") names.add(line);
                }
            }
            reader.close();
            humanFactory(humanNames, attributes);
        }
        catch (FileNotFoundException e) {System.out.println(e);}
    }

    // This method takes the information gathered earlier and builds the human objects
    public static void humanFactory(ArrayList<String> humanNames, HashMap<String, ArrayList<String>> attributes) {
        for (int i = 0; i < humanNames.size(); i++) {
            // Each character's position in the grid
            int x = (int)(i%6+1)*Game.WIDTH/7-Game.WIDTH/9;
            int y = (int)(Math.floor(i/6)+1)*Game.HEIGHT/6;
            Human human = new Human(x, y, Game.WIDTH/8, Game.HEIGHT/8, ID.Human);
            String name = humanNames.get(i);
            human.setName(name);
            // if character contains attribute, add that attribute to the character
            if (attributes.get("_brown_hair_").contains(name)) human.setHairColour("brown");
            if (attributes.get("_black_hair_").contains(name)) human.setHairColour("black");
            if (attributes.get("_blond_hair_").contains(name)) human.setHairColour("blond");
            if (attributes.get("_white_hair_").contains(name)) human.setHairColour("white");
            if (attributes.get("_ginger_hair_").contains(name)) human.setHairColour("ginger");
            if (attributes.get("_long_hair_").contains(name)) human.setHairLength("long");
            if (attributes.get("_tied_hair_").contains(name)) human.setHairLength("tied");
            if (attributes.get("_short_hair_").contains(name)) human.setHairLength("short");
            if (attributes.get("_no_hair_").contains(name)) human.setHairLength("none");
            if (attributes.get("_brown_eye_").contains(name)) human.setEyeColour("brown");
            if (attributes.get("_green_eye_").contains(name)) human.setEyeColour("green");
            if (attributes.get("_blue_eye_").contains(name)) human.setEyeColour("blue");
            human.setGlasses(attributes.get("_glasses_").contains(name));
            human.setEarrings(attributes.get("_piercings_").contains(name));
            human.setHeadGear(attributes.get("_headgear_").contains(name));
            human.setFacialHair(attributes.get("_facial_hair_").contains(name));
            human.setVisibleTeeth(attributes.get("_visible_teeth_").contains(name));
            if (attributes.get("_pale_skin_").contains(name)) human.setSkinColour("pale");
            if (attributes.get("_dark_skin_").contains(name)) human.setSkinColour("dark");
            humans.add(human);
            handler.addObject(human);
        }
    }

    // initializes the player vs AI gamemode
    public static void initialisePlayerVsComputer() {
        for (int i = 0; i < humans.size(); i++) {handler.removeObject(humans.get(i));}
        for (int i = 0; i < StateChecker.prompts.size(); i++) {handler.removeObject(StateChecker.prompts.get(i));}
        parseHumanAttributes();
        StateChecker.computerGrid = new ArrayList<Human>(humans);
    }

    // This method finalizes the game after the player has chosen a character
    public static void finishSetup(int type) {
        // Sets the question menu and sets it as the player's turn
        if (type == 0) {
            HUD.setMenu("");
            StateChecker.turn = "Player";
            for (int i = 0; i < humans.size(); i++) {
                humans.get(i).setDx(-Game.WIDTH/40);
            }
            StateChecker.playerGrid = humans;
            StateChecker.setCamera("PromptQuestions");
            StateChecker.computerHuman = humans.get(r.nextInt(24));
            while (StateChecker.computerHuman.getIfOutlawed()) {
                StateChecker.computerHuman = humans.get(r.nextInt(24));
            }
            Human Eliminate = new Human(Game.WIDTH/3-Game.WIDTH/4, Game.HEIGHT-Game.HEIGHT/6, Game.WIDTH/6, Game.HEIGHT/8, ID.Eliminate);
            Human Finish = new Human(Game.WIDTH/3, Game.HEIGHT-Game.HEIGHT/6, Game.WIDTH/6, Game.HEIGHT/8, ID.Finish);
            Human Guess = new Human(Game.WIDTH/3+Game.WIDTH/4, Game.HEIGHT-Game.HEIGHT/6, Game.WIDTH/6, Game.HEIGHT/8, ID.Guess);
            Computer = new Human(Game.WIDTH/4, Game.HEIGHT/4-Game.HEIGHT, Game.WIDTH/2, Game.HEIGHT/2, ID.Computer);
            humans.add(Eliminate);
            humans.add(Finish);
            humans.add(Guess);
            humans.add(Computer);
            handler.addObject(Eliminate);
            handler.addObject(Finish);
            handler.addObject(Guess);
            handler.addObject(Computer);
            Eliminate.setName("Toggle Flag");
            Finish.setName("Finish Turn");
            Guess.setName("Guess Who");
            Computer.setName("Good Game!");
            Eliminate.setDx(-Game.WIDTH/40);
            Finish.setDx(-Game.WIDTH/40);
            Guess.setDx(-Game.WIDTH/40);
            Computer.setDx(-Game.WIDTH/40);
        }
        // opens the text file that contains the questions that can be asked
        try {
            File file = new File("QuestionPrompt.txt");
            Scanner reader = new Scanner(file);
            String line = reader.nextLine();
            ArrayList<String> temporary = new ArrayList<String>();
            for (int i = 0; i <= 7; i++) {
                Integer id = Integer.parseInt(line);
                line = reader.nextLine();
                while (!line.contains("-")) {
                    if (line != "") {
                        temporary.add(line);
                    }
                    line = reader.nextLine();
                }
                StateChecker.questions.put(id, new ArrayList<String>(temporary));
                temporary.clear();
            }
            reader.close();
        }
        catch (Exception e) {System.out.println(e);}
        addButtons();
        for (int i = 0; i < StateChecker.prompts.size(); i++) {
            StateChecker.prompts.get(i).setDx(-Game.WIDTH/40);
        }
        StateChecker.catagory = 0;
    }

    // This method adds buttons to the GUI for each option
    public static void addButtons() {
        PromptQuestionButton op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*0+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button1);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*1+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button2);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*2+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button3);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*3+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button4);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*4+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button5);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*5+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button6);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4+Game.WIDTH, Game.HEIGHT/7*0+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT-Game.HEIGHT/6, ID.Button7);
        handler.addObject(op);
        StateChecker.prompts.add(op);
    }
}