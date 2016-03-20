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
    private  Random randomGenerator;
    private int currentPos;
    private ArrayList<Integer> randomNumbers;

    public RandomStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        randomNumbers = new ArrayList<Integer>();
        randomGenerator = new Random();
        currentPos = 0;
    }

    // Todo: return next vertice to lift
    public int Next() {
        if (randomNumbers.size() == 0)
        {
            for (int i =0;i< parityGame.V.size();i++)
            {
                randomNumbers.add(i);
            }
        }

        int randomIndex = randomGenerator.nextInt(randomNumbers.size());
        int theNumber = randomNumbers.get(randomIndex);
        randomNumbers.remove(randomIndex);
        return theNumber;

    }
}
