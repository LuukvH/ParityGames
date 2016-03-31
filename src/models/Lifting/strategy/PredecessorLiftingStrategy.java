package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by laj on 18-3-2016.
 */
public class PredecessorLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private boolean[] queued;
    private Queue<Integer> queue;
    private ParityGameSolver solver;

    public PredecessorLiftingStrategy(ParityGame parityGame) {

        this.parityGame = parityGame;
    }

    public String Name() {
        return "Predecessor Lifting Strategy";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        queued = new boolean[parityGame.V.size()];
        queue = new LinkedList<Integer>();

        for (Integer v : parityGame.V) {
            if (!solver.progressMeasures[v].Top()) {
                queued[v] = true;
                queue.add(v);
            }
        }
    }

    public void Lifted(Integer v) {
        List<Integer> edges = parityGame.E.outEdges(v);
        for (Integer w : edges) {
            if (!queued[w] && !solver.progressMeasures[w].Top()) {
                queued[w] = true;
                queue.add(w);
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
}
