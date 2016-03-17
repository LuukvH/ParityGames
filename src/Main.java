import models.MaxProgressMeasure;
import models.ProgressMeasure;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MaxProgressMeasure mpm = new MaxProgressMeasure(6);
        mpm.Set(1, 2);
        mpm.Set(5, 4);
        mpm.Set(3, 3);

        ProgressMeasure pm = new ProgressMeasure(mpm);
        for (int i = 0; i < 400; i++) {
            pm.Increase(5);
            System.out.println(pm.toString());
        }

    }
}
