/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Monday, January 8th, 2024
    Guess Who - Final Programming Assignment
    Version Beta 0.3b
    +AudioPlayer.java [1] (Frontend)
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

public class AudioPlayer {
    public static void play(String file) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Game.class.getResource(file));
            Clip sound = AudioSystem.getClip();
            sound.open(audioInputStream);
            sound.start();
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}