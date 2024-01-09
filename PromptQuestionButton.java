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

    public PromptQuestionButton(int x, int y, int w, int h, ID id) {
        super(x, y, w, h, id);
        this.initX = x;
        this.initY = y;
    }

    public void tick(int ticks) {
        x += dx;
        y += dy;
        if (x < initX) dx = 0;
        if (x > initX+Game.WIDTH) dx = 0;
    }

    public void render(Graphics g) {
        g.setColor(Game.randomColorBy2);
        g.fillRect(x, y, w, h);
    }

    public boolean mouseOverButton(int mx, int my) {
        if ((mx > x && mx < x + w) && (my > y && my < y + h)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setDx(int dx) {this.dx = dx;}
    public void setDy(int dy) {this.dy = dy;}
}