package models.ProgressMeasure;

import models.ParityGame;

/**
 * Created by laj on 17-3-2016.
 *
 * Calculate max progressmeasure from Parity Game
 */
public class MaxROFactory {

    public static MaxRO Create(ParityGame parityGame) {
        int[] p = parityGame.GetPriorityList();

        MaxRO mpm = new MaxRO(parityGame.getMaxPriority());
        for(int i = 0; i < p.length; i++) {
            mpm.Increase(p[i]);
        }

        return mpm;
    }
}
