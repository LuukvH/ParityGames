package models.Lifting.strategy;

import enums.Player;
import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;

import java.util.*;

/**
 * Created by laj on 18-3-2016.
 */
public class CustomLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private boolean[] queued;
    private Queue<Integer> evenqueue;
    private Queue<Integer> oddqueue;
    private ParityGameSolver solver;

    public CustomLiftingStrategy(ParityGame parityGame) {

        this.parityGame = parityGame;
    }

    public String Name() {
        return "Custom Lifting";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        queued = new boolean[parityGame.V.length];
        evenqueue = new ArrayDeque<Integer>();
        oddqueue = new ArrayDeque<Integer>();

        List<Integer> list = new ArrayList<Integer>(parityGame.V.length);
        for (Integer v : parityGame.V) {
            list.add(v);
        }

        // Sort edges on degree
        //list.sort(new PriorityComparator());

        for (Integer v : list) {
            queued[v] = true;
            if (parityGame.player[v] == Player.Even) {
                evenqueue.add(v);
            } else {
                oddqueue.add(v);
            }
        }
    }

    public void Lifted(Integer v) {
        List<Integer> edges = parityGame.E.inEdges(v);

        // Sort edges on degree
        edges.sort(new PriorityComparator());

        for (Integer w : edges) {
            if (!queued[w] && !solver.progressMeasures[w].Top()) {
                if (parityGame.player[v] == Player.Even) {
                    evenqueue.add(v);
                } else {
                    oddqueue.add(v);
                }
                queued[w] = true;
            }
        }
    }

    public int Next() {
        if (evenqueue.isEmpty() && oddqueue.isEmpty()) {
            return -1;
        } else {
            Integer v = -1;
            if (!evenqueue.isEmpty()) {
                v = evenqueue.remove();
            }else {
                v = oddqueue.remove();
            }
            queued[v] = false;
            return v;
        }
    }

    class PriorityComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (parityGame.p[o1] == parityGame.p[o2]) {
                return 0;
            } else if (parityGame.p[o1] > parityGame.p[o2]) {
                return -1;
            }
            return 1;
        }
    }
}
