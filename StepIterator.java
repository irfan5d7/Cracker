import java.util.Iterator;

public class StepIterator implements Iterator<Move>
{
    private Move[] moves;
    private Move   reversed;
    private int    i;

    public StepIterator(Move[] moves)
    {
        this.moves = moves;
        this.i     = 0;
    }

    @Override
    public boolean hasNext()
    {
        boolean out =  i < moves.length || (i == moves.length && reversed != null);
        return out;
    }

    @Override
    public Move next()
    {
        if (reversed != null)
        {
            Move result = reversed;
            reversed = null;
            return result;
        }
        Move m = moves[i++];
        reversed = m.flip();
        return m;
    }
}
