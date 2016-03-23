package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by laj on 18-3-2016.
 */
public class EvenSelfLoopsFirstStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private Set<Integer> order;
    private int index = 0;
    private Iterator<Integer> iterator;
    public EvenSelfLoopsFirstStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        order = new OrderedHashSet<Integer>();

        // Find even vertices with self loops
        for (Integer v : this.parityGame.V) {
                if (parityGame.E.hasEdge(v, v)) {

                    // Add all self loops
                    order.add(v);
                }
        }

        // Add edges to selfloops
        List<Integer> corder = new ArrayList<>(order.size());
        corder.addAll(order);

        for (Integer o : corder) {
            List<Integer> inedges = parityGame.E.inEdges(o);
            for (Integer e : inedges) {
                if((parityGame.p[e] & 1) == 0) {
                    order.add(e);
                }
            }
        }

        order.addAll(parityGame.V);

        iterator = order.iterator();
    }

    public String Name() {
        return "EvenSelfLoops";
    }

    public int Next() {
        if (!iterator.hasNext()) {
            iterator = order.iterator();
        }
        return iterator.next();
    }
}
