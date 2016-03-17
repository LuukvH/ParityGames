package models;

import interfaces.IProgressMeasure;

/**
 * Created by laj on 17-3-2016.
 *
 * This will class keep the status of the current progress measures.
 * This class makes sure that progress measures are counted correctly.
 * The function top indicates if top is reached for this measure,
 * to give a correct top indication instantiation with the max progress measure is required.
 */
public class ProgressMeasure extends IProgressMeasure {

    private MaxProgressMeasure mpm;

    public ProgressMeasure(MaxProgressMeasure mpm) {
        super(mpm.getMaxPriority());
        this.mpm = mpm;
    }

    public boolean Top() {
        return top;
    }

    @Override
    public boolean Increase(int priority) {
        if (priority <= 0 || priority > maxPriority || top || (priority & 1) == 0)
            return false;

        int index = ((int)Math.floorDiv(priority, 2));
        if (measure[index] < mpm.Get(priority)) {
            measure[index]++;
            return true;
        } else {
            if (this.Increase(priority - 2)) {
                measure[index] = 0;
                return true;
            }
        }

        top = true;
        return false;
    }
}
