public class Player {
    private String name;
    private int numSets;
    public Player(String theName)
    {
        name = theName;
        numSets = 0;
    }
    public String getName()
    {
        return name;
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
