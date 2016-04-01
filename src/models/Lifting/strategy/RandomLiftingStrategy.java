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
    private int[] queue;
    private ParityGameSolver solver;
    private Integer num_failed = 0;
    private Integer index = 0;

    public RandomLiftingStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    public String Name() {
        return "Random Lifting";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;

        CalculateRandomSet();
        num_failed = 0;
    }

    private void CalculateRandomSet() {
        List<Integer> vertices = new ArrayList<Integer>(parityGame.V.length);
        Random random = new Random();
        queue = new int[parityGame.V.length];

        for (int index = 0; index < parityGame.V.length; index++)
        {
            vertices.add(parityGame.V[index]);
        }

        int i = 0;
        while (!vertices.isEmpty()) {
            Integer index = random.nextInt(vertices.size());
            Integer v = vertices.get(index);
            queue[i] = v;
            vertices.remove(v);
            i++;
        };
    }

    public void Lifted(Integer v) {
        num_failed = 0;
    }

    public int Next() {
        if (num_failed >= parityGame.V.length) {
            return -1;
        }

        index++;
        num_failed++;

        if (index >= queue.length) {
            index = 0;
        }

        return queue[index];
    }
}
