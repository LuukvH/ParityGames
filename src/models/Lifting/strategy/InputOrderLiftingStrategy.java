package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by laj on 18-3-2016.
 */
public class InputOrderLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private ParityGameSolver solver;
    private Integer num_failed = 0;
    private Integer next_vertex = -1;

    public InputOrderLiftingStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    public String Name() {
        return "InputOrder Lifting";
    }

    public void Initialize(ParityGameSolver solver) {

        this.solver = solver;
        num_failed = 0;
        next_vertex = -1;
    }

    public void Lifted(Integer v) {
        next_vertex--;
        num_failed = 0;
    }

    public int Next() {
        if (num_failed >= parityGame.V.size()) {
            return -1;
        } else {
            num_failed++;
            next_vertex = (next_vertex + 1) % parityGame.V.size();
            return next_vertex;
        }
    }
}
