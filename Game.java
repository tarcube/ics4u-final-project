/*
    Ian F., Kevin X., Matthew X.
    Mr.A ICS4U1
    Friday, January 12th, 2024
    Guess Who - Final Programming Assignment
    Version Pre-Release 0.8a
    +Game.java [3] (MAIN)
    TODO: Add summary of contents in this class
*/

// TODO: Self-explanatory
// ! Use this if the code contains errors
// ? Use this if you need help optimizing the code
// * Use this to highlight comments
// . Use this for normal comments
//// Use this to disregard things

// Imports
import java.awt.*;
import java.awt.image.*;

// This class extends the Canvas class and implements the Runnable interface
// indicating it can be used as a separate thread
public class Game extends Canvas implements Runnable {
    // Static variables for the canvas size
    public static int WIDTH = 800, HEIGHT = 600;
    // Variables for the window size
    public static int SPACEX = 14, SPACEY = 36;
    // Thread for the game
    private Thread thread;
    // Flag to check if the game is running
    private boolean running = false;
    // Handler for managing game objects
    private Handler handler;
    // HUD for the game
    private HUD hud;
    // Backend classes for the game
    public static BoardInitialiser boardInitialiser;
    public static StateChecker stateChecker;
    // Get the exact time that the program was initialized
    public static final long init = System.currentTimeMillis();
    // timer
    public static long timer;
    // frames
    public static int frames;

    // Random colors for the game
    public static int red = (int) (Math.random()*128+64);
    public static int green = (int) (Math.random()*128+64);
    public static int blue = (int) (Math.random()*128+64);
    public static Color randomColor = new Color(red, green, blue);
    public static Color randomColorBy2 = new Color(red/2, green/2, blue/2);

    // Constructor for the game
    public Game() {
        // Initialize the handler
        handler = new Handler();
        // Add key listener
        this.addKeyListener(new KeyInput());
        // Add MouseListener
        this.addMouseListener(new MouseInput());
        // Add MouseMotionListener
        this.addMouseMotionListener(new MouseInput());
        // Create a new window for the game
        new Window(WIDTH+SPACEX, HEIGHT+SPACEY, "Guess Who?", this);
        // Create a new HUD for the game
        hud = new HUD();
        // Add the backend to the game
        boardInitialiser = new BoardInitialiser(handler);
        stateChecker = new StateChecker();
        // Add objects to the game
        handler.addObject(new Object(0, 0, 0, 0, ID.Object));
        handler.addObject(new Human(0, 0, 0, 0, ID.Object));
        handler.addObject(new PromptQuestionButton(0, 0, 0, 0, ID.Object));
    }

    // Method to update the game state
    private void tick(int ticks) {
        handler.tick(ticks);
        hud.tick();
    }

    // Method to start the game
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    // Method to stop the game
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {}
    }

    // Method to run the game
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000.0 / amountOfTicks;
        double delta = 0;
        timer = System.currentTimeMillis();
        frames = 0;
        int ticks = 0;
        // Game loop
        while (running) {
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
                timer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

    // Method to render the game
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(randomColor);
        g.fillRect(0,0,WIDTH,HEIGHT);
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }

    // Main method to start the game
    public static void main(String[] args) {
        // Start the game
        new Game();
    }
}