package interfaces;

import java.util.List;

/**
 * Created by laj on 17-3-2016.
 */
public interface IAdjacencyList {
    void addEdge(int i, int j);

    void removeEdge(int i, int j);

    boolean hasEdge(int i, int j);

    List<Integer> outEdges(int i);

    List<Integer> inEdges(int i);
}
