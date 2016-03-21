package models;

import structures.DoubleAdjacencyList;
import interfaces.IAdjacencyList;

import java.util.*;

/**
 * Created by laj on 17-3-2016.
 * A parity game is a four tuple (V, E, p, (Veven, Vodd)) where
 * I (V, E) is a directed graph
 * I V a set of vertices partitioned into V3 and V
 * Veven: vertices owned by player even
 * Vodd: vertices owned by player odd
 * E a total edge relation
 * p : V → N a priority function
 */
public class ParityGame {
    private int maxvalue;

    public int[] V;
    public IAdjacencyList E;
    public int[] p;
    public Boolean[] player; // Even = true, Odd = false (hopefully!!!)

    private int maxPriority;

    public ParityGame(int maxvalue) {
        this.maxvalue = maxvalue;

        V = new int[maxvalue];
        E = new DoubleAdjacencyList(maxvalue);
        p = new int[maxvalue];
        player = new Boolean[maxvalue];
    }

    public void setMaxPriority(int value) { maxPriority = value; }
    public int getMaxPriority() {
        return maxPriority;
    }

    public int[] GetPriorityList() {
        return p;
    }

    public void JSON() {
        StringBuilder stringBuilder = new StringBuilder();

        // For every node
        for(int i = 0; i < V.length; i++) {
            // Get all outgoing transitions
            List<Integer> edges = E.outEdges(V[i]);
            for (int e = 0; e<edges.size(); e++) {
                stringBuilder.append(String.format("link: {source: %d, target: %d, sign: \"%s\", priority: %d} \n", V[i], edges.get(e), player[V[i]] ? "even" : "odd", p[V[i]] ));
            }
        }

        System.out.println(stringBuilder.toString());

    }
}
