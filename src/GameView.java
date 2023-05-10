import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameView extends JFrame implements KeyListener
{
    private Game game;
    private Image[] animals;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int INTRO_TEXT_X = 20;
    private final int MATCH_TEXT_X = 300;
    private final int MATCH_TEXT_Y = 80;

    public GameView(Game game)
    {
        makeAnimalArr();
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Concentration");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Displays the instructions
        g.setColor(Color.black);
        g.setFont(new Font("SERIF", Font.PLAIN, 15));
        g.drawString("Instructions:", INTRO_TEXT_X, 50);
        g.drawString("The goal of this game is to...", INTRO_TEXT_X, 70);
        game.grid.draw(g);
        g.setColor(Color.black);
        g.drawString("Number of sets found:", 750, 400);
        g.drawString(Integer.toString(game.getPlayer1().numSets()), 750, 420);
        g.setFont(new Font("SERIF", Font.PLAIN, 30));
        if (game.match())
        {
            g.setColor(Color.GREEN);
            g.drawString("It's a match!", MATCH_TEXT_X, MATCH_TEXT_Y);
            g.drawString("Press 'a' to collect your set and continue!", 300, 110);
            if (game.grid.isEmpty())
            {
                g.setColor(Color.CYAN);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.GREEN);
                g.setFont(new Font("SERIF", Font.PLAIN, 40));
                g.drawString("You found all the sets!", 500, 400);
            }
        }
        else
        {
            g.setColor(Color.red);
            if (game.grid.getSelected2().getRow() >= 0)
            {
                g.drawString("Not a match :(  Try again!", MATCH_TEXT_X, MATCH_TEXT_Y);
                // prompt the user to press the 'a' key to continue
                g.drawString("Press 'a' to continue", 300, 110);
            }
        }
    }
    public Image[] getAnimals()
    {
        return animals;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
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
        else if (keyCode == KeyEvent.VK_A)
        {
            if (game.match())
            {
                game.matchAction();
            }
            else
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
