public class Location
{
    private int row, col;
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int r)
    {
        row = r;
    }
    public void setCol(int c)
    {
        col = c;
    }
}
