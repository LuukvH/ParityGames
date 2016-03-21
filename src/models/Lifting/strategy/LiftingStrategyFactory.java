package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.Lifting.strategy.InputOrderStrategy;
import models.Lifting.strategy.RandomStrategy;
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
