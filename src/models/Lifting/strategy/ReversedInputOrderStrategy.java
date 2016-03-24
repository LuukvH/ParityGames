package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by laj on 18-3-2016.
 */
public class ReversedInputOrderStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private int currentPos;
    public ReversedInputOrderStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        Clear();
    }

    @Override
    public String Name() {
        return "Reversed input order";
    }

    public void Clear() {
        this.currentPos = parityGame.V.size() - 1;
    }

    public int Next() {
        if (currentPos > 0)
        {
            return --currentPos;
        }
        else
            currentPos = parityGame.V.size() - 1;
        return currentPos;
    }
}