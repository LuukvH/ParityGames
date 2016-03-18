package structures;

import interfaces.IAdjacencyList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by laj on 17-3-2016.
 */
public class AdjacencyList implements IAdjacencyList {

    private int size;
    private List<Integer>[] adj;

    public AdjacencyList(int size) {
        this.size = size;
        adj = (List<Integer>[]) new List[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    @Override
    public void addEdge(int i, int j) {
        adj[i].add(j);
    }

    @Override
    public void removeEdge(int i, int j) {
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            if (it.next() == j) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public boolean hasEdge(int i, int j) {
        return adj[i].contains(j);
    }

    @Override
    public List<Integer> outEdges(int i) {
        return adj[i];
    }

    @Override
    public List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++)
            if (adj[j].contains(i)) edges.add(j);
        return edges;
    }
}