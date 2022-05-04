import java.util.*;

public class Main
{
    static void go()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("=== " + i + " ===");
            Board b = new Board(i);
            replay(initzlize(b), b);
            System.out.println();
        }
    }
    static LinkedList<Move> initzlize(Board b)
    {
        ArrayList<LinkedList<Move>> out = new ArrayList<LinkedList<Move>>();
        compute(b, out, 1);
        if (out.size() == 0)
            return null;
        return out.get(0);
    }

    static StepList steps()
    {
        return new StepList();
    }

    static ArrayList<LinkedList<Move>> compute(Board b)
    {
        ArrayList<LinkedList<Move>> out = new ArrayList<LinkedList<Move>>();
        compute(b, out, 0);
        return out;
    }



    static void compute(Board b, ArrayList<LinkedList<Move>> solutions, int count)
    {
        if (b.pegCount == 1)
        {
            solutions.add(new LinkedList<Move>());
            return;
        }
        for (Move m : steps())
        {
            Board boardAfter = b.move(m);
            if (boardAfter == null) continue;
            ArrayList<LinkedList<Move>> tailSolutions = new ArrayList<LinkedList<Move>>();
            compute(boardAfter, tailSolutions, count);
            for (LinkedList<Move> solution : tailSolutions)
            {
                solution.add(0, m);
                solutions.add(solution);

                if (solutions.size() == count)
                    return;
            }
        }
    }

    static void printBoard(Board b)
    {
        System.out.print("(" + b.pegCount + ", [");
        for (int i = 0; i < b.cells.length; i++)
            System.out.print(i < b.cells.length-1 ? b.cells[i] + ", " : b.cells[i] + "])");
        System.out.println();
    }

    static void show(Board b)
    {
        int[][] lines = { {4,0,0}, {3,1,2}, {2,3,5}, {1,6,9}, {0,10,14} };
        for (int[] l : lines)
        {
            int spaces = l[0];
            int begin  = l[1];
            int end    = l[2];

            String space = new String();
            for (int i = 0; i < spaces; i++)
                space += " ";

            System.out.print(space);
            for (int i = begin; i <= end; i++)
                System.out.print(b.cells[i] == 0 ? ". " : "x ");

            System.out.println();
        }

        System.out.println();
    }

    static void replay(List<Move> moves, Board b)
    {
        show(b);
        for (Move m : moves)
        {
            b = b.move(m);
            show(b);
        }
    }


    public static void main(String[] args)
    {
        go();
    }
}

