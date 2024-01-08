/*
    +PromptQuestionButton.java [12] (Backend)
    TODO: Add summary of contents in this class
*/

// Import
import java.awt.*;

public class PromptQuestionButton extends GameObject {
    private int initX;
    private int initY;
    private int dx = 0;
    private int dy = 0;

    public PromptQuestionButton(int x, int y, int w, int h, ID id, int z) {
        super(x, y, w, h, id, z);
    }

    public void tick(int ticks) {
        if (id == ID.Button) {
            x += dx;
            y += dy;
            // if (x < initX) dx = 0;
            // if (x > initX) dx = 0;
        }
    }

    public void render(Graphics g) {
        if (id == ID.Button) {
            g.setColor(Game.randomColorBy2);
            g.fillRect(x, y, w, h);
        }
    }

    public void setDx(int dx) {this.dx = dx;}
    public void setDy(int dy) {this.dy = dy;}
}