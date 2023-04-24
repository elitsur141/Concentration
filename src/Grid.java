import java.util.ArrayList;

public class Grid {
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Grid()
    {
        cardsLeft = 16;
        cards = new ArrayList<Card>();
        for (int i = 0; i < 16; i++)
        {
            //add the Card to the cards
            cards.add(new Card(animals[i]);
        }
    }
}
