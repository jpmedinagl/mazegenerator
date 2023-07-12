import java.util.Iterator;

public class Maze implements Iterable<int[]> {
    private final int rows;
    private final int columns;
    private final int[][] maze;
    private final Generator generator;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.maze = new int[rows][columns];
        this.generator = new DFSGenerator();
    }

    public void generateMaze() {
        generator.generateMaze(this);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[] getRow(int row) {
        return maze[row];
    }

    public int getCell(int row, int column) {
        return maze[row][column];
    }

    public void setCell(int row, int column, int value) {
        maze[row][column] = value;
    }

    public void printMaze() {
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

    @Override
    public Iterator<int[]> iterator() {
        return new MazeIterator(this);
    }
}
