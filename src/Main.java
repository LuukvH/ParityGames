import models.ParityGameFactory;
import models.ProgressMeasure.MaxProgressMeasure;
import models.ParityGame;
import models.ProgressMeasure.MaxProgressMeasureFactory;
import models.ProgressMeasure.ProgressMeasure;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ParityGame parityGame  = ParityGameFactory.CreateExample();

        MaxProgressMeasure mpm = MaxProgressMeasureFactory.Create(parityGame);
        System.out.println(String.format("Max Progress Measure: %s", mpm.toString()));

        MaxProgressMeasure ro = new MaxProgressMeasure(3);
        ro.Set(1,  2);
        ro.Set(3,  2);
        System.out.println("ROS: " + ro.toString());

        ProgressMeasure pm = new ProgressMeasure(mpm);
            for (int i =0; i < 12; i++) {

                System.out.println(pm.toString());
            }
    }
}
