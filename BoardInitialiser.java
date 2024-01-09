/*
    +BoardInitialiser.java [2] (Backend)
    TODO: Add summary of contents in this class
*/

// TODO: Comment this class

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

    public BoardInitialiser(Handler handler) {
        this.handler = handler;
    }

    // This method parses a text file to gather information about which attributes humans have
    public static void parseHumanAttributes() {
        try {
            ArrayList<String> humanNames = new ArrayList<String>(24);
            String line = "";
            File file = new File("HumanAttribute.txt");
            Scanner reader = new Scanner(file);
            line = reader.nextLine();
            while (line != "") {
                line = reader.nextLine();
                if (line != "") humanNames.add(line);
            }
            //// for (int i = 0; i < humans.size(); i++) {
            ////     System.out.println(humans.get(i));
            //// }
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
            //// System.out.println(attributes);
            humanFactory(humanNames, attributes);
        }
        catch (FileNotFoundException e) {System.out.println(e);}
    }

    // This method takes the information gathered earlier and builds the human objects
    public static void humanFactory(ArrayList<String> humanNames, HashMap<String, ArrayList<String>> attributes) {
        for (int i = 0; i < humanNames.size(); i++) {
            int x = (int)(i%6+1)*Game.WIDTH/7-Game.WIDTH/9;
            int y = (int)(Math.floor(i/6)+1)*Game.HEIGHT/6;
            Human human = new Human(x, y, Game.WIDTH/8, Game.HEIGHT/8, ID.Human);
            String name = humanNames.get(i);
            human.setName(name);
            if (attributes.get("_brown_hair_").contains(name)) human.setHairColour("brown");
            if (attributes.get("_black_hair_").contains(name)) human.setHairColour("black");
            if (attributes.get("_blond_hair_").contains(name)) human.setHairColour("blond");
            if (attributes.get("_white_hair_").contains(name)) human.setHairColour("white");
            if (attributes.get("_ginger_hair_").contains(name)) human.setHairColour("ginger");
            if (attributes.get("_long_hair_").contains(name)) human.setHairLength("long");
            if (attributes.get("_short_hair_").contains(name)) human.setHairLength("short");
            if (attributes.get("_no_hair_").contains(name)) human.setHairLength("none");
            if (attributes.get("_brown_eye_").contains(name)) human.setEyeColour("brown");
            if (attributes.get("_green_eye_").contains(name)) human.setEyeColour("green");
            if (attributes.get("_blue_eye_").contains(name)) human.setEyeColour("blue");
            human.setGlasses(attributes.get("_glasses_").contains(name));
            human.setEarrings(attributes.get("_earrings_").contains(name));
            human.setHeadGear(attributes.get("_covering_").contains(name));
            human.setBeard(attributes.get("_beard_").contains(name));
            human.setMoustache(attributes.get("_moustache_").contains(name));
            if (attributes.get("_pale_skin_").contains(name)) human.setSkinColour("pale");
            if (attributes.get("_dark_skin_").contains(name)) human.setSkinColour("dark");
            humans.add(human);
            handler.addObject(human);
        }
        //// for (int i = 0; i < 24; i++) System.out.println(humans.get(i).getName());
        for (int j = 0; j < humans.size(); j++) {
            humans.get(j).setIfSelected(false);
        }
        humans.get(r.nextInt(24)).setIfSelected(true);
    }

    public static void initialisePlayerVsComputer() {
        for (int i = 0; i < humans.size(); i++) {handler.removeObject(humans.get(i));}
        parseHumanAttributes();
        StateChecker.computerGrid = new ArrayList<Human>(humans);
    }

    public static void finishSetup(int type) {
        if (type == 0) {
            HUD.menu = "";
            StateChecker.turn = "Player";
            for (int i = 0; i < humans.size(); i++) {
                humans.get(i).setDx(-Game.WIDTH/40);
                if (humans.get(i).getIfSelected()) {
                    StateChecker.playerHuman = humans.get(i);
                    humans.get(i).setIfOutlawed(true);
                }
                humans.get(i).setIfSelected(false);
            }
            StateChecker.playerGrid = humans;
            StateChecker.camera = "PromptQuestions";
            StateChecker.computerHuman = humans.get(r.nextInt(24));
            while (StateChecker.computerHuman.getIfOutlawed()) {
                StateChecker.computerHuman = humans.get(r.nextInt(24));
            }
        }
        try {
            File file = new File("QuestionPrompt.txt");
            Scanner reader = new Scanner(file);
            String line = reader.nextLine();
            ArrayList<String> temporary = new ArrayList<String>();
            for (int i = 0; i < 6; i++) {
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
        //// System.out.println(StateChecker.questions);
        addButtons();
        StateChecker.catagory = 0;
    }

    public static void addButtons() {
        PromptQuestionButton op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*0+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button1);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*1+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button2);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*2+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button3);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*3+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button4);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*4+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button5);
        handler.addObject(op);
        StateChecker.prompts.add(op);
        op = new PromptQuestionButton(Game.WIDTH/4, Game.HEIGHT/7*5+Game.HEIGHT/12, Game.WIDTH/2, Game.HEIGHT/8, ID.Button6);
        handler.addObject(op);
        StateChecker.prompts.add(op);
    }
}