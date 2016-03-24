package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by laj on 18-3-2016.
 */
public class RandomStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private Random randomGenerator;
    private ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

    public RandomStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        Clear();
    }

    public String Name() {
        return "Random";
    }

    public void Clear() {
        randomGenerator = new Random();
        randomNumbers.clear();
    }

    public int Next() {
        if (randomNumbers.isEmpty()) {
            randomNumbers.addAll(parityGame.V);
        }

        int randomIndex = randomGenerator.nextInt(randomNumbers.size());
        int theNumber = randomNumbers.get(randomIndex);
        randomNumbers.remove(randomIndex);
        return theNumber;
    }
}
