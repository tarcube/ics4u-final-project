/*
    Ian F., Kevin X., Matthew X.
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1
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

// TODO: Comment the rest of the code in this class

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(int ticks) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick(ticks);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {this.object.add(object);}
    public void removeObject(GameObject object) {this.object.remove(object);}
}