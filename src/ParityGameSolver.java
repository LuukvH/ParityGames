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
    private boolean[] stable;
    private ParityGame parityGame;
    private ILiftingStrategy liftingStrategy;
    private ProgressMeasure[] progressMeasures;
    private BaseProgressMeasure maxProgressMeasure;

    public ParityGameSolver(ParityGame parityGame, ILiftingStrategy liftingStrategy)
    {
        this.parityGame = parityGame;
        this.liftingStrategy = liftingStrategy;

        Initialize();
    }

    private void Initialize() {
        stable = new boolean[parityGame.V.size()];
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

    private boolean Stable() {
        for (int i = 0; i < stable.length; i++) {
            if(!stable[i])
                return false;
        }
        return true;
    }

    public void Solve() {
        int i = 0;
        int v = liftingStrategy.Next();

        while(!Stable()) {
            ProgressMeasure lift = Lift(v);

            // If vertex already stable skip and take next
            if (stable[v]) {
                v = liftingStrategy.Next();
                continue;
            }

            System.out.println(String.format("Lifting vertex: %d", v));

            // If progress measure hasn't changed go to next
            if (lift.Equals(progressMeasures[v], parityGame.p[v])) {
                stable[v] = true;
                progressMeasures[v] = lift;
                v = liftingStrategy.Next();
            } else {
                progressMeasures[v] = lift;

                // For each inedge set stable false
                List<Integer> inEdges = parityGame.E.inEdges(v);
                for (int e : inEdges) {
                    stable[e] = false;
                }
            }

            System.out.println(toString(i));
            i++;
        }
    }

    public String toString(int itter) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("---- Itteration %d ---- \n", itter));
        for (int i = 0; i < parityGame.V.size(); i++) {
            sb.append(String.format("%s %s \n", progressMeasures[i].toTopString(), stable[i]));
        }
        return sb.toString();
    }

}
