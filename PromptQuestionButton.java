/*
    +PromptQuestionButton.java [12] (Backend)
    TODO: Add summary of contents in this class
*/

// Import
import java.awt.*;

public class PromptQuestionButton extends GameObject {
    private boolean hovered;
    private boolean unavailable;
    private int initX;
    private int initY;
    private int dx = 0;
    private int dy = 0;

    public PromptQuestionButton(int x, int y, int w, int h, ID id) {
        super(x, y, w, h, id);
        this.initX = x - Game.WIDTH;
        this.initY = y;
    }

    public void tick(int ticks) {
        if (mouseOverButton(HUD.mx, HUD.my) && StateChecker.catagory != -7) hovered = true;
        else hovered = false;
        x += dx;
        y += dy;
        if (x < initX) dx = 0;
        if (x > initX+Game.WIDTH) dx = 0;
    }

    public void render(Graphics g) {
        if (id != ID.Button7 || StateChecker.catagory == -7) {
            if (!hovered) g.setColor(Game.randomColorBy2);
            else g.setColor(new Color(0, 0, 0, 64));
            g.fillRect(x, y, w, h);
        }
        String text = "";
        if (id == ID.Button1) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.questions.get(StateChecker.catagory).get(0);
        }
        if (id == ID.Button2) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.questions.get(StateChecker.catagory).get(1);
        }
        if (id == ID.Button3) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.questions.get(StateChecker.catagory).get(2);
        }
        if (id == ID.Button4) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.questions.get(StateChecker.catagory).get(3);
        }
        if (id == ID.Button5) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.questions.get(StateChecker.catagory).get(4);
        }
        if (id == ID.Button6) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            if (StateChecker.catagory == 0) {
                text = StateChecker.questions.get(StateChecker.catagory).get(5);
            }
            else if (StateChecker.catagory == -7) {text = "+";}
            else {text = "Back";}
        }
        if (id == ID.Button7 && StateChecker.catagory == -7) {
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
            g.setFont(font);
            g.setColor(Game.randomColor);
            if (StateChecker.output) text = "Yes";
            else if (!StateChecker.output) text = "No";
            g.drawString(text, x+w/10, y+h/2+h/3);
        }
        if (!text.contains("+")) {
            g.drawString(text, x+w/10, y+h/2+h/3);
            unavailable = false;
        }
        else {
            g.setColor(Game.randomColor);
            g.fillRect(x, y, w, h);
            unavailable = true;
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

    public boolean getIfUnavailable() {return unavailable;}
    public void setDx(int dx) {this.dx = dx;}
    public void setDy(int dy) {this.dy = dy;}
}