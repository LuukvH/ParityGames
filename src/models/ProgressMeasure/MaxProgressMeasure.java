package models.ProgressMeasure;

import interfaces.IProgressMeasure;

/**
 * Created by laj on 17-3-2016.
 *
 * This class can be used to set the MaxProgressMeasure.
 * Increase will increase the counter for the given priority.
 * Set can set the value of an priority directly.
 */
public class MaxProgressMeasure extends AbstractProgressMeasure implements IProgressMeasure {

    public MaxProgressMeasure(int maxPriority) {
        super(maxPriority);
        top = true;
    }

    public boolean Set(int priority, int value) {
        if (priority > maxPriority || priority < 0)
            throw new IndexOutOfBoundsException();

        if ((priority & 1) == 0)
            return false;

        int index = ((int)Math.floorDiv(priority, 2));
        measure[index] = value;
        return true;
    }

    public boolean Increase(int priority) {
        if (priority > maxPriority || priority < 0)
            throw new IndexOutOfBoundsException();

        if ((priority & 1) == 0)
            return false;

        int index = ((int)Math.floorDiv(priority, 2));
        measure[index]++;
        return true;
    }

}
