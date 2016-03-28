package interfaces;

import models.ParityGameSolver;

/**
 * Created by laj on 18-3-2016.
 */
public interface ILiftingStrategy {

    String Name();

    void Initialize(ParityGameSolver solver);

    public void Lifted(Integer v);

    int Next();
}
