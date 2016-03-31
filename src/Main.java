import interfaces.ILiftingStrategy;
import models.*;
import models.Lifting.strategy.*;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        Boolean ptest = false;
        int iterations = 1;
        String folder = "";

        // Do this one for a foler
        args = new String[14];
        args[0] = "-i";
        args[1] = "1";
        args[2] = "-g";
        args[3] = "res/dining-games/dining_2.invariantly_plato_starves.gm";
        args[4] = "-s";
        args[5] = "0";
        args[6] = "-s";
        args[7] = "1";
        args[8] = "-s";
        args[9] = "2";
        args[10] = "-s";
        args[11] = "3";
        args[12] = "-s";
        args[13] = "4";

        // dining_5.invariantly_plato_starves
        //args[2] = "-t";
        //args[3] = "res/dining-games/";

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
            strategies.add(3);
            strategies.add(4);
        }

        if (games.isEmpty()) {
            System.out.println("Supply a Parity Game with -g \"filename.gm\" ");
            return;
        }

        ParityGame parityGame = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (File game : games) {
            System.out.printf("Read Parity Game: %s", game.getName());
            Long startTime = System.nanoTime();
            parityGame = PGSolverReader.ReadFile(game.toString());
            // parityGame = ParityGameFactory.CreateExample();
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
                        liftingStrategy = new InputOrderLiftingStrategy(parityGame);
                        break;
                    case 1:
                        liftingStrategy = new RandomLiftingStrategy(parityGame);
                        break;
                    case 2:
                        liftingStrategy = new LinearLiftingStrategy(parityGame);
                        break;
                    case 3:
                        liftingStrategy = new SelfLoopsLiftingStrategy(parityGame);
                        break;
                    case 4:
                        liftingStrategy = new PredecessorLiftingStrategy(parityGame);
                        break;
                }

                Long durationsum = 0L;
                int iterationsum = 0;
                Result result = null;
                for (int i = 0; i < iterations; i++) {
                    solver = new ParityGameSolver(parityGame, liftingStrategy);
                    solver.print = true;
                    System.out.print(String.format("Evaluate: %12s - %s ", liftingStrategy.Name(), game.getName()));
                    result = solver.Solve();
                    System.out.printf("(%f ms) \n", (result.getDuration()) / (float) 1000000);

                    durationsum += result.getDuration();
                    iterationsum += result.getItterations();

                    // Collect results
                    result.odd = new LinkedList<Integer>();
                    result.even = new LinkedList<Integer>();
                    for (Integer r : parityGame.V) {
                        if (solver.progressMeasures[r].Top()) {
                            result.odd.add(r);
                        } else {
                            result.even.add(r);
                        }
                    }

                    System.out.println(result.odd.toString());
                }
                System.out.printf("Average: %f ms \n", (durationsum / iterations) / (float) 1000000);

                // Collect results
                result.odd = new LinkedList<Integer>();
                result.even = new LinkedList<Integer>();
                for (Integer r : parityGame.V) {
                    if (solver.progressMeasures[r].Top()) {
                        result.odd.add(r);
                    } else {
                        result.even.add(r);
                    }
                }

                result.setItterations(iterationsum / iterations);
                result.setDuration(durationsum / iterations);
                result.setGame(game.getName());
                stringBuilder.append(result.toJSON() + ",");
            }
        }



        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");

        if (ptest) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(folder + "result.json"));
                writer.write(stringBuilder.toString());

            } catch (IOException e) {
            } finally {
                try {
                    if (writer != null)
                        writer.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
