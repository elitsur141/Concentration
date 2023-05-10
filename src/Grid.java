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
        current = new Location(0,0);
        selected1 = new Location(-1,-1);
        selected2 = new Location(-1,-1);
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
        if (current.getCol() > 0)
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
    // Draws the grid of cards
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
                // Highlights the current card
                if (current.getRow() == i && current.getCol() == j)
                {
                    g.setColor(Color.yellow);
                    int yellowX = 125 + (current.getCol() * 170);
                    int yellowY = 115 + (current.getRow() * 150);
                    int yellowW = 116;
                    int yellowH = 149;
                    g.fillRect(yellowX, yellowY, yellowW, yellowH);
                }
                if (grid[i][j] != null)
                {
                    // Draws an upside down card
                    if (grid[i][j].isUpsideDown()) {
                        g.drawImage(cardBack, x, y, view);
                    }
                    // Draws a card flipped right-side up
                    else if (!grid[i][j].isUpsideDown()) {
                        g.drawImage(game.getCards().get(cardsIdx).getAnimal(), x, y, view);
                    }
                }
                // If the card has been removed from the grid then an empty space is drawn
                else
                {
                    g.setColor(Color.cyan);
                    g.fillRect(x, y,86,120);
                }
                if (j == grid[0].length - 1)
                {
                    x = 140;
                }
                else
                {
                    x += 170;
                }
                cardsIdx++;
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
    public void setSelected1(Location s)
    {
        selected1 = s;
        if (s.getRow() >= 0)
        {
            grid[selected1.getRow()][selected1.getCol()].setUpsideDown(false);
        }
    }
    public void setSelected2(Location s)
    {
        selected2 = s;
        if (s.getRow() >= 0)
        {
            grid[selected2.getRow()][selected2.getCol()].setUpsideDown(false);
        }
    }
}
