package entities;

import java.util.Iterator;

/**
 * The representation of the Maze. It is an 2-dimensional array where each cell corresponds to an open-space or a wall.
 */
public class Maze implements Iterable<int[]> {
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

    public int[][] getMaze() {
        return this.maze;
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

    @Override
    public Iterator<int[]> iterator() {
        return new MazeIterator(this);
    }
}
