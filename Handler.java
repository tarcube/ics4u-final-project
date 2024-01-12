/*
    +Handler.java [5] (Frontend)

    This class handles all the objects in the game

*/

// Imports
import java.awt.*;
import java.util.*;

public class Handler {

    // LinkedList that holds all GameObject instances
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    // Method to update all GameObjects in the list
    public void tick(int ticks) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick(ticks);
        }
    }

    // Method to render all GameObjects in the list
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    // Method to add a GameObject to the list
    public void addObject(GameObject object) {this.object.add(object);}
    
    // Method to remove a GameObject from the list
    public void removeObject(GameObject object) {this.object.remove(object);}
}