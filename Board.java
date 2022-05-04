
public class Board
{
    public int pegCount;
    public int[] cells;

    public Board(int emptyCell)
    {
        cells = new int[15];
        pegCount = 14;
        for (int i = 0; i < 15; i++)
            cells[i] = i == emptyCell ? 0 : 1;
    }

    public Board(int pegCount, int[] cells)
    {
        this.pegCount = pegCount;
        this.cells    = cells.clone();
    }

    public Board move(Move m)
    {
        if (cells[m.source] == 1 &&
                cells[m.through] == 1 &&
                cells[m.dest]   == 0)
        {
            Board boardAfter = new Board(pegCount-1, cells.clone());
            boardAfter.cells[m.source] = 0;
            boardAfter.cells[m.through] = 0;
            boardAfter.cells[m.dest]   = 1;

            return boardAfter;
        }
        return null;
    }
}
