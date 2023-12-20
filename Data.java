/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Wednesday, December 20th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.2b
    +Data.java [2] (Backend)
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

public class Data {
    public static Random r;
    // Random number generator
    public static ArrayList<String> characters;
    public static String playerOneChar;
    public static String playerTwoChar;
    public static HashMap<Integer, ArrayList<String>> attributes;
    public static HashMap<String, ArrayList<String>> questions;
    public static ArrayList<String> playerOneCharGrid;
    public static ArrayList<String> playerTwoCharGrid;
    public static int turn = 10;

    public static void InitPnP() {
        characters = new ArrayList<String>();
        attributes = new HashMap<Integer, ArrayList<String>>();
        questions = new HashMap<String, ArrayList<String>>();
        try {
            File file = new File("CharactersAttributesAndQuestions.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            ArrayList<String> temporary = new ArrayList<String>();
            while (!line.contains("-")) {
                characters.add(line);
                line = scanner.nextLine();
            } // Characters
            for (int i = 0; i < 18; i++) {
                Integer id = Integer.parseInt(line);
                line = scanner.nextLine();
                while (!line.contains("-")) {
                    temporary.add(line);
                    line = scanner.nextLine();
                }
                attributes.put(id, new ArrayList<String>(temporary));
                temporary.clear();
            } // Attributes
            for (int i = 0; i < 6; i++) {
                String topic = line;
                line = scanner.nextLine();
                while (!line.contains("-")) {
                    temporary.add(line);
                    line = scanner.nextLine();
                }
                questions.put(topic, new ArrayList<String>(temporary));
                temporary.clear();
            } // Attributes
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

        //// for (String name : questions.keySet()) {
        ////     String key = name.toString();
        ////     String value = questions.get(name).toString();
        ////     System.out.println(key + " " + value);
        //// }

        r = new Random();
        // Initialize the random number generator
        playerOneChar = characters.get(r.nextInt(24));
        playerTwoChar = characters.get(r.nextInt(24));
        while (playerOneChar == playerTwoChar) {
            playerTwoChar = characters.get(r.nextInt(24));
        }
        //// System.out.println(playerOneChar+"\n"+playerTwoChar);

        playerOneCharGrid = new ArrayList<String>(characters);
        playerTwoCharGrid = new ArrayList<String>(characters);
    }
}