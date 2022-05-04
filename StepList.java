public class StepList implements Iterable<Move>
{
    public static final Move[] moves =
            {
                    new Move(0, 1, 3),
                    new Move(0, 2, 5),
                    new Move(1, 3, 6),
                    new Move(1, 4, 8),
                    new Move(2, 4, 7),
                    new Move(2, 5, 9),
                    new Move(3, 6, 10),
                    new Move(3, 7, 12),
                    new Move(4, 7, 11),
                    new Move(4, 8, 13),
                    new Move(5, 8, 12),
                    new Move(5, 9, 14),
                    new Move(3, 4, 5),
                    new Move(6, 7, 8),
                    new Move(7, 8, 9),
                    new Move(10, 11, 12),
                    new Move(11, 12, 13),
                    new Move(12, 13, 14)
            };

    @Override
    public StepIterator iterator()
    {
        return new StepIterator(moves);
    }
}