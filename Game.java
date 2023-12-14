import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class Game extends Canvas implements Runnable {
    public static int WIDTH = 800, HEIGHT = 600;
    private final int SPACEX = 14, SPACEY = 37;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;

    public static int red = (int) (Math.random()*255);
    public static int green = (int) (Math.random()*255);
    public static int blue = (int) (Math.random()*255);
    public static Color randomColor = new Color(red, green, blue);
    public static Color randomColorBy2 = new Color(red/2, green/2, blue/2);

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH+SPACEX, HEIGHT+SPACEY, "Guess Who!", this);
        r = new Random();
        for (int i = 0; i < 1_000; i++) {
            handler.addObject(new Object(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(20), r.nextInt(20), ID.Object, r.nextInt(10), r.nextInt(10), 0, 0));
        }
        handler.addObject(new Object(0, 0, 0, 0, ID.Temporary, 0, 0, 0, 0));
    }

    private void tick(int ticks) {
        handler.tick(ticks);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {}
    }

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
                System.out.println("FPS: " + frames);
                frames = 0;
                ticks = 0;
            }
        }
        stop();
    }

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
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            int w = Integer.parseInt(args[0]);
            int h = Integer.parseInt(args[1]);
        }
        new Game();
    }
}