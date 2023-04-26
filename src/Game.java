import java.util.ArrayList;

public class Game {
    private GameView view;
    private Player player1, player2;
    private Grid grid;
    private ArrayList<Card> cards;

    public void instructions()
    {

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
        // Do i put this in playGame()?
        instructions();
        playerSetup();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
