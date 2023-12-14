import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class Object extends GameObject {
    public Object(int x, int y, int w, int h, ID id, int velX, int velY, int velW, int velH) {
        super(x, y, w, h, id, velX, velY, velW, velH);
    }

    public void tick(int ticks) {
        if (id == ID.Object) {
            x += velX;
            y += velY;
            w += velW;
            h += velH;
            if (x < 0 || x > Game.WIDTH-w) {velX *= -1;}
            if (y < 0 || y > Game.HEIGHT-h) {velY *= -1;}
            if (KeyInput.keysPressed.contains((int)'W')) {
                y -= velY;
            }
            if (KeyInput.keysPressed.contains((int)'S')) {
                y += velY;
            }
        }
    }

    public void render(Graphics g) {
        if (id == ID.Object) {
            g.setColor(Game.randomColor);
            g.fillRect(x, y, w, h);
        }
    }
}