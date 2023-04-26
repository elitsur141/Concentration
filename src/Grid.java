import java.util.ArrayList;

public class Grid {
    private Card[][] grid;
    private Card current, selected1, selected2;
    private int cardsLeft;

    public Grid(ArrayList<Card> cards)
    {
        cardsLeft = 16;
        cards = new ArrayList<Card>();
        for (int i = 0; i < 16; i++)
        {
            //add the Card to the cards
            //cards.add(new Card(animals[i]);
        }
    }
    public void isEmpty()
    {
        return;
    }

    public void removeCard(int row, int col)
    {

    }
    public Card getCurrent()
    {
        return current;
    }
    public Card getSelected1()
    {
        return selected1;
    }
    public Card getSelected2()
    {
        return selected2;
    }
    public int getCardsLeft()
    {
        return cardsLeft;
    }
}
