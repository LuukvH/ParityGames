package models.ProgressMeasure;

import interfaces.IProgressMeasure;

/**
 * Created by laj on 17-3-2016.
 *
 * The abstract class progress measure, this is base for the Progress Measures
 */
public abstract class BaseProgressMeasure implements IProgressMeasure {

    protected int maxPriority;
    protected int[] measure;
    protected boolean top = false;

    protected BaseProgressMeasure(int maxPriority) {
        this.maxPriority = maxPriority;
        measure = new int[(int)Math.floorDiv(maxPriority + 1, 2)];
    }

    @Override
    public int getMaxPriority() {
        return maxPriority;
    }

    @Override
    public boolean Top() {
        return top;
    }

    @Override
    public boolean Equals(BaseProgressMeasure pm) {
        return Equals(pm, getMaxPriority());
    }

    @Override
    public boolean Equals(BaseProgressMeasure pm, int priority) {
        if (pm.getMaxPriority() != this.getMaxPriority())
            return false;

        int index = ((int) Math.floorDiv(priority, 2));
        for (int i = index; i >= 0; i--) {
            if (this.Get(i) != pm.Get(i))
                return false;
        }

        return true;
    }

    @Override
    public int Get(int priority) {
        if (priority > maxPriority || priority < 0)
            throw new IndexOutOfBoundsException();

        if ((priority & 1) == 0)
            return 0;

        int index = ((int)Math.floorDiv(priority, 2));
        return measure[index];
    }

    private BaseProgressMeasure Clone(){
        ProgressMeasure pm = new ProgressMeasure(this.getMaxPriority());
        pm.measure = this.measure.clone();
        pm.top = this.top;
        return pm;
    }

    // Returns a new increased progressmeasure
    @Override
    public BaseProgressMeasure Increase(BaseProgressMeasure pm, int priority) {

        BaseProgressMeasure npm = this.Clone();

        if (npm.Top()) {
            return npm;
        }

        npm.Increase(npm, pm, priority);
        return npm;
    }

    private boolean Increase(BaseProgressMeasure npm, BaseProgressMeasure pm, int priority) {
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
            npm.measure = pm.measure;
            npm.top = pm.top;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < maxPriority + 1; i++) {
            if ( (i & 1) == 0 ) {
                sb.append("0,");
            } else {
                sb.append(String.format("%d,",measure[(int)Math.floorDiv(i, 2)]));
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return  sb.toString();
    }

    @Override
    public String toTopString() {
        if (top) { return "(T)"; };
        return toString();
    }
}
