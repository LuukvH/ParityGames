package models.ProgressMeasure;

import models.ParityGame;

/**
 * Created by laj on 17-3-2016.
 *
 * Calculate max progressmeasure from Parity Game
 */
public class MaxProgressMeasureFactory {

    public static MaxProgressMeasure Create(ParityGame parityGame) {
        int[] p = parityGame.GetPriorityList();

        MaxProgressMeasure mpm = new MaxProgressMeasure(parityGame.getMaxPriority());
        for(int i = 0; i < p.length; i++) {
            mpm.Increase(p[i]);
        }

        return mpm;
    }
}
