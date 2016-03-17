package models;

import com.sun.org.apache.xpath.internal.operations.Bool;
import interfaces.IAdjacencyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by laj on 17-3-2016.
 * A parity game is a four tuple (V, E, p, (Veven, Vodd)) where
 * I (V, E) is a directed graph
 * I V a set of vertices partitioned into V3 and V
 *    Veven: vertices owned by player even
 *    Vodd: vertices owned by player odd
 * E a total edge relation
 * p : V → N a priority function
 */
public class ParityGame
{
    private int maxvalue;

    private List<Integer> V;
    private IAdjacencyList E;
    private List<Bool> p;
    private List<Integer> Veven;
    private List<Integer> Vodd;

    public ParityGame(int maxvalue){
        this.maxvalue = maxvalue;

        V = new ArrayList<Integer>(maxvalue);
        E = new DoubleAdjacencyList(maxvalue);
        p = new ArrayList<Bool>(maxvalue);
        Veven = new ArrayList<Integer>(maxvalue);
        Vodd = new ArrayList<Integer>(maxvalue);
    }

}
