import models.ParityGameFactory;
import models.ProgressMeasure.BaseProgressMeasure;
import models.ProgressMeasure.MaxProgressMeasure;
import models.ParityGame;
import models.ProgressMeasure.MaxProgressMeasureFactory;
import models.ProgressMeasure.ProgressMeasure;

import java.io.IOException;

import spark.Spark;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ParityGame parityGame = ParityGameFactory.CreateExample();

        MaxProgressMeasure mpm = MaxProgressMeasureFactory.Create(parityGame);
        System.out.println(String.format("Max Progress Measure: %s", mpm.toTopString()));

        BaseProgressMeasure pm1 = new ProgressMeasure(parityGame.getMaxPriority());
        BaseProgressMeasure pm2 = new ProgressMeasure(parityGame.getMaxPriority());


        Spark.staticFileLocation("/html");
        get("/hectopunten", "application/json", (req, res) -> {
            return  "";
        });

        for (int i = 0; i < 5; i++) {
            pm1 = pm1.Increase(mpm, 1);
            System.out.println(pm1.toTopString());
            System.out.println(pm1.toString());
        }

    }
}
