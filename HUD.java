/*
    +HUD.java [6] (Frontend)
    TODO: Add summary of contents in this class
*/

// Imports
import java.awt.*;

public class HUD {
    private static String menu = "Title";
    public static int mx, my;
    public static Rectangle op1, op2, op3, op4, op5, op6;

    public void tick() {}

    public void render(Graphics g) {
        // Frames
        Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        Rectangle rect = new Rectangle(0, 0, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+(Game.frames), rect, font, Color.white, Color.black);

        // Timer
        font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        rect = new Rectangle(0, Game.HEIGHT/16, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+((Game.timer-Game.init)/1000), rect, font, Color.white, Color.black);

        // Options
        op1 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op2 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);
        op3 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op4 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2, Game.WIDTH/2, Game.HEIGHT/8);
        op5 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op6 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);

        if (menu == "Title") {
            // Title
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
            rect = new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/3);
            drawCenteredString(g, "Guess Who?", rect, font, Color.red, Color.blue);

            // Play
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> Play <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Play", op3, font, Color.black, Color.white);

            // Settings
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> Settings <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Settings", op4, font, Color.black, Color.white);

            // Information
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseCollideRect(mx, my, op5)) {drawCenteredString(g, "> Information <", op5, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Information", op5, font, Color.black, Color.white);

            // Credits
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Credits <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Credits", op6, font, Color.black, Color.white);
        }

        else if (menu == "Settings") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // 640x480
            if (MouseInput.mouseCollideRect(mx, my, op1)) {drawCenteredString(g, "> 640x480 <", op1, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "640x480", op1, font, Color.black, Color.white);

            // 800x600
            if (MouseInput.mouseCollideRect(mx, my, op2)) {drawCenteredString(g, "> 800x600 <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "800x600", op2, font, Color.black, Color.white);

            // 960x720
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> 960x720 <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "960x720", op3, font, Color.black, Color.white);

            // Colour
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> BG Colour <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "BG Colour", op4, font, Color.black, Color.white);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        else if (menu == "Information") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Info
            drawCenteredString(g, "", op1, font, Color.black, Color.white);
            drawCenteredString(g, "Check", op2, font, Color.black, Color.white);
            drawCenteredString(g, "README.md", op3, font, Color.black, Color.white);
            drawCenteredString(g, "", op4, font, Color.black, Color.white);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        else if (menu == "Credits") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Credits
            drawCenteredString(g, "Ian F.", op1, font, Color.black, Color.white);
            drawCenteredString(g, "Kevin X.", op2, font, Color.black, Color.white);
            drawCenteredString(g, "Matthew X.", op3, font, Color.black, Color.white);
            drawCenteredString(g, "ICS4U", op4, font, Color.black, Color.white);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        else if (menu == "Play") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // User goes first!
            if (MouseInput.mouseCollideRect(mx, my, op1)) {drawCenteredString(g, "> User goes first! <", op1, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "User goes first!", op1, font, Color.black, Color.white);

            // AI goes first!
            if (MouseInput.mouseCollideRect(mx, my, op2)) {drawCenteredString(g, "> AI goes first! <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "AI goes first!", op2, font, Color.black, Color.white);

            // How to Play?
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> How to Play? <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "How to Play?", op3, font, Color.black, Color.white);

            // View Match History
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> View Match History <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "View Match History", op4, font, Color.black, Color.white);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        else if (menu == "H2P") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Info
            drawCenteredString(g, "1: Pick your human", op1, font, Color.black, Color.white);
            drawCenteredString(g, "2: Ask questions", op2, font, Color.black, Color.white);
            drawCenteredString(g, "3: Guess the AI's human", op3, font, Color.black, Color.white);
            drawCenteredString(g, "4: Optionally win", op4, font, Color.black, Color.white);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        else if (menu == "PvC") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            drawCenteredString(g, "Are You Ready?", new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.white);
            if (MouseInput.mouseCollideRect(mx, my, new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8))) {
                drawCenteredString(g, "> Yessir <", new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.yellow);
            }
            else drawCenteredString(g, "Yessir", new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.white);
        }

        if (StateChecker.turn == "Player") {
            if (StateChecker.getCamera() == "PromptQuestions") {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
                drawCenteredString(g, "<", new Rectangle(0, 0, Game.WIDTH/10, Game.HEIGHT), font, new Color(255, 255, 255, 64), new Color(255, 255, 255, 64));
            }

            if (StateChecker.getCamera() == "HumansGrid") {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
                drawCenteredString(g, ">", new Rectangle(Game.WIDTH-Game.WIDTH/10, 0, Game.WIDTH/10, Game.HEIGHT), font, new Color(255, 255, 255, 64), new Color(255, 255, 255, 64));
            }
        }

        else if (StateChecker.turn == "Done") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Back
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }
    }

    // ? https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, Color color1, Color color2) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Set the colour
        g.setColor(Game.randomColorBy2);
        // Draw the String
        g.drawString(text, x-(rect.width)/32, y+(Game.HEIGHT/50));
        g.drawString(text, x, y+(Game.HEIGHT/50));
        g.drawString(text, x+(rect.width)/32, y+(Game.HEIGHT/50));
        // Set the colour
        g.setColor(color2);
        // Draw the Strings
        g.drawString(text, x-(Game.WIDTH/100), y);
        g.drawString(text, x+(Game.WIDTH/100), y);
        g.drawString(text, x, y-(Game.HEIGHT/100));
        g.drawString(text, x, y+(Game.HEIGHT/100));
        g.drawString(text, x-(Game.WIDTH/100), y-(Game.HEIGHT/100));
        g.drawString(text, x+(Game.WIDTH/100), y+(Game.HEIGHT/100));
        g.drawString(text, x-(Game.WIDTH/100), y+(Game.HEIGHT/100));
        g.drawString(text, x+(Game.WIDTH/100), y-(Game.HEIGHT/100));
        // Set the colour
        g.setColor(color1);
        // Draw the String
        g.drawString(text, x, y);
    }

    public static String getMenu() {return menu;}
    public static void setMenu(String menu) {HUD.menu = menu;}
}