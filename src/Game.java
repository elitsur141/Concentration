import java.awt.*;
import java.util.*;

public class Game {
    private GameView view;
    private Player player1, player2;
    public static final int NUM_CARDS = 16;
    public Grid grid;
    private ArrayList<Card> cards;
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
        Set<Image> usedImages = new HashSet<Image>();
        cards = new ArrayList<Card>();
        // Gets a random animal image
        Image animal = view.getAnimals()[(int)(Math.random() * view.getAnimals().length)];
        // Adds to the set of used animals
        usedImages.add(animal);
        // Creates 2 Cards with the animal image and adds both Cards to cards
        Card a = new Card(animal);
        Card b = new Card(animal);
        cards.add(a);
        cards.add(b);
        for (int i = 0; i < NUM_CARDS/2 - 1; i++)
        {
            animal = view.getAnimals()[(int) (Math.random() * view.getAnimals().length)];
            while (usedImages.contains(animal))
            {
                animal = view.getAnimals()[(int) (Math.random() * view.getAnimals().length)];
            }
            a = new Card(animal);
            b = new Card(animal);
            cards.add(a);
            cards.add(b);
            usedImages.add(animal);
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
    public void setSelected1(Location s)
    {
        grid.setSelected1(s);
    }
    public void setSelected2(Location s)
    {
        grid.setSelected2(s);
    }
    public boolean match()
    {
        int row1 = grid.getSelected1().getRow();
        int col1 = grid.getSelected1().getCol();
        int row2 = grid.getSelected2().getRow();
        int col2 = grid.getSelected2().getCol();
        if (grid.getGrid()[row1][col1].getAnimal() == grid.getGrid()[row2][col2].getAnimal())
        {
            return true;
        }
        return false;
    }
    public Grid getGrid()
    {
        return grid;
    }
    public void playGame()
    {
        // User selects their cards
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
