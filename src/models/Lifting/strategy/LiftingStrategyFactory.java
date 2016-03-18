package models.Lifting.Strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;

/**
 * Created by laj on 18-3-2016.
 */
public class LiftingStrategyFactory {

    public static ILiftingStrategy CreateInputOrderLifting(ParityGame parityGame) {
        return new InputOrderStrategy(parityGame);
    }

    public static ILiftingStrategy CreateRandomLifting(ParityGame parityGame) {
        return new RandomStrategy(parityGame);
    }
}
