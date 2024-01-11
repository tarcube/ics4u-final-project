/*
    +Human.java [7] (Backend)

    This class handles character object creation
*/

// Imports
import java.awt.*;

public class Human extends GameObject {
    // initialize all the character attribute variables
    private String name = "";
    private String gender;
    private String hairColour;
    private String hairLength;
    private String eyeColour;
    private boolean glasses;
    private boolean earrings;
    private boolean headGear;
    private boolean facialHair;
    private boolean visibleTeeth;
    private String skinColour;

    private boolean hovered;
    private boolean selected;
    private boolean outlawed;
    private int initX;
    private int initY;
    private int dx = 0;
    private int dy = 0;

    public Human(int x, int y, int w, int h, ID id) {
        // inherits variables from GameObject
        super(x, y, w, h, id);
        this.initX = x;
        this.initY = y;
    }

    // this method handles ticks
    public void tick(int ticks) {
        if (mouseOverHuman(HUD.mx, HUD.my) && id != ID.Computer) hovered = true;
        else hovered = false;
        x += dx;
        y += dy;
        if (x < initX-Game.WIDTH) dx = 0;
        if (x > initX) dx = 0;
        if (y < initY) dy = 0;
        if (y > initY+Game.HEIGHT) dy = 0;
    }

    // This method handles how the GUI is displayed
    public void render(Graphics g) { 
        // generates a random background color
        if (!hovered) g.setColor(Game.randomColorBy2);
        else g.setColor(new Color(0, 0, 0, 64));
        if (selected) g.setColor(new Color(255, 255, 0, 128));
        g.fillRect(x, y, w, h);

        // imports the font used for the game
        Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/40);
        g.setFont(font);
        g.setColor(Game.randomColor);
        g.drawString(name, x+w/10, y+h/2+h/3);
        if (outlawed) {
            g.setColor(new Color(255, 0, 0, 255));
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
            g.setFont(font);
            g.drawString("X", x+w/4, y+h);
        }

        // renders pictures of humans
        try {
            Image img1 = Toolkit.getDefaultToolkit().getImage(name+".png");
            g.drawImage(img1, x, y, null);
        }
        catch (Exception e) {System.out.println(e);}
    }

    // This method handles if the mouse is hovering over a character box
    public boolean mouseOverHuman(int mx, int my) {
        if ((mx > x && mx < x + w) && (my > y && my < y + h)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Getters and Setter methods
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}
    public String getHairColour() {return hairColour;}
    public void setHairColour(String hairColour) {this.hairColour = hairColour;}
    public String getHairLength() {return hairLength;}
    public void setHairLength(String hairLength) {this.hairLength = hairLength;}
    public String getEyeColour() {return eyeColour;}
    public void setEyeColour(String eyeColour) {this.eyeColour = eyeColour;}
    public boolean getGlasses() {return glasses;}
    public void setGlasses(Boolean glasses) {this.glasses = glasses;}
    public boolean getEarrings() {return earrings;}
    public void setEarrings(Boolean earrings) {this.earrings = earrings;}
    public boolean getHeadGear() {return headGear;}
    public void setHeadGear(Boolean headGear) {this.headGear = headGear;}
    public boolean getFacialHair() {return facialHair;}
    public void setFacialHair(Boolean beard) {this.facialHair = facialHair;}
    public boolean getVisibleTeeth() {return visibleTeeth;}
    public void setVisibleTeeth(Boolean visibleTeeth) {this.visibleTeeth = visibleTeeth;}
    public String getSkinColour() {return skinColour;}
    public void setSkinColour(String skinColour) {this.skinColour = skinColour;}

    public boolean getIfSelected() {return selected;}
    public void setIfSelected(boolean selected) {this.selected = selected;}
    public boolean getIfOutlawed() {return outlawed;}
    public void setIfOutlawed(boolean outlawed) {this.outlawed = outlawed;}

    public void setDx(int dx) {this.dx = dx;}
    public void setDy(int dy) {this.dy = dy;}
}