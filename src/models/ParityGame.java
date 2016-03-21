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

    public Set<Integer> V;
    public IAdjacencyList E;
    public int[] p;
    public Boolean[] player; // Even = true, Odd = false (hopefully!!!)
    public ProgressMeasure[] progressMeasures;

    private int maxPriority;

    public ParityGame(int maxvalue) {
        this.maxvalue = maxvalue;

        V = new LinkedHashSet<Integer>(maxvalue);
        E = new DoubleAdjacencyList(maxvalue);
        p = new int[maxvalue];
        player = new Boolean[maxvalue];

        progressMeasures = new ProgressMeasure[maxvalue];
    }

    public void setMaxPriority(int value) {
        maxPriority = value;

        // Initialize progressmeasures
        for  (int i =0; i< maxvalue; i++) {
            progressMeasures[i] = new ProgressMeasure(maxPriority);
        }
    }

    public int getMaxPriority() {
        return maxPriority;
    }

    public int[] GetPriorityList() {
        return p;
    }

}
