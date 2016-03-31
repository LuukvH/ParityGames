package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;

import java.util.*;

/**
 * Created by laj on 18-3-2016.
 */
public class SelfLoopsLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private boolean[] queued;
    private Queue<Integer> queue;
    private ParityGameSolver solver;
    private Integer num_failed = 0;
    public boolean lifted = true;

    public SelfLoopsLiftingStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    public String Name() {
        return "Self Loops Lifting Strategy";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        queued = new boolean[parityGame.V.size()];
        queue = new LinkedList<Integer>();
        num_failed = 0;
        lifted = true;

        // Add all edges with self loops
        for (Integer v : parityGame.V) {
            if (parityGame.E.inEdges(v).contains(v)) {
                queued[v] = true;
                queue.add(v);
            }
        }

        // Add all others
        for (Integer v : parityGame.V) {
            if (!queued[v]) {
                queued[v] = true;
                queue.add(v);
            }
        }
    }

    public void Lifted(Integer v) {
        num_failed = 0;
        lifted = true;
    }

    public int Next() {
        if (num_failed >= queue.size())
            return -1;

        num_failed++;

        if (!lifted) {
            Integer v = queue.remove();
            if (!solver.progressMeasures[v].Top()) {
                queue.add(v);
            }
        }

        lifted = false;
        return queue.peek();
    }
}
