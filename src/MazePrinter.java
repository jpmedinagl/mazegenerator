public class MazePrinter implements Printer {

    public void printMaze(Maze maze) {
        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == 1) {
                    System.out.print("# "); // Wall
                } else if (cell == 2) {
                    System.out.print("S "); // Start
                } else if (cell == 3) {
                    System.out.print("E "); // End
                } else {
                    System.out.print("  "); // Path
                }
            }
            System.out.println();
        }
    }
}
