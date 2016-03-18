package models.ProgressMeasure;


import interfaces.IProgressMeasure;

/**
 * Created by laj on 17-3-2016.
 * <p>
 * This will class keep the status of the current progress measures.
 * This class makes sure that progress measures are counted correctly.
 * The function top indicates if top is reached for this measure,
 * to give a correct top indication instantiation with the max progress measure is required.
 */
public class ProgressMeasure extends BaseProgressMeasure implements IProgressMeasure {

    public ProgressMeasure(int maxPriority) {
        super(maxPriority);
    }


    private ProgressMeasure Clone(){
        ProgressMeasure pm = new ProgressMeasure(this.getMaxPriority());
        pm.measure = this.measure.clone();
        pm.top = this.top;
        return pm;
    }

    // Returns a new increased progressmeasure
    public BaseProgressMeasure Increase(BaseProgressMeasure pm, int priority) {

        ProgressMeasure npm = this.Clone();

        if (npm.Top()) {
            return npm;
        }

        npm.Increase(npm, pm, priority);
        return npm;
    }

    private boolean Increase(ProgressMeasure npm, BaseProgressMeasure pm, int priority) {
        if (priority <= 0 || priority > maxPriority || npm.top || (priority & 1) == 0)
            return false;

        int index = ((int) Math.floorDiv(priority, 2));
        if (npm.measure[index] < pm.Get(priority)) {
            if (npm.measure[index] < pm.Get(priority)) {
                npm.measure[index]++;
                return true;
            }
        }

        if (this.Increase(npm, pm, priority - 2)) {
            npm.measure[index] = 0;
            return true;
        }

        if (pm.Top()) {
            npm.top = true;
            npm.measure = pm.measure.clone();
        }

        return false;
    }
}
