package models;

import interfaces.ILiftingStrategy;
import models.ParityGame;
import models.ProgressMeasure.BaseProgressMeasure;
import models.ProgressMeasure.MaxProgressMeasureFactory;
import models.ProgressMeasure.ProgressMeasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laj on 18-3-2016.
 */
public class ParityGameSolver {
    private ParityGame parityGame;
    private ILiftingStrategy liftingStrategy;
    public ProgressMeasure[] progressMeasures;
    private BaseProgressMeasure maxProgressMeasure;
    public boolean print = false;

    public ParityGameSolver(ParityGame parityGame, ILiftingStrategy liftingStrategy)
    {
        this.parityGame = parityGame;
        this.liftingStrategy = liftingStrategy;

        Initialize();

        this.liftingStrategy.Initialize(this);
    }

    private void Initialize() {
        maxProgressMeasure = MaxProgressMeasureFactory.Create(parityGame);
        progressMeasures = new ProgressMeasure[parityGame.V.size()];

        for  (int i =0; i< parityGame.V.size(); i++) {
            progressMeasures[i] = new ProgressMeasure(parityGame.getMaxPriority());
        }
    }

    public BaseProgressMeasure getMaxProgressMeasure() {
        return maxProgressMeasure;
    }

    private ProgressMeasure Min(List<ProgressMeasure> progressmeasures, int priority) {

        ProgressMeasure min = progressmeasures.get(0);
        for (int i = 0; i < progressmeasures.size(); i++) {
            if (BaseProgressMeasure.Compare(progressmeasures.get(i), min, priority) == 1) {
                min = progressmeasures.get(i);
            }
        }
        return min;
    }

    private ProgressMeasure Max(List<ProgressMeasure> progressmeasures, int priority) {

        ProgressMeasure max = progressmeasures.get(0);
        for (int i = 0; i < progressmeasures.size(); i++) {
            if (BaseProgressMeasure.Compare(progressmeasures.get(i), max, priority) == -1) {
                max = progressmeasures.get(i);
            }
        }
        return max;
    }

    private ProgressMeasure Prog(int v, int w, int priority) {

        ProgressMeasure pm2 = progressMeasures[w];
        BaseProgressMeasure pm = pm2.Increase(maxProgressMeasure, priority);
        //if (BaseProgressMeasure.Compare(pm, maxProgressMeasure, priority) == 1)
        //    return new ProgressMeasure(maxProgressMeasure);

        return new ProgressMeasure(pm);

    }

    public ProgressMeasure Lift(int v) {
        List<ProgressMeasure> progressMeasures = new ArrayList<ProgressMeasure>();
        List<Integer> outedges = parityGame.E.outEdges(v);
        for(int i = 0; i < outedges.size(); i++) {
            progressMeasures.add(Prog(v, outedges.get(i), parityGame.p[v]));
        }

        if (parityGame.player[v]) {
            return Min(progressMeasures, parityGame.p[v]);
        } else {
            return Max(progressMeasures, parityGame.p[v]);
        }
    }

    public void Solve() {
        int i = 0;
        int v;

        while((v = liftingStrategy.Next()) != -1) {
            ProgressMeasure lift = Lift(v);

            if (!Lift(v).Equals(progressMeasures[v], parityGame.p[v])) {
                liftingStrategy.Lifted(v);
                progressMeasures[v] = lift;
            } else {
                progressMeasures[v] = lift;
            }

            i++;


            System.out.println(toString(i));
        }
        System.out.printf(", Nr of itterations: %d, ", i);

    }

    public String toString(int itter) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("---- Itteration %d ---- \n", itter));
        for (int i = 0; i < parityGame.V.size(); i++) {
            sb.append(String.format("%s \n", progressMeasures[i].toTopString()));
        }
        return sb.toString();
    }

}
