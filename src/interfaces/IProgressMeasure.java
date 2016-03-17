package interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laj on 17-3-2016.
 *
 * The abstract class progress measure, this is base for the Progress Measures
 */
public abstract class IProgressMeasure {

    protected int maxPriority;
    protected int[] measure;
    protected boolean top = false;

    protected IProgressMeasure(int maxPriority) {
        this.maxPriority = maxPriority;
        measure = new int[(int)Math.floorDiv(maxPriority, 2)];
    }

    public int getMaxPriority() {
        return maxPriority;
    }

    public int Get(int priority) {
        if (priority > maxPriority || priority < 0)
            throw new IndexOutOfBoundsException();

        if ((priority & 1) == 0)
            return 0;

        int index = ((int)Math.floorDiv(priority, 2));
        return measure[index];
    }

    public abstract boolean Increase(int priority);

    public String toString() {
        if (top) { return "(T)"; };

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < maxPriority; i++) {
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
