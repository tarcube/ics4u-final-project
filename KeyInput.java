import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public static HashSet<Integer> keysPressed = new HashSet<>();

    public static void clickSFX() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Game.class.getResource("colon_3.wav"));
            Clip sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @Override

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keysPressed.add(key);
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Temporary) {
                if (key == KeyEvent.VK_SPACE) {
                    switchColourTheme();
                }
            }
        }
    }

    @Override

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keysPressed.remove(key);
    }

    private void switchColourTheme() {
        Game.red = (int) (Math.random()*255);
        Game.green = (int) (Math.random()*255);
        Game.blue = (int) (Math.random()*255);
        Game.randomColor = new Color(Game.red, Game.green, Game.blue);
        Game.randomColorBy2 = new Color(Game.red/2, Game.green/2, Game.blue/2);
        clickSFX();
    }
}