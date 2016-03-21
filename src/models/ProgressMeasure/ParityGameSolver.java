package models.ProgressMeasure;

import interfaces.ILiftingStrategy;
import models.ParityGame;

import java.util.ArrayList;
import java.util.List;

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

    public static BaseProgressMeasure Min(List<BaseProgressMeasure> progressmeasures, int priority) {

        BaseProgressMeasure min = progressmeasures.get(0);
        for (int i = 0; i < progressmeasures.size(); i++) {
            if (BaseProgressMeasure.Compare(progressmeasures.get(i), min, priority) == 1) {
                min = progressmeasures.get(i);
            }
        }
        return min;
    }

    public static BaseProgressMeasure Max(List<BaseProgressMeasure> progressmeasures, int priority) {

        BaseProgressMeasure max = progressmeasures.get(0);
        for (int i = 0; i < progressmeasures.size(); i++) {
            if (BaseProgressMeasure.Compare(progressmeasures.get(i), max, priority) == -1) {
                max = progressmeasures.get(i);
            }
        }
        return max;
    }

    public static BaseProgressMeasure Prog(ParityGame parityGame, int v, int w, int priority) {
        BaseProgressMeasure pm1 = parityGame.progressMeasures[v];
        BaseProgressMeasure pm2 = parityGame.progressMeasures[w];


        // Todo: Roxanne good luck

        return pm1;

    }

    //public static BaseProgressMeasure Lift()

    public void Solve() {

        int index = liftingStrategy.Next();

        List<BaseProgressMeasure> progressMeasures = new ArrayList<BaseProgressMeasure>();
        List<Integer> inedges = parityGame.E.inEdges(index);
        for(int i = 0; i < inedges.size(); i++) {
            progressMeasures.add(parityGame.progressMeasures[inedges.get(i)]);
        }

        if (parityGame.player[index]) {


            Min(progressMeasures, parityGame.p[index]);
        }


        // While not stable {

        // }
    }

}
