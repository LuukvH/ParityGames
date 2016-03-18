import interfaces.ILiftingStrategy;
import models.ParityGame;

/**
 * Created by laj on 18-3-2016.
 */
public class ParityGameSolver {
    private ParityGame parityGame;
    private ILiftingStrategy liftingStrategy;

    public ParityGameSolver(ParityGame parityGame, ILiftingStrategy liftingStrategy)
    {
        this.parityGame = parityGame;
        this.liftingStrategy = liftingStrategy;
    }

    public void Solve() {

        // While not stable {
        //    Lift(liftingStrategy.next())
        // }
    }

}
