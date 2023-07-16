package entities;

public class MazePrinter implements Printer {

    public String printMaze(Maze maze) {
        StringBuilder mazeRep = new StringBuilder();

        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == 1) {
                    mazeRep.append("# "); // Wall
                } else if (cell == 2) {
                    mazeRep.append("S "); // Start
                } else if (cell == 3) {
                    mazeRep.append("E "); // End
                } else {
                    mazeRep.append("  "); // Path
                }
            }
            mazeRep.append("\n");
        }

        return mazeRep.toString();
    }
}
