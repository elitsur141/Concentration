import javax.swing.*;
import java.awt.*;
// key tracker in this class
public class GameView extends JFrame
{
    private Game g;
    private Image[] animals;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    public GameView(Game game)
    {
        // assign the animal images and put them in animals array
        this.g = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Concentration");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 0; i < 16; i++)
        {
            // draw each card
            //g.getCards().get(i).draw();
            // move right or down after each card is drawn
        }
    }
    public Image[] getAnimals()
    {
        return animals;
    }

}
