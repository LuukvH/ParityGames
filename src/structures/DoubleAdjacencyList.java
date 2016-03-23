package structures;

import interfaces.IAdjacencyList;

import java.util.List;

/**
 * Created by laj on 17-3-2016.
 */
public class DoubleAdjacencyList implements IAdjacencyList {

    AdjacencyList in;
    AdjacencyList out;

    public DoubleAdjacencyList(int size) {
        in = new AdjacencyList(size);
        out = new AdjacencyList(size);
    }

    @Override
    public void addEdge(int i, int j) {
        in.addEdge(i, j);
        out.addEdge(j, i);
    }

    @Override
    public void removeEdge(int i, int j) {
        in.removeEdge(i, j);
        out.removeEdge(j, i);
    }

    @Override
    public boolean hasEdge(int i, int j) {
        return in.hasEdge(i, j);
    }

    @Override
    public List<Integer> outEdges(int i) {
        return in.outEdges(i);
    }

    @Override
    public List<Integer> inEdges(int i) {
        return out.outEdges(i);
    }
}
