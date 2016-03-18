package interfaces;

import models.ProgressMeasure.BaseProgressMeasure;

/**
 * Created by laj on 18-3-2016.
 */
public interface IProgressMeasure {
    int getMaxPriority();

    boolean Top();

    boolean Equals(BaseProgressMeasure pm);

    boolean Equals(BaseProgressMeasure pm, int priority);

    int Get(int priority);

    // Returns a new increased progressmeasure
    BaseProgressMeasure Increase(BaseProgressMeasure pm, int priority);

    String toString();

    String toTopString();
}
