import interfaces.ILiftingStrategy;
import models.*;
import models.Lifting.strategy.*;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import spark.Spark;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean ptest = false;
        boolean verbose = false;
        boolean server = false;
        int iterations = 1;
        String folder = "";

        // Do this one for a foler
        /*
        args = new String[8];
        args[0] = "-i";
        args[1] = "1";
        args[2] = "-g";
        args[3] = "res/elevator-games/elevator1_5.gm"; // dining-games/dining_2.invariantly_plato_starves.gm";
        args[4] = "-s";
        args[5] = "9";
        args[6] = "-s";
        args[7] = "3";
        */

        Set<File> games = new OrderedHashSet<File>();
        Set<Integer> strategies = new OrderedHashSet<Integer>();

        try {
            if ((args.length > 1)) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equalsIgnoreCase("-g")) {
                        games.add(new File(args[i + 1]));
                    } else if (args[i].equalsIgnoreCase("-s")) {
                        strategies.add(Integer.parseInt(args[i + 1]));
                    } else if (args[i].equalsIgnoreCase("-t")) {
                        ptest = true;
                        folder = args[i + 1];
                    } else if (args[i].equalsIgnoreCase("-i")) {
                        iterations = Integer.parseInt(args[i + 1]);
                    } else if (args[i].equalsIgnoreCase("-b")) {
                        server = true;
                    }
                }
            } else {
                System.out.println("-g <filename>  To specify parity game in PGSolver format.");
                System.out.println("-s <i>         Select lifting strategy.");
                System.out.println("               0 = Input Order (default), 2 = Random");
                System.out.println("-t <path>      Test all Parity games in directory.");
                System.out.println("-i <n>         Set number of test itterations.");
                System.out.println("-b             Start server and show results in browser.");
            }
        } catch (Exception ex) {
            System.out.println("Error: Incorrect input.");
            System.out.println("-g <filename>  To specify parity game in PGSolver format.");
            System.out.println("-s <i>         Select lifting strategy.");
            System.out.println("               0 = Input Order (default), 2 = Random");
            System.out.println("-t <path>      Test all Parity games in directory.");
            System.out.println("-i <n>         Set number of test itterations.");
            System.out.println("-b             Start server and show results in browser.");
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
        StringBuilder resultsJSONString = new StringBuilder();
        StringBuilder gamesJSONString = new StringBuilder();
        resultsJSONString.append("\"results\":[");
        gamesJSONString.append("\"statistics\":[");
        for (File game : games) {
            System.out.printf("Read Parity Game: %s", game.getName());
            Long startTime = System.nanoTime();
            parityGame = PGSolverReader.ReadFile(game.toString());
            parityGame.setName(game.getName());
            System.out.printf(" (%f ms) \n", (System.nanoTime() - startTime) / (float) 1000000);

            if (parityGame == null) {
                System.out.print("Empty Parity Game.");
                return;
            }

            // Create parity game information
            gamesJSONString.append(parityGame.JSONStatistics());
            gamesJSONString.append(",");

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
                    case 9:
                        liftingStrategy = new CustomLiftingStrategy(parityGame);
                        break;
                }

                Long durationsum = 0L;
                int iterationsum = 0;
                Result result = null;
                for (int i = 0; i < iterations; i++) {
                    solver = new ParityGameSolver(parityGame, liftingStrategy);
                    solver.print = verbose;
                    System.out.print(String.format("Evaluate: %20s - %s ", liftingStrategy.Name(), game.getName()));
                    result = solver.Solve();
                    System.out.printf("(%f ms, %d iterations) \n", (result.getDuration()) / (float) 1000000, result.getItterations());

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

                    if (verbose)
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
                resultsJSONString.append(result.toJSON() + ",");
            }
        }

        resultsJSONString.deleteCharAt(resultsJSONString.length() - 1);
        gamesJSONString.deleteCharAt(gamesJSONString.length() - 1);
        resultsJSONString.append("]");
        gamesJSONString.append("]");
        String JSON = String.format("{%s,%s}", gamesJSONString.toString(), resultsJSONString.toString());

        if (ptest) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(folder + "result.json"));
                writer.write(JSON);

            } catch (IOException e) {
            } finally {
                try {
                    if (writer != null)
                        writer.close();
                } catch (IOException e) {
                }
            }
        }

        if (server) {

            Logger.getLogger("org").setLevel(Level.OFF);
            Logger.getLogger("akka").setLevel(Level.OFF);

            Spark.staticFileLocation("/html");
            get("/results", "application/json", (req, res) -> {
                return JSON;
            });
            Spark.awaitInitialization();
            System.out.println("Goto: localhost:4567 in your browser");
            System.out.println("To close server press any key to exit..");
            System.in.read();
            Spark.stop();
            System.out.println("Process stopped.");
        }
    }
}
