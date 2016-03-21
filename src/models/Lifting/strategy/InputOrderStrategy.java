package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by laj on 18-3-2016.
 */
public class InputOrderStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private int currentPos = 0;
    public InputOrderStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
        this.currentPos = 0; //start from 0
    }

    public int Next() {
        int v = parityGame.V.get(currentPos);
        currentPos++;
        currentPos = currentPos % parityGame.V.size() == 0 ? 0 : currentPos;
        return v;
    }
}
