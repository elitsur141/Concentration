import java.awt.*;
import java.util.ArrayList;

public class Game {
    private GameView view;
    private Player player1, player2;
    private Grid grid;
    private ArrayList<Card> cards;
    private final int INTRO_TEXT_X = 20;


    public final void instructions(Graphics g)
    {
        // Displays the instructions
        g.setColor(Color.black);
        g.setFont(new Font("SERIF", Font.PLAIN, 15));
        g.drawString("Instructions:", INTRO_TEXT_X, 50);
        g.drawString("The goal of this game is to roll even sums using 2 6-sided dice.", INTRO_TEXT_X, 70);
    }
    public void playerSetup()
    {

    }
    public void playGame()
    {
        Grid grid = new Grid(cards);
    }
    public ArrayList<Card> getCards()
    {
        return cards;
    }
    // creates players and deck
    public Game()
    {
        view = new GameView(this);
        playerSetup();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
