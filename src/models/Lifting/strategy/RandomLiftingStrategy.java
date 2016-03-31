package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by laj on 18-3-2016.
 */
public class RandomLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private Queue<Integer> queue;
    private ParityGameSolver solver;
    private Integer num_failed = 0;

    public RandomLiftingStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    public String Name() {
        return "Random Lifting";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        queue = getRandomSet();
        num_failed = 0;
    }

    private Queue<Integer> getRandomSet() {
        List<Integer> vertices = new ArrayList<Integer>(parityGame.V);
        Random random = new Random();
        Queue<Integer> queue = new LinkedList<Integer>();

        while (!vertices.isEmpty()) {
            Integer index = random.nextInt(vertices.size());
            Integer v = vertices.get(index);
            if (!solver.progressMeasures[v].Top())
                queue.add(v);
            vertices.remove(v);
        };
        return queue;
    }

    public void Lifted(Integer v) {
        num_failed = 0;
    }

    public int Next() {
        if (queue.isEmpty()) {
            queue = getRandomSet();

            if (queue.isEmpty())
                return -1;
        }

        if (num_failed >= parityGame.V.size()) {
            return -1;
        }

        num_failed++;

        return queue.remove();
    }
}
