package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

/**
 * Created by laj on 18-3-2016.
 */
public class InputOrderStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private Iterator<Integer> iterator;
    public InputOrderStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        Clear();
    }

    public String Name() {
        return "InputOrder";
    }

    public void Clear() {
        iterator = parityGame.V.iterator();
    }

    public int Next() {
        if (!iterator.hasNext()) {
            iterator = parityGame.V.iterator();
        }
        return iterator.next();
    }
}
