/*
    Ian F., Kevin X., Matthew X.
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1
    +GameObject.java [2]
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

public abstract class GameObject {
    protected int x, y;
    protected int w, h;
    protected ID id;
    protected int velX, velY;
    protected int dW, dH;
    protected int z;

    public GameObject(int x, int y, int w, int h, ID id, int velX, int velY, int dW, int dH, int z) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.id = id;
        this.velX = velX;
        this.velY = velY;
        this.dW = dW;
        this.dH = dH;
        this.z = z;
    }

    public abstract void tick(int ticks);
    public abstract void render(Graphics g);

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
    public void setVelX(int velX) {this.velX = velX;}
    public void setVelY(int velY) {this.velY = velY;}
    public int getVelX() {return velX;}
    public int getVelY() {return velY;}
    public void setdW(int dW) {this.dW = dW;}
    public void setdH(int dH) {this.dH = dH;}
    public int getdW() {return dW;}
    public int getdH() {return dH;}
}