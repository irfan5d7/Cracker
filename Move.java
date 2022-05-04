import java.util.*;

public class Move
{
    public int source, through, dest;

    public Move(int source, int through, int dest)
    {
        this.source = source;
        this.through = through;
        this.dest = dest;
    }

    @Override
    public String toString()
    {
        return "(" + source + ", " + through + ", " + dest + ")";
    }

    public Move flip()
    {
        return new Move(dest, through, source);
    }
}
