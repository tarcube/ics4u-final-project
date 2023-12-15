/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1a
    +Handler.java [3]
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

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    // LinkedList that holds all GameObject instances
    
    public void tick(int ticks) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick(ticks);
        }
    } // Method to update all GameObjects in the list

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    } // Method to render all GameObjects in the list

    public void addObject(GameObject object) {this.object.add(object);}
    // Method to add a GameObject to the list
    public void removeObject(GameObject object) {this.object.remove(object);}
    // Method to remove a GameObject from the list
}