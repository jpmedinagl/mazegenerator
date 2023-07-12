import java.util.Random;

public class Generator {
    private final Maze maze;

    public Generator(Maze maze) {
        this.maze = maze;
    }

    public void generateMaze() {
        int startRow = getRandomNumber(maze.getRows());
        int startColumn = getRandomNumber(maze.getColumns());

        generateMazeRecursive(startRow, startColumn);

        // Set start and end points
        maze.setCell(startRow, startColumn, 2); // 2 represents the start point
        maze.setCell(maze.getRows() - 1, maze.getColumns() - 1, 3); // 3 represents the end point
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

            if (newRow >= 0 && newRow < maze.getRows() && newCol >= 0 && newCol < maze.getColumns() && maze.getCell(newRow, newCol) == 1) {
                maze.setCell(newRow, newCol, 0); // 0 represents the path

                if (direction == 1) {
                    maze.setCell(row - 1, col, 0);
                } else if (direction == 2) {
                    maze.setCell(row, col + 1, 0);
                } else if (direction == 3) {
                    maze.setCell(row + 1, col, 0);
                } else if (direction == 4) {
                    maze.setCell(row, col - 1, 0);
                }

                generateMazeRecursive(newRow, newCol);
            }
        }
    }

    private int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
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
}
