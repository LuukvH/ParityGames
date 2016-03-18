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
public class ProgressMeasure extends AbstractProgressMeasure implements IProgressMeasure {

    public ProgressMeasure(int maxPriority) {
        super(maxPriority);
    }

}
