/*
    +GameObject.java [4] (Frontend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.awt.*;

public abstract class GameObject {
    // Declaring protected instance variables
    // x and y coordinates
    protected int x, y;
    // width and height of the object
    protected int w, h;
    // unique identifier for each object
    protected ID id;
    // z-index for layering objects
    protected int z;

    // Constructor for the GameObject class
    public GameObject(int x, int y, int w, int h, ID id, int z) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.id = id;
        this.z = z;
    }

    // Abstract methods that will be implemented in the subclasses
    // method to update the state of the object
    public abstract void tick(int ticks);
    // method to draw the object
    public abstract void render(Graphics g);

    // Getter and setter methods for the instance variables
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public int getX() {return x;}
    public int getY() {return y;}
    public void setW(int w) {this.w = w;}
    public void setH(int h) {this.h = h;}
    public int getW() {return w;}
    public int getH() {return h;}
    public void setId(ID id) {this.id = id;}
    public ID getId() {return id;}
    public void setZ(int z) {this.z = z;}
    public int getZ() {return z;}
}