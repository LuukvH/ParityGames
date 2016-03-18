package models.ProgressMeasure;

import interfaces.IRO;

/**
 * Created by laj on 17-3-2016.
 * <p>
 * This will class keep the status of the current progress measures.
 * This class makes sure that progress measures are counted correctly.
 * The function top indicates if top is reached for this measure,
 * to give a correct top indication instantiation with the max progress measure is required.
 */
public class RO extends IRO {

    MaxRO mpm;

    public RO(MaxRO mpm) {
        super(mpm.getMaxPriority());
        this.mpm = mpm;
    }

    private RO(RO ro) {
        super(ro.getMaxPriority());
        mpm = ro.mpm;
        measure = ro.measure.clone();
    }

    public RO Clone() {
        return new RO(this);
    }

    public boolean Top() {
        return top;
    }

    public boolean Increase(int priority) {
        if (priority <= 0 || priority > maxPriority || top || (priority & 1) == 0)
            return false;

        int index = ((int) Math.floorDiv(priority, 2));
        if (measure[index] < mpm.Get(priority)) {
            if (measure[index] < mpm.Get(priority)) {
                measure[index]++;
                return true;
            }
        }

        if (this.Increase(priority - 2)) {
            measure[index] = 0;
            return true;
        }

        top = true;
        return false;
    }
}
