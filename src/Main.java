import interfaces.ILiftingStrategy;
import models.Lifting.strategy.EvenSelfLoopsFirstStrategy;
import models.Lifting.strategy.InputOrderStrategy;
import models.Lifting.strategy.RandomStrategy;
import models.Man;
import models.ParityGameFactory;
import models.ParityGame;
import models.Woman;
import models.PGSolverReader;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

//import spark.Spark;
//import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Boolean ptest = false;
        int iterations = 1;
        String folder = "";

        // Do this one for a foler
        args = new String[6];
        args[0] = "-t";
        args[1] = "res/dining-games/";
        args[2] = "-i";
        args[3] = "1";
        args[4] = "-s";
        args[5] = "2";

        Set<File> games = new OrderedHashSet<File>();
        Set<Integer> strategies = new OrderedHashSet<Integer>();

        if ((args.length > 1) && (args.length % 2 == 0)) {
            for (int i = 0; i < args.length - 1; i++) {
                if (args[i].equalsIgnoreCase("-g")) {
                    games.add(new File(args[i + 1]));
                } else if (args[i].equalsIgnoreCase("-s")) {
                    strategies.add(Integer.parseInt(args[i + 1]));
                } else if (args[i].equalsIgnoreCase("-t")) {
                    ptest = true;
                    folder = args[i + 1];
                } else if (args[i].equalsIgnoreCase("-i")) {
                    iterations = Integer.parseInt(args[i + 1]);
                }
            }
        } else {
            System.out.println("-g <filename>  To specify parity game in PGSolver format.");
            System.out.println("-s <i>         Select lifting strategy.");
            System.out.println("               0 = Input Order (default), 2 = Random");
            System.out.println("-t <path>      Test all Parity games in directory.");
            System.out.println("-i <n>         Set number of test itterations.");
        }

        if (strategies.isEmpty()) {
            strategies.add(0);
        }

        if (ptest) {
            File[] files = FileUtils.getFiles(folder, ".gm");
            files = FileUtils.OrderBySize(files);
            for (File file : files) {
                System.out.println("Game: " + file.toString());
                games.add(file);
            }

            strategies.clear();
            strategies.add(0);
            strategies.add(1);
            strategies.add(2);
        }

        if (games.isEmpty()) {
            System.out.println("Supply a Parity Game with -g \"filename.gm\" ");
            return;
        }

        ParityGame parityGame = null;
        for (File game : games) {
            System.out.printf("Read Parity Game: %s", game.getName());
            Long startTime = System.nanoTime();
            //parityGame = PGSolverReader.ReadFile(game.toString());
            parityGame = ParityGameFactory.CreateExample();
            System.out.printf(" (%f ms) \n", (System.nanoTime() - startTime) / (float) 1000000);

            if (parityGame == null) {
                System.out.print("Empty Parity Game.");
                return;
            }

            ILiftingStrategy liftingStrategy = null;
            ParityGameSolver solver = null;
            for (Integer s : strategies) {
                switch (s) {
                    case 0:
                        liftingStrategy = new InputOrderStrategy(parityGame);
                        break;
                    case 1:
                        liftingStrategy = new RandomStrategy(parityGame);
                        break;
                    case 2:
                        liftingStrategy = new EvenSelfLoopsFirstStrategy(parityGame);
                        break;
                }

                Long resultsum = 0L;
                for (int i =0; i < iterations; i++) {
                    solver = new ParityGameSolver(parityGame, liftingStrategy);
                    System.out.print(String.format("Evaluate: %12s - %s ", liftingStrategy.Name(), game.getName()));
                    startTime = System.nanoTime();
                    solver.Solve();
                    Long difference = System.nanoTime() - startTime;
                    resultsum += difference;
                    System.out.printf("(%f ms) \n", (difference) / (float) 1000000);
                }
                System.out.printf("Average: %f ms \n", resultsum / (float) 100000);
                System.out.println();
            }
        }
    }
}
