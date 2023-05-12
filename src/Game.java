// Ella Litsur
import java.awt.*;
import java.util.*;

public class Game {
    private GameView view;
    private Player player;
    public static final int NUM_CARDS = 16;
    public Grid grid;
    private ArrayList<Card> cards;
    public Game()
    {
        // Initializes the window, makes the cards, grid, and player
        view = new GameView(this);
        cardsSetup();
        grid = new Grid(cards,this, view);
        player = new Player();
        view.repaint();
    }

    // Creates the ArrayList of shuffled cards
    public void cardsSetup()
    {
        Set<Image> usedImages = new HashSet<Image>();
        cards = new ArrayList<Card>();
        for (int i = 0; i < NUM_CARDS/2; i++)
        {
            // Selects a random animal image from the array of animal images
            Image animal = view.getAnimals()[(int) (Math.random() * view.getAnimals().length)];
            // Makes sure the animal image has not been used yet
            while (usedImages.contains(animal))
            {
                animal = view.getAnimals()[(int) (Math.random() * view.getAnimals().length)];
            }
            // Creates 2 new Cards with the random animal image
            Card a = new Card(animal);
            Card b = new Card(animal);
            // Adds both Cards to the ArrayList cards
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
    public Player getPlayer()
    {
        return player;
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
    // Returns true if the selected cards are a match and returns false otherwise
    public boolean match()
    {
        int row1 = grid.getSelected1().getRow();
        int col1 = grid.getSelected1().getCol();
        int row2 = grid.getSelected2().getRow();
        int col2 = grid.getSelected2().getCol();
        // Return false if 2 Cards are not selected
        if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0)
        {
            return false;
        }
        // Returns true if the images on both cards are the same
        if (grid.getGrid()[row1][col1].getAnimal() == grid.getGrid()[row2][col2].getAnimal())
        {
            return true;
        }
        return false;
    }
    // User found a match -> removes selected cards from the grid, resets selected cards, increases user's numSets
    public void matchAction()
    {
        int row1 = grid.getSelected1().getRow();
        int col1 = grid.getSelected1().getCol();
        int row2 = grid.getSelected2().getRow();
        int col2 = grid.getSelected2().getCol();
        player.addSet();
        grid.removeCard(row1, col1);
        grid.removeCard(row2, col2);
        if (!grid.isEmpty())
        {
            grid.setSelected1(new Location(-1, -1));
            grid.setSelected2(new Location(-1, -1));
        }
    }
    // User didn't find a match -> flips over both of the selected cards and resets the selected cards
    public void notMatchAction()
    {
        int row1 = grid.getSelected1().getRow();
        int col1 = grid.getSelected1().getCol();
        int row2 = grid.getSelected2().getRow();
        int col2 = grid.getSelected2().getCol();
        grid.getGrid()[row1][col1].setUpsideDown(true);
        grid.getGrid()[row2][col2].setUpsideDown(true);
        grid.setSelected1(new Location(-1,-1));
        grid.setSelected2(new Location(-1,-1));
    }
    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public static void main(String[] args) {
        Game game = new Game();
    }


}
