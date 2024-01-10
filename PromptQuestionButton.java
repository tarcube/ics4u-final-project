/*
    +PromptQuestionButton.java [12] (Backend)
    TODO: Add summary of contents in this class
*/

// Import
import java.awt.*;

public class PromptQuestionButton extends GameObject {
    private boolean hovered;
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
        if (mouseOverButton(HUD.mx, HUD.my)) hovered = true;
        else hovered = false;
        x += dx;
        y += dy;
        if (x < initX) dx = 0;
        if (x > initX+Game.WIDTH) dx = 0;
    }

    public void render(Graphics g) {
        if (!hovered) g.setColor(Game.randomColorBy2);
        else g.setColor(new Color(0, 0, 0, 64));
        g.fillRect(x, y, w, h);
        if (id == ID.Button1) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(StateChecker.questions.get(StateChecker.catagory).get(0), x+w/10, y+h/2+h/3);
        }
        if (id == ID.Button2) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(StateChecker.questions.get(StateChecker.catagory).get(1), x+w/10, y+h/2+h/3);
        }
        if (id == ID.Button3) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(StateChecker.questions.get(StateChecker.catagory).get(2), x+w/10, y+h/2+h/3);
        }
        if (id == ID.Button4) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(StateChecker.questions.get(StateChecker.catagory).get(3), x+w/10, y+h/2+h/3);
        }
        if (id == ID.Button5) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            g.drawString(StateChecker.questions.get(StateChecker.catagory).get(4), x+w/10, y+h/2+h/3);
        }
        if (id == ID.Button6) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            if (StateChecker.catagory == 0) {
                g.drawString(StateChecker.questions.get(StateChecker.catagory).get(5), x+w/10, y+h/2+h/3);
            }
            else {
                g.drawString("Back", x+w/10, y+h/2+h/3);
            }
        }
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