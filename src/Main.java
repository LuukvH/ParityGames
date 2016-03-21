import models.ParityGameFactory;
import models.ProgressMeasure.*;
import models.ParityGame;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ParityGame parityGame = ParityGameFactory.CreateExample();

        MaxProgressMeasure mpm = MaxProgressMeasureFactory.Create(parityGame);
        System.out.println(String.format("Max Progress Measure: %s", mpm.toString()));

        BaseProgressMeasure pm1 = new ProgressMeasure(parityGame.getMaxPriority());

        for (int i = 0; i < 5; i++) {
            pm1 = pm1.Increase(mpm, 1);
            System.out.println(pm1.toTopString());
            System.out.println(pm1.toString());
        }

        MaxProgressMeasure mpm1 = new MaxProgressMeasure(6);
        mpm1.Set(1, 1);
        mpm1.Set(3, 3);
        mpm1.Set(5, 4);
        System.out.println(mpm1.toString());

        MaxProgressMeasure mpm2 = new MaxProgressMeasure(6);
        mpm2.Set(1, 1);
        mpm2.Set(3, 4);
        mpm2.Set(5, 4);
        System.out.println(mpm2.toString());

        MaxProgressMeasure mpm3 = new MaxProgressMeasure(6);
        mpm3.Set(1, 1);
        mpm3.Set(3, 4);
        mpm3.Set(5, 4);
        System.out.println(mpm3.toString());

        List<BaseProgressMeasure> progressMeasures = new ArrayList<BaseProgressMeasure>();
        progressMeasures.add(mpm1);
        progressMeasures.add(mpm2);
        progressMeasures.add(mpm3);

        System.out.println("Result: " + ParityGameSolver.Min(progressMeasures, 5).toString());

    }


}
