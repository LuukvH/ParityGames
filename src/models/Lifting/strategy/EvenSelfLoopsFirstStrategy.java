package models.Lifting.strategy;

import enums.Player;
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
    }

    public String Name() {
        return "EvenSelfLoops";
    }

    public void Clear() {
        order = new OrderedHashSet<Integer>();

        // Find even vertices with self loops
        for (Integer v : this.parityGame.V) {
                if (parityGame.E.hasEdge(v, v)) {
                    // Add all self loops
                    order.add(v);
                }
        }

        System.out.printf("Number of self loops: %d \n", order.size());

        /*
        // Add all incomming vertices to self loop with even player
        ArrayList<Integer> bOrder = new ArrayList<Integer>();
        bOrder.addAll(order);
        for (Integer v : bOrder) {
            List<Integer> edges = parityGame.E.inEdges(v);
            for (Integer e : edges) {
                if (parityGame.player[e] == Player.Even) {
                    order.add(e);
                    System.out.println(e);
                }
            }
        }
*/
        order.addAll(parityGame.V);
        iterator = order.iterator();
    }

    public int Next() {
        if (!iterator.hasNext()) {
            iterator = order.iterator();
        }
        return iterator.next();
    }
}
