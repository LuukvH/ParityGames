package models.Lifting.strategy;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ParityGameSolver;

/**
 * Created by laj on 18-3-2016.
 */
public class LinearLiftingStrategy implements ILiftingStrategy {

    private ParityGame parityGame;
    private ParityGameSolver solver;
    private Integer num_failed = 0;
    private Integer next_vertex = -1;

    public LinearLiftingStrategy(ParityGame parityGame) {
        this.parityGame = parityGame;
    }

    public String Name() {
        return "Linear Lifting";
    }

    public void Initialize(ParityGameSolver solver) {
        this.solver = solver;
    }

    public void Lifted(Integer v) {
        num_failed = 0;
    }

    public int Next() {
        if (num_failed >= parityGame.V.size()) {
            return -1;
        } else {
            num_failed++;
            next_vertex = (next_vertex + 1) % parityGame.V.size();
            return parityGame.V.get(next_vertex);
        }
    }
}
