import java.util.*;

public class Maze {
    private final int rows;
    private final int columns;
    private final int[][] maze;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.maze = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getCell(int row, int column) {
        return maze[row][column];
    }

    public void setCell(int row, int column, int value) {
        maze[row][column] = value;
    }

    public void generateMaze() {
        Random random = new Random();

        // Initialize maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze[i][j] = 1; // 1 represents walls
            }
        }

        // int startRow = random.nextInt(rows);
        // int startColumn = random.nextInt(columns);

        int startRow = 1;
        int startColumn = 0;

        generateMazeRecursive(startRow, startColumn);

        // Set start and end points
        maze[startRow][startColumn] = 2; // 2 represents the start point
        maze[rows - 1][columns - 1] = 3; // 3 represents the end point
    }

    private void generateMazeRecursive(int row, int col) {
        int[] directions = { 1, 2, 3, 4 }; // 1: up, 2: right, 3: down, 4: left
        shuffleArray(directions);

        for (int direction : directions) {
            int newRow = row;
            int newCol = col;

            if (direction == 1) {
                newRow -= 2;
            } else if (direction == 2) {
                newCol += 2;
            } else if (direction == 3) {
                newRow += 2;
            } else if (direction == 4) {
                newCol -= 2;
            }

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns && maze[newRow][newCol] == 1) {
                maze[newRow][newCol] = 0; // 0 represents the path

                if (direction == 1) {
                    maze[row - 1][col] = 0;
                } else if (direction == 2) {
                    maze[row][col + 1] = 0;
                } else if (direction == 3) {
                    maze[row + 1][col] = 0;
                } else if (direction == 4) {
                    maze[row][col - 1] = 0;
                }

                generateMazeRecursive(newRow, newCol);
            }
        }
    }

    private void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maze[i][j] == 1) {
                    System.out.print("# "); // Wall
                } else if (maze[i][j] == 2) {
                    System.out.print("S "); // Start
                } else if (maze[i][j] == 3) {
                    System.out.print("E "); // End
                } else {
                    System.out.print("  "); // Path
                }
            }
            System.out.println();
        }
    }
}
