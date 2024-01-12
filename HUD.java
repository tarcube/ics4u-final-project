/*
    +HUD.java [6] (Frontend)
   
    This class handles all the renders for GUI. 
    There is a maximum of 6 lines of text for each page.
    Some text is displayed differently when mouse is hovering over it.
    External research used to centre text since defualt is to place it left.
    Getter and setter used for mouse input.
*/

// Imports
import java.awt.*;

public class HUD {

    // This variable is changed by the user's clicks when they go to different pages. 
    // Set as "Title" first since that is the first page when program starts.
    private static String menu = "Title";

    // m stands for mouse, x and y are positions
    public static int mx, my; 

    // There is a maximum of six buttons on each page; all button positions are predetermined
    public static Rectangle op1, op2, op3, op4, op5, op6; 

    public void render(Graphics g) {

        // Frame counter (60 fps)
        Font font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        Rectangle rect = new Rectangle(0, 0, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+(Game.frames), rect, font, Color.white, Color.black);

        // Match clock measured in seconds 
        font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/32);
        rect = new Rectangle(0, Game.HEIGHT/16, Game.WIDTH/16, Game.HEIGHT/16);
        drawCenteredString(g, ""+((Game.timer-Game.init)/1000), rect, font, Color.white, Color.black);

        // Initializing position of every option box
        op1 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op2 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);
        op3 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2-Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op4 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2, Game.WIDTH/2, Game.HEIGHT/8);
        op5 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/8, Game.WIDTH/2, Game.HEIGHT/8);
        op6 = new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/4, Game.WIDTH/2, Game.HEIGHT/8);


        // Setter methods in MouseInput class determine the menu
        // Renders on Title page
        if (menu == "Title") {

            // Renders the text "Guess Who?"
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
            rect = new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/3);
            drawCenteredString(g, "Guess Who?", rect, font, Color.red, Color.blue);

            // Renders the text "Play"
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> Play <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Play", op3, font, Color.black, Color.white);

            // Renders the text "Settings"
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> Settings <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Settings", op4, font, Color.black, Color.white);

            // Renders the text "Information"
            if (MouseInput.mouseCollideRect(mx, my, op5)) {drawCenteredString(g, "> Information <", op5, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Information", op5, font, Color.black, Color.white);

            // Renders the text "Credits"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Credits <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Credits", op6, font, Color.black, Color.white);
        }

        // Renders on Settings page 
        else if (menu == "Settings") {

            // Set font for Settings page
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Renders the text "640x480"
            if (MouseInput.mouseCollideRect(mx, my, op1)) {drawCenteredString(g, "> 640x480 <", op1, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "640x480", op1, font, Color.black, Color.white);

            // Renders the text "800x600"
            if (MouseInput.mouseCollideRect(mx, my, op2)) {drawCenteredString(g, "> 800x600 <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "800x600", op2, font, Color.black, Color.white);

            // Renders the text "960x720"
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> 960x720 <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "960x720", op3, font, Color.black, Color.white);

            // Renders the text "BG Colour"
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> BG Colour <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "BG Colour", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // Renders on Information page 
        else if (menu == "Information") {

            // Set font for Information page
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/25);

            // Renders information text on this page
            drawCenteredString(g, "Welcome to Guess Who?, a two player game where players", op1, font, Color.black, Color.white);
            drawCenteredString(g, "use differential yes or no questions to isolate a", op2, font, Color.black, Color.white);
            drawCenteredString(g, "hidden character. The first player to guess the other", op3, font, Color.black, Color.white);
            drawCenteredString(g, "player's hidden character wins.", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // Renders on Credits page
        else if (menu == "Credits") {

            // Set font for Credits page
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Renders credits text on this page
            drawCenteredString(g, "Project Manager - Ian F.", op1, font, Color.black, Color.white);
            drawCenteredString(g, "Lead Programmger -Kevin X.", op2, font, Color.black, Color.white);
            drawCenteredString(g, "Software Developer - Matthew X.", op3, font, Color.black, Color.white);
            drawCenteredString(g, "ICS4U", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // Renders on Play page
        else if (menu == "Play") {

            // Set font for Play page
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Renders the text "User goes first!"
            if (MouseInput.mouseCollideRect(mx, my, op1)) {drawCenteredString(g, "> User goes first! <", op1, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "User goes first!", op1, font, Color.black, Color.white);

            // Renders the text "AI goes first!"
            if (MouseInput.mouseCollideRect(mx, my, op2)) {drawCenteredString(g, "> AI goes first! <", op2, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "AI goes first!", op2, font, Color.black, Color.white);

            // Renders the text "How to Play?"
            if (MouseInput.mouseCollideRect(mx, my, op3)) {drawCenteredString(g, "> How to Play? <", op3, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "How to Play?", op3, font, Color.black, Color.white);

            // Renders the text "View Match History"
            if (MouseInput.mouseCollideRect(mx, my, op4)) {drawCenteredString(g, "> View Match History <", op4, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "View Match History", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // H2P = how to play
        // Renders on H2P page
        else if (menu == "H2P") {

            // Set font for H2P page
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/25);

            // Renders H2P text on this page
            drawCenteredString(g, "1: Choose your character", op1, font, Color.black, Color.white);
            drawCenteredString(g, "2: Select who goes first", op2, font, Color.black, Color.white);
            drawCenteredString(g, "3: Ask and answer computer questions", op3, font, Color.black, Color.white);
            drawCenteredString(g, "4: Eliminate characters and guess when ready", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // VMH = View Match History
        // Renders on VMH page
        else if (menu == "VMH") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/20);

            // Match History
            drawCenteredString(g, "", op1, font, Color.black, Color.white);
            drawCenteredString(g, "Check", op2, font, Color.black, Color.white);
            drawCenteredString(g, "log.txt", op3, font, Color.black, Color.white);
            drawCenteredString(g, "", op4, font, Color.black, Color.white);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }

        // PvC = player versus computer
        // Renders on PvC page
        else if (menu == "PvC") {

            // Renders the text "Are You Ready?"
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);
            drawCenteredString(g, "Are You Ready?", new Rectangle(Game.WIDTH/4, 0, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.white);

            // If mouse hovers over this box, "Yes" is displayed differently
            if (MouseInput.mouseCollideRect(mx, my, new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8))) {
                drawCenteredString(g, "> Yes <", new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.yellow);
            }
            // Renders the text "Yes"
            else drawCenteredString(g, "Yes", new Rectangle(Game.WIDTH/4, Game.HEIGHT/2+Game.HEIGHT/3, Game.WIDTH/2, Game.HEIGHT/8), font, Color.black, Color.white);
        }

        // Renders when it is player's turn
        if (StateChecker.turn == "Player") {

            // If on the questions page, render "<" (symbol to go back to character grid)
            if (StateChecker.getCamera() == "PromptQuestions") {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
                drawCenteredString(g, "<", new Rectangle(0, 0, Game.WIDTH/10, Game.HEIGHT), font, new Color(255, 255, 255, 64), new Color(255, 255, 255, 64));
            }

            // If on human grid, render ">" (symbol to go to questions page)
            if (StateChecker.getCamera() == "HumansGrid") {
                font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/8);
                drawCenteredString(g, ">", new Rectangle(Game.WIDTH-Game.WIDTH/10, 0, Game.WIDTH/10, Game.HEIGHT), font, new Color(255, 255, 255, 64), new Color(255, 255, 255, 64));
            }
        }

        // Renders on finished screen
        else if (StateChecker.turn == "Done") {
            font = new Font("Splatfont 2", Font.PLAIN, Game.WIDTH/16);

            // Renders the text "Back"
            if (MouseInput.mouseCollideRect(mx, my, op6)) {drawCenteredString(g, "> Back <", op6, font, Color.black, Color.yellow);}
            else drawCenteredString(g, "Back", op6, font, Color.black, Color.white);
        }
    }

    // Source: https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java 
    // Function to centre text 
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, Color color1, Color color2) {

        // Get the FontMetrics (String width, height, ascent)
        // Ascent: recommended distance above the baseline for singled spaced text
        FontMetrics metrics = g.getFontMetrics(font);

        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;

        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        // Set the font
        g.setFont(font);

        // Set the colour 
        g.setColor(Game.randomColorBy2);

        // Draw the strings for the shadow from text (bottom layer)
        g.drawString(text, x-(rect.width)/32, y+(Game.HEIGHT/50));
        g.drawString(text, x, y+(Game.HEIGHT/50));
        g.drawString(text, x+(rect.width)/32, y+(Game.HEIGHT/50));

        // Set the colour
        g.setColor(color2);

        // Draw the strings for the border for text (surrounds text)
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

        // Draw the strings for the text itself (topmost layer)
        g.drawString(text, x, y);
    }

    // Getter method for menu
    public static String getMenu() {return menu;}

    // Setter method for menu
    public static void setMenu(String menu) {HUD.menu = menu;}
}