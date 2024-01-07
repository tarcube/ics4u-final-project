/*
    +GameObject.java [4] (Frontend)
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

public abstract class GameObject {
    // Declaring protected instance variables
    protected int x, y;
    // x and y coordinates
    protected int w, h;
    // width and height of the object
    protected ID id;
    // unique identifier for each object
    //// protected int velX, velY;
    //// velocity in the x and y directions
    //// protected int dW, dH;
    //// change in width and height
    protected int z;
    // z-index for layering objects

    public GameObject(int x, int y, int w, int h, ID id, /*int velX, int velY, int dW, int dH,*/ int z) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.id = id;
        ////this.velX = velX;
        ////this.velY = velY;
        ////this.dW = dW;
        ////this.dH = dH;
        this.z = z;
    } // Constructor for the GameObject class

    // Abstract methods that will be implemented in the subclasses
    public abstract void tick(int ticks);
    // method to update the state of the object
    public abstract void render(Graphics g);
    // method to draw the object

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
    //// public void setVelX(int velX) {this.velX = velX;}
    //// public void setVelY(int velY) {this.velY = velY;}
    //// public int getVelX() {return velX;}
    //// public int getVelY() {return velY;}
    //// public void setdW(int dW) {this.dW = dW;}
    //// public void setdH(int dH) {this.dH = dH;}
    //// public int getdW() {return dW;}
    //// public int getdH() {return dH;}
    public void setZ(int z) {this.z = z;}
    public int getZ() {return z;}
}