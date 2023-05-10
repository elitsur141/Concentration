public class Player {
    private int numSets;
    public Player()
    {
        numSets = 0;
    }
    public int numSets()
    {
        return numSets;
    }
    public void addSet()
    {
        numSets += 1;
    }
}
