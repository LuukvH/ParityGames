package models.Lifting.Strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by laj on 18-3-2016.
 */
public class InputOrderStrategy implements ILiftingStrategy {

    private ParityGame parityGame;

    public InputOrderStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    // Todo: return next vertice to lift
    public int Next() {
        throw new NotImplementedException();
    }
}
