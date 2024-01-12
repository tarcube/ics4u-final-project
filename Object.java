/*
    +Object.java [11] (Frontend)
    
    TODO: Add summary of contents in this class
*/

// Imports
import java.awt.*;

// This class extends the GameObject class and represents an object in the game
public class Object extends GameObject {

    // Constructor for the Object class
    public Object(int x, int y, int w, int h, ID id) {

        // Calling the superclass constructor with the given parameters
        super(x, y, w, h, id);
    }

    // Method to update the state of the object
    public void tick(int ticks) {

        // If the object's ID is Object, update its position and dimensions
        if (id == ID.Object) {}
    }

    // Method to render the object
    public void render(Graphics g) {

        // If the object's ID is Object
        if (id == ID.Object) {

            // Draw a rectangle at its position with its dimensions and a random color
            g.setColor(Game.randomColorBy2);
            g.fillRect(x, y, w, h);
        }
    }
}