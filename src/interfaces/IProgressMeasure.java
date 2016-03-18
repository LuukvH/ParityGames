package interfaces;

import models.ProgressMeasure.AbstractProgressMeasure;

/**
 * Created by laj on 18-3-2016.
 */
public interface IProgressMeasure {
    int getMaxPriority();

    boolean Top();

    boolean Equals(IProgressMeasure ro);

    boolean Equals(IProgressMeasure ro, int priority);

    int Get(int priority);

    String toString();

    IProgressMeasure Increase(IProgressMeasure pm, int priority);
}
