/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Monday, January 8th, 2024
    Guess Who - Final Programming Assignment
    Version Beta 0.3b
    +Human.java [7] (Backend)
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

public class Human extends GameObject {
    private String hairColour;
    private String hairLength;
    private String eyeColour;
    private boolean glasses;
    private boolean earrings;
    private boolean headGear;
    private boolean beard;
    private boolean moustache;
    private String skinColour;

    public Human(int x, int y, int w, int h, ID id, int z,
    String hairColour, String hairLength, String eyeColour,
    boolean glasses, boolean earrings, boolean headGear,
    boolean beard, boolean moustache, String skinColour)
    {
        super(x, y, w, h, id, z);
        this.hairColour = hairColour;
        this.hairLength = hairLength;
        this.eyeColour = eyeColour;
        this.glasses = glasses;
        this.earrings = earrings;
        this.headGear = headGear;
        this.beard = beard;
        this.moustache = moustache;
        this.skinColour = skinColour;
    }

    public void tick(int ticks) {}

    public void render(Graphics g) {}

    public String getHairColour() {return hairColour;}
    public void setHairColour(String hairColour) {this.hairColour = hairColour;}
    public String getHairLength() {return hairLength;}
    public void setHairLength(String hairLength) {this.hairLength = hairLength;}
    public String getEyeColour() {return eyeColour;}
    public void setEyeColour(String eyeColour) {this.eyeColour = eyeColour;}
    public boolean getGlasses() {return glasses;}
    public void setGlasses(Boolean glasses) {this.glasses = glasses;}
    public boolean getEarrings() {return earrings;}
    public void setEarrings(Boolean earrings) {this.earrings = earrings;}
    public boolean getHeadGear() {return headGear;}
    public void setHeadGear(Boolean headGear) {this.headGear = headGear;}
    public boolean getBeard() {return beard;}
    public void setBeard(Boolean beard) {this.beard = beard;}
    public boolean getMoustache() {return moustache;}
    public void setMoustache(Boolean moustache) {this.moustache = moustache;}
    public String getSkinColour() {return skinColour;}
    public void setSkinColour(String skinColour) {this.skinColour = skinColour;}
}