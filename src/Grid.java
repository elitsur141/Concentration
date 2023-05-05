import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid {
    private GameView view;
    private Game game;
    private Image cardBack;
    private Card[][] grid;
    private Location current, selected1, selected2;
    private int cardsLeft;

    // Expects ArrayList of shuffled cards, then assigns each card to a spot in the gird
    public Grid(ArrayList<Card> cards, Game g, GameView v)
    {
        game = g;
        view = v;
        grid = new Card[4][4];
        cardsLeft = Game.NUM_CARDS;
        cardBack = new ImageIcon("Resources/cardBack.png").getImage();
        int idx = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                grid[i][j] = cards.get(idx);
                idx++;
            }
        }
    }
    public void moveCurrentLeft()
    {
        if (current.getCol() >= 0)
        {
            Location c = new Location(current.getRow(), current.getCol() - 1);
            setCurrent(c);
        }
    }
    public void moveCurrentRight()
    {
        if (current.getCol() < 3)
        {
            Location c = new Location(current.getRow(), current.getCol() + 1);
            setCurrent(c);
        }
    }
    public void moveCurrentUp()
    {
        if (current.getRow() > 0)
        {
            Location c = new Location(current.getRow() - 1, current.getCol());
            setCurrent(c);
        }
    }

    public void moveCurrentDown()
    {
        if (current.getRow() < 3)
        {
            Location c = new Location(current.getRow() + 1, current.getCol());
            setCurrent(c);
        }
    }
    public void draw(Graphics g)
    {
        int x = 140;
        int y = 130;
        int cardsIdx = 0;
        // Draws the cards
        for (int i = 0; i < this.grid.length; i++)
        {
            for (int j = 0; j < this.grid[0].length; j++)
            {
                if (grid[i][j].isUpsideDown())
                {
                    // FIND A WAY TO GET CARD LOCATION
                    g.drawImage(cardBack, x, y, view);
                }
                else if (grid[i][j].isUpsideDown() == false)
                {
                    g.drawImage(game.getCards().get(cardsIdx).getAnimal(), x, y, view);
                }
                cardsIdx++;
                if (j == grid[0].length - 1)
                {
                    x = 140;
                }
                else
                {
                    x += 170;
                }
            }
            y += 150;
        }
    }
    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }

    public void removeCard(int row, int col)
    {
        grid[row][col] = null;
        cardsLeft--;
    }
    public Card[][] getGrid()
    {
        return grid;
    }
    public Location getCurrent()
    {
        return current;
    }
    public void setCurrent(Location c)
    {
        current = c;
    }
    public Location getSelected1()
    {
        return selected1;
    }
    public Location getSelected2()
    {
        return selected2;
    }
    public int getCardsLeft()
    {
        return cardsLeft;
    }
}
