// Ella Litsur
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class GameView extends JFrame implements KeyListener
{
    private Game game;
    private Image[] animals;
    private Image party;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int INTRO_TEXT_X = 10;
    private final int INTRO_TEXT_Y = 50;
    private final int INTRO_TEXT_LINE_DISTANCE = 20;
    private final int MATCH_TEXT_X = 320;
    private final int MATCH_TEXT_Y = 80;
    private final int MATCH_TEXT_Y2 = 120;
    public static final Color DARK_GREEN = new Color(0,140,0);

    public GameView(Game game)
    {
        makeAnimalArr();
        party = new ImageIcon("Resources/party.png").getImage();
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Concentration");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // If the game is over draw the end of game screen
        if (game.grid != null && game.grid.isEmpty())
        {
            g.setColor(DARK_GREEN);
            g.setFont(new Font("SERIF", Font.PLAIN, 45));
            g.drawString("You found all the sets!", 250, 300);
            g.drawImage(party, 250, 350, this);
        }
        else
        {
            // Displays the instructions
            g.setColor(Color.black);
            g.setFont(new Font("SERIF", Font.PLAIN, 15));
            g.drawString("Instructions:", INTRO_TEXT_X, INTRO_TEXT_Y);
            g.drawString("Use the arrow keys to move around", INTRO_TEXT_X, getINTRO_TEXT_Y(1));
            g.drawString("the grid and press space to flip a card", INTRO_TEXT_X, getINTRO_TEXT_Y(2));
            g.drawString("over. Keep finding sets of identical", INTRO_TEXT_X, getINTRO_TEXT_Y(3));
            g.drawString("cards until the cards run out!", INTRO_TEXT_X, getINTRO_TEXT_Y(4));
            // Draws the grid
            game.grid.draw(g);
            // Displays the number of sets the user found
            g.setColor(Color.black);
            g.setFont(new Font("SERIF", Font.PLAIN, 22));
            g.drawString("Number of sets found:", 750, 400);
            g.drawString(Integer.toString(game.getPlayer().numSets()), 850, 430);
            g.setFont(new Font("SERIF", Font.PLAIN, 30));
            // Displays if the selected cards are a match
            if (game.match()) {
                g.setColor(DARK_GREEN);
                g.drawString("It's a match!", MATCH_TEXT_X, MATCH_TEXT_Y);
                g.drawString("Press 'a' to collect your set and continue!", MATCH_TEXT_X, MATCH_TEXT_Y2);
            }
            // Displays if the selected cards are not a match
            else if (game.grid.getSelected2().getRow() >= 0)
            {
                g.setColor(Color.red);
                g.drawString("Not a match :(  Try again!", MATCH_TEXT_X, MATCH_TEXT_Y);
                g.drawString("Press 'a' to continue", MATCH_TEXT_X, MATCH_TEXT_Y2);
            }
        }
    }
    // Returns the y value of the current row in the instructions
    public int getINTRO_TEXT_Y(int row)
    {
        int y = INTRO_TEXT_Y;
        return y + (INTRO_TEXT_LINE_DISTANCE * row);
    }
    public Image[] getAnimals()
    {
        return animals;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Responds to the keyboard input
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT)
        {
            game.moveCurrentLeft();
        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            game.moveCurrentRight();
        }
        else if(keyCode == KeyEvent.VK_UP)
        {
            game.moveCurrentUp();
        }
        else if(keyCode == KeyEvent.VK_DOWN)
        {
            game.moveCurrentDown();
        }
        else if (keyCode == KeyEvent.VK_SPACE)
        {
            Location c = game.grid.getCurrent();
            // If the Card is available to select
            if (game.grid.getGrid()[c.getRow()][c.getCol()] != null)
            {
                // If selected1 does not exist create selected1
                if (game.grid.getSelected1().getRow() == -1)
                {
                    game.setSelected1(c);
                }
                // If only selected1 exists create selected2
                else if (game.grid.getSelected1().getRow() >= 0 && game.grid.getSelected2().getRow() == -1)
                {
                    game.setSelected2(c);
                }
            }
        }
        // If match found the selected cards are removed and increases the numSets
        // If match not found, the selected cards are flipped back over
        else if (keyCode == KeyEvent.VK_A)
        {
            if (game.match())
            {
                game.matchAction();
            }
            else if (game.grid.getSelected1().getRow() != -1 && game.grid.getSelected2().getRow() != -1)
            {
                game.notMatchAction();
            }
        }
        repaint();
    }
    // Put animal images into an array
    public void makeAnimalArr()
    {
        animals = new Image[8];
        animals[0] = new ImageIcon("Resources/bird.png").getImage();
        animals[1] = new ImageIcon("Resources/cow.png").getImage();
        animals[2] = new ImageIcon("Resources/croc.png").getImage();
        animals[3] = new ImageIcon("Resources/deer.png").getImage();
        animals[4] = new ImageIcon("Resources/horse.png").getImage();
        animals[5] = new ImageIcon("Resources/peng.png").getImage();
        animals[6] = new ImageIcon("Resources/pig.png").getImage();
        animals[7] = new ImageIcon("Resources/whale.png").getImage();
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
