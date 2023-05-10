// Ella Litsur
import java.awt.*;

public class Card {
    private Image animal;
    private boolean upsideDown;
    public Card(Image animal)
    {
        this.animal = animal;
        upsideDown = true;
    }

    public Image getAnimal()
    {
        return this.animal;
    }
    // Returns true if th Card is upside down
    public boolean isUpsideDown()
    {
        return upsideDown;
    }
    public void setUpsideDown(boolean ud)
    {
        upsideDown = ud;
    }

}
