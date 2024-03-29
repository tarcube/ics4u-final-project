/*
    +PromptQuestionButton.java [12] (Backend)

    This class handles rendering of the question prompts for the player to choose from.
    
*/

// Import
import java.awt.*;

// Child class of GameObject
public class PromptQuestionButton extends GameObject {

    // variable if mouse is hovering over set coordinates 
    private boolean hovered;

    // variable used to define if a button cannot be clicked or being hovered
    private boolean unavailable;

    // variables for the initial position of the button before it moves
    private int initX;
    private int initY;

    // variables for change in velocity of the mouse
    private int dx = 0;
    private int dy = 0;

    // Inherit attributes from GameObject
    public PromptQuestionButton(int x, int y, int w, int h, ID id) {
        super(x, y, w, h, id);
        this.initX = x - Game.WIDTH;
        this.initY = y;
    }

    // Tick method
    public void tick(int ticks) {
        if (mouseOverButton(HUD.mx, HUD.my) && StateChecker.catagory != -7) hovered = true;
        else hovered = false;
        x += dx;
        y += dy;
        if (x < initX) dx = 0;
        if (x > initX+Game.WIDTH) dx = 0;
    }

    // Renders questions that player chooses from 
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
            Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/60);
            g.setFont(font);
            g.setColor(Game.randomColor);
            text = StateChecker.output;
            int split = y;
            for (String line : text.split("\n")) {
                g.drawString(line, x+w/10, split += g.getFontMetrics().getHeight());
            }
        }
        else if (!text.contains("+")) {
            g.drawString(text, x+w/10, y+h/2+h/3);
            unavailable = false;
        }
        else {
            g.setColor(Game.randomColor);
            g.fillRect(x, y, w, h);
            unavailable = true;
        }
    }

    // Mouse locator
    public boolean mouseOverButton(int mx, int my) {
        if ((mx > x && mx < x + w) && (my > y && my < y + h)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Setter method for unavailable boolean variable
    public boolean getIfUnavailable() {return unavailable;}

    // Setter methods to get change in x and y positions
    public void setDx(int dx) {this.dx = dx;}
    public void setDy(int dy) {this.dy = dy;}
}