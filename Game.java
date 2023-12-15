/*
    Ian F., Kevin X., Matthew X.
    Friday, December 15th, 2023
    Guess Who - Final Programming Assignment
    Version Alpha 0.1
    +Game.java [1] (MAIN)
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

// TODO: Self-explanatory
// ! Use this if the code contains errors
// ? Use this if you need help optimizing the code
// * Use this to highlight comments
// . Use this for normal comments
//// Use this to disregard things

public class Game extends Canvas implements Runnable {
// This class extends the Canvas class and implements the Runnable interface
// indicating it can be used as a separate thread
    public static int WIDTH = 800, HEIGHT = 600;
    // Static variables for the canvas size
    private final int SPACEX = 14, SPACEY = 37;
    // Variables for the window size
    private Thread thread;
    // Thread for the game
    private boolean running = false;
    // Flag to check if the game is running
    private Random r;
    // Random number generator
    private Handler handler;
    // Handler for managing game objects
    private final long init = System.currentTimeMillis();

    public static int red = (int) (Math.random()*255);
    public static int green = (int) (Math.random()*255);
    public static int blue = (int) (Math.random()*255);
    public static Color randomColor = new Color(red, green, blue);
    public static Color randomColorBy2 = new Color(red/2, green/2, blue/2);
    // Random colors for the game

    public Game() {
    // Constructor for the game
        handler = new Handler();
        // Initialize the handler
        this.addKeyListener(new KeyInput(handler));
        // Add key listener
        new Window(WIDTH+SPACEX, HEIGHT+SPACEY, "Guess Who!", this);
        // Create a new window for the game
        r = new Random();
        // Initialize the random number generator
        for (int i = 0; i < 1_000; i++) {
            handler.addObject(new Object(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(20), r.nextInt(20), ID.Object, r.nextInt(10), r.nextInt(10), 0, 0, 1));
            // Add objects to the game
        }
        handler.addObject(new Object(0, 0, 0, 0, ID.Temporary, 0, 0, 0, 0, 1));
        // Add a temporary object to the game
    }

    private void tick(int ticks) {
        handler.tick(ticks);
    } // Method to update the game state

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    } // Method to start the game

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {}
    } // Method to stop the game

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000.0 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;
        while (running) {
        // Game loop
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta >= 1) {
                tick(ticks);
                delta--;
                ticks++;
                if (running) {
                    Toolkit.getDefaultToolkit().sync();
                    render();
                    frames++;
                }
            }
            if (System.currentTimeMillis() - timer > 1000) {
            // Print the frames per second
                timer += 1000;
                if ((timer-init)/1000 % 5 == 0) {
                    System.out.println("Timer: " + (timer-init)/1000 + " | FPS: " + frames);
                }
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    } // Method to run the game

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(randomColorBy2);
        g.fillRect(0,0,WIDTH,HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
    } // Method to render the game

    public static void main(String[] args) {
    // Main method to start the game
        if (args.length != 0) {
        // Check if arguments were provided
            int w = Integer.parseInt(args[0]);
            int h = Integer.parseInt(args[1]);
        }
        new Game();
        // Start the game
    }
}