package models.ProgressMeasure;

import interfaces.IProgressMeasure;

/**
 * Created by laj on 17-3-2016.
 *
 * The abstract class progress measure, this is base for the Progress Measures
 */
public abstract class AbstractProgressMeasure implements IProgressMeasure {

    protected int maxPriority;
    protected int[] measure;
    protected boolean top = false;

    protected AbstractProgressMeasure(int maxPriority) {
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
    public boolean Equals(IProgressMeasure pm) {
        return Equals(pm, getMaxPriority());
    }

    @Override
    public boolean Equals(IProgressMeasure pm, int priority) {
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

    @Override
    public IProgressMeasure Increase(IProgressMeasure pm, int priority) {

        AbstractProgressMeasure npm = new ProgressMeasure(this.getMaxPriority());




        return  pm;
    }

    @Override
    public String toString() {
        if (top) { return "(T)"; };

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
}
