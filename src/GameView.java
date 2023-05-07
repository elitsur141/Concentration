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

    public GameView(Game game)
    {
        makeAnimalArr();
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Concentration");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
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
            Location c = game.getGrid().getCurrent();
            if (game.grid.getSelected1() == null)
            {
                game.setSelected1(c);
            }
            else
            {
                game.setSelected2(c);
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
