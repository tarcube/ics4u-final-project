/*
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
    private String name = "";
    private String hairColour;
    private String hairLength;
    private String eyeColour;
    private boolean glasses;
    private boolean earrings;
    private boolean headGear;
    private boolean beard;
    private boolean moustache;
    private String skinColour;

    public Human(int x, int y, int w, int h, ID id, int z) {
        super(x, y, w, h, id, z);
    }

    public void tick(int ticks) {
        if (id == ID.Human) {}
    }

    public void render(Graphics g) {
        if (id == ID.Human) {
            g.setColor(Game.randomColorBy2);
            g.fillRect(x, y, w, h);
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(name, x+w/10, y+h/2+h/3);
        }
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
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