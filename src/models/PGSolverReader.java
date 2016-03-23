package models;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rox on 22-3-2016.
 */
public class PGSolverReader {

    public static ParityGame ReadFile(String fileName)
    {
        try (BufferedReader buffRead = new BufferedReader(new FileReader(fileName)))
        {
            ParityGame parityGame;
            String line = buffRead.readLine();
            int maxValue;

            if(line.contains("parity"))
            {
                //if the first line if given, we already have the maximum value
                line = line.replace("parity ", "");
                line = line.replace(";", "");
                maxValue = Integer.parseInt(line) + 1;

                line = buffRead.readLine();
            }
            else
            {
                //the first line not given, thus we have to calculate the maximum value
                BufferedReader buffRead2 = new BufferedReader(new FileReader(fileName));
                int count = 0;
                while ( buffRead2.readLine() != null)
                {
                    count++;
                }
                maxValue = count;
            }

            parityGame = new ParityGame(maxValue);

            int indexVertex = 0;
            int maxPriority = -1;
            String[] lineInfo;

            while(line != null)
            {
                lineInfo = line.split(" ");
                int vertex = Integer.parseInt(lineInfo[0]);
                parityGame.V.add(vertex);

                int prio = Integer.parseInt(lineInfo[1]);
                parityGame.p[indexVertex] = prio;
                if(prio>maxPriority)
                {
                    maxPriority = prio;
                }

                parityGame.player[indexVertex] = lineInfo[2].contains("1");

                String[] successors = lineInfo[3].split(",");

                for(int i = 0; i < successors.length; i++)
                {
                    parityGame.E.addEdge(vertex, Integer.parseInt(successors[i]));
                }

                indexVertex++;
                line = buffRead.readLine();
            }

            parityGame.setMaxPriority(maxPriority);
            return parityGame;
        }
        catch (IOException ex)
        {
            return null;
        }
    }
}
