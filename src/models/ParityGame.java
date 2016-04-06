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

    public int[] V;
    public IAdjacencyList E;
    public int[] p;
    public Boolean[] player; // Even = true, Odd = false (hopefully!!!)
    private String name = "";

    private int maxPriority;

    public ParityGame(int maxvalue) {
        this.maxvalue = maxvalue;

        V = new int[maxvalue];
        E = new DoubleAdjacencyList(maxvalue);
        p = new int[maxvalue];
        player = new Boolean[maxvalue];
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String JSONStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        // collect data
        int nrofedges = 0;
        int minDegree = 0;
        int maxDegree = 0;
        int selfloops = 0;
        float averageDegree = 0f;

        minDegree = E.inEdges(0).size();
        maxDegree = E.inEdges(0).size();
        for (int i = 0; i < maxvalue; i++){

            if (E.inEdges(i).size() > maxDegree)
                maxDegree = E.inEdges(i).size();

            if (E.inEdges(i).size() < minDegree)
                minDegree = E.inEdges(i).size();

            if (E.inEdges(i).contains(i))
                selfloops++;

            nrofedges += E.inEdges(i).size();

            averageDegree = nrofedges / maxvalue;
        }

        // For every node
        stringBuilder.append(String.format(Locale.US, "{\"name\": \"%s\", \"vertices\": %d, \"edges\": %d, \"mindegree\": %d, \"maxdegree\": %d, \"avgdegree\": %f, \"selfloops\": %d}", name, maxvalue, nrofedges, minDegree, maxDegree, averageDegree, selfloops ));
        return  stringBuilder.toString();

    }

    public String JSON() {
        StringBuilder stringBuilder = new StringBuilder();

        // For every node
        stringBuilder.append("[");
        for(int i = 0; i < V.length; i++) {
            // Get all outgoing transitions
            List<Integer> edges = E.outEdges(V[i]);
            for (int e = 0; e<edges.size(); e++) {
                stringBuilder.append(String.format("{\"source\": %d, \"target\": %d, \"sign\": \"%s\", \"priority\": %d},", V[i], edges.get(e), player[i] ? "even" : "odd", p[V[i]] ));
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return  stringBuilder.toString();

    }

}
