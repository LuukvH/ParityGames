package models;

import models.ProgressMeasure.ProgressMeasure;
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

// Please don't break it Roxanne
public class ParityGame {
    private int maxvalue;

    public List<Integer> V;
    public IAdjacencyList E;
    public int[] p;
    public Boolean[] player; // Even = true, Odd = false (hopefully!!!)

    private int maxPriority;

    public ParityGame(int maxvalue) {
        this.maxvalue = maxvalue;

        V = new ArrayList<Integer>(maxvalue);
        E = new DoubleAdjacencyList(maxvalue);
        p = new int[maxvalue];
        player = new Boolean[maxvalue];
    }

    public void setMaxPriority(int value) {
        maxPriority = value;
    }

    public int getMaxPriority() {
        return maxPriority;
    }

    public int[] GetPriorityList() {
        return p;
    }

    public String JSON() {
        StringBuilder stringBuilder = new StringBuilder();

        // For every node
        stringBuilder.append("[");
        for(int i = 0; i < V.size(); i++) {
            // Get all outgoing transitions
            List<Integer> edges = E.outEdges(V.get(i));
            for (int e = 0; e<edges.size(); e++) {
                stringBuilder.append(String.format("{\"source\": %d, \"target\": %d, \"sign\": \"%s\", \"priority\": %d},", V.get(i), edges.get(e), player[V.get(i)] ? "even" : "odd", p[V.get(i)] ));
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return  stringBuilder.toString();

    }

}
