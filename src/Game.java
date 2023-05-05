import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    private GameView view;
    private Player player1, player2;
    public static final int NUM_CARDS = 16;
    public Grid grid;
    private ArrayList<Card> cards;
    private Object g;

    public Game()
    {
        view = new GameView(this);
        cardsSetup();
        grid = new Grid(cards, this, view);
        playerSetup();
        view.repaint();
    }
    public void playerSetup()
    {
        player1 = new Player("You");
        player2 = new Player("Computer");
    }
    // Creates the ArrayList of shuffled cards
    public void cardsSetup()
    {
        cards = new ArrayList<Card>();
        for (int i = 0; i < NUM_CARDS/2; i++)
        {
            Image animal = view.getAnimals()[(int) Math.random() * view.getAnimals().length];
            Card a = new Card(animal);
            Card b = new Card(animal);
            cards.add(a);
            cards.add(b);
        }
        shuffle();
    }
    // Shuffles the cards (I used my shuffle method from my Card Game)
    public void shuffle()
    {
        for (int i = NUM_CARDS - 1; i >= 0; i--)
        {
            int newIdx = (int)(Math.random() * (NUM_CARDS));
            Collections.swap(cards, i, newIdx);
        }
    }
    // Moves the current card left
    public void moveCurrentLeft()
    {
        grid.moveCurrentLeft();
    }
    // Moves the current card right
    public void moveCurrentRight()
    {
        grid.moveCurrentRight();
    }
    // Moves the current card up
    public void moveCurrentUp()
    {
        grid.moveCurrentUp();
    }
    // Moves the current card down
    public void moveCurrentDown()
    {
        grid.moveCurrentDown();
    }
    public Grid getGrid()
    {
        return grid;
    }
    public void playGame()
    {
        view.repaint();
    }
    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
