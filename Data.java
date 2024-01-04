/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Monday, January 8th, 2024
    Guess Who - Final Programming Assignment
    Version Beta 0.3b
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
    public static HashMap<Integer, ArrayList<String>> questions;
    public static ArrayList<String> playerOneCharGrid;
    public static ArrayList<String> playerTwoCharGrid;
    public static int turn = 0;
    public static int cata = 0;
    public static int counter;

    public static void InitPnP() {
        turn = 10;
        characters = new ArrayList<String>();
        attributes = new HashMap<Integer, ArrayList<String>>();
        questions = new HashMap<Integer, ArrayList<String>>();
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
                Integer id = Integer.parseInt(line);
                line = scanner.nextLine();
                while (!line.contains("-")) {
                    temporary.add(line);
                    line = scanner.nextLine();
                }
                questions.put(id, new ArrayList<String>(temporary));
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

    public static void removeCharactersFromGrid(ArrayList<String> matches, int player) {
        counter = 0;
        if (player == 1) {
            ////System.out.println(playerOneCharGrid.size());
            for (int i = 0; i < playerOneCharGrid.size(); i++) {
                if (!matches.contains(playerOneCharGrid.get(i))) {
                    playerOneCharGrid.remove(i);
                    counter++;
                } // ! WHY WONT THIS WORK???
                else {
                    System.out.println(playerOneCharGrid.get(i));
                }
            }
        }
        if (player == 2) {
            ////System.out.println(playerTwoCharGrid.size());
            for (int i = 0; i < playerTwoCharGrid.size(); i++) {
                if (!matches.contains(playerTwoCharGrid.get(i))) {
                    playerTwoCharGrid.remove(i);
                    counter++;
                } // ! WHY WONT THIS WORK???
                else {
                    System.out.println(playerTwoCharGrid.get(i));
                }
            }
        }
    }
}