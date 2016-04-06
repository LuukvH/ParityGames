package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;

import java.util.*;

/**
 * Created by laj on 18-3-2016.
 */
public class PredecessorLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private boolean[] queued;
    private LinkedList<Integer> queue;
    private ParityGameSolver solver;

    public PredecessorLiftingStrategy(ParityGame parityGame) {

        this.parityGame = parityGame;
    }

    public String Name() {
        return "Predecessor Lifting";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        queued = new boolean[parityGame.V.length];
        queue = new LinkedList<Integer>();

        List<Integer> list = new ArrayList<Integer>(parityGame.V.length);
        for (Integer v : parityGame.V) {
            list.add(v);
        }

        // Sort edges on degree
        list.sort(new DegreeComparator());

        for (Integer v : list) {
            queued[v] = true;
            queue.add(v);
        }
    }

    public void Lifted(Integer v) {
        List<Integer> edges = parityGame.E.inEdges(v);

        // Sort edges on degree
        edges.sort(new DegreeComparator());

        for (Integer w : edges) {
            if (!queued[w] && !solver.progressMeasures[w].Top()) {
                // Put self loops in front of queue
                if (w == v) {
                    queue.addFirst(w);
                } else {
                    queue.add(w);
                }
                queued[w] = true;
            }
        }
    }

    public int Next() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            Integer v = queue.remove();
            queued[v] = false;
            return v;
        }
    }

    class DegreeComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (parityGame.E.inEdges(o1).size() == parityGame.E.inEdges(o2).size()) {
                return 0;
            } else if (parityGame.E.inEdges(o1).size() > parityGame.E.inEdges(o2).size()) {
                return -1;
            }
            return 1;
        }
    }
}
