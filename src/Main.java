import interfaces.ILiftingStrategy;
import models.Lifting.strategy.InputOrderStrategy;
import models.Man;
import models.ParityGameFactory;
import models.ParityGame;
import models.Woman;

import java.io.IOException;

import spark.Spark;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ParityGame parityGame = ParityGameFactory.CreateExample();
        ILiftingStrategy strategy = new InputOrderStrategy(parityGame);
        ParityGameSolver solver = new ParityGameSolver(parityGame, strategy);

        Man m = new Man();
        Woman w = new Woman();
        m.Compare(m, m);

        solver.Solve();
    }
}
