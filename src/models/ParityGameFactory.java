package models;

/**
 * Created by laj on 18-3-2016.
 */
public class ParityGameFactory {

    public static ParityGame CreateExample() {
        // Create testing parityGame
        ParityGame parityGame = new ParityGame(7);
        parityGame.setMaxPriority(3);

        parityGame.V.add(0);
        parityGame.V.add(1);
        parityGame.V.add(2);
        parityGame.V.add(3);
        parityGame.V.add(4);
        parityGame.V.add(5);
        parityGame.V.add(6);

        // X  = 0, X' = 1, Y  = 2, Y' = 3, Z  = 4, Z' = 5, W  = 6
        parityGame.E.addEdge(0,0); // X  -> X
        parityGame.E.addEdge(0,1); // X  -> X'
        parityGame.E.addEdge(1,4); // X' -> Z
        parityGame.E.addEdge(4,5); // Z  -> Z'
        parityGame.E.addEdge(5,5); // Z' -> Z'
        parityGame.E.addEdge(3,0); // Y' -> X
        parityGame.E.addEdge(3,2); // Y' -> Y
        parityGame.E.addEdge(2,3); // Y  -> Y'
        parityGame.E.addEdge(1,2); // X' -> Y
        parityGame.E.addEdge(2,6); // Y  -> W
        parityGame.E.addEdge(6,6); // W  -> W
        parityGame.E.addEdge(6,4); // W  -> Z

        parityGame.p[0] = 1; // X
        parityGame.p[1] = 1; // X'
        parityGame.p[2] = 2; // Y
        parityGame.p[3] = 2; // Y'
        parityGame.p[4] = 3; // Z
        parityGame.p[5] = 3; // Z'
        parityGame.p[6] = 3; // W

        parityGame.player[0] = false; // X
        parityGame.player[1] = true;  // X'
        parityGame.player[2] = false; // Y
        parityGame.player[3] = true;  // Y'
        parityGame.player[4] = true;  // Z
        parityGame.player[5] = true;  // Z'
        parityGame.player[6] = true;  // W

        return parityGame;
    }
}
