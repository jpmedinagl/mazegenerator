import java.util.Iterator;

public class MazeIterator implements Iterator<int[]> {
    private int currentRow = 0;
    private final Maze maze;

    public MazeIterator(Maze maze) {
        this.maze = maze;
    }

    @Override
    public boolean hasNext() {
        return currentRow < maze.getRows();
    }

    @Override
    public int[] next() {
        int[] row = maze.getRow(currentRow);
        currentRow++;
        return row;
    }
}
