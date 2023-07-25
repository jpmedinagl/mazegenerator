package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazeTest {

    @Test
    public void testMazeCreation() {
        int rows = 5;
        int columns = 5;
        Maze maze = new Maze(rows, columns);

        Assertions.assertEquals(rows, maze.getRows());
        Assertions.assertEquals(columns, maze.getColumns());
    }

    @Test
    public void testSetAndGetCell() {
        int rows = 5;
        int columns = 5;
        Maze maze = new Maze(rows, columns);

        // Set a cell value
        int row = 2;
        int col = 3;
        int value = 1;
        maze.setCell(row, col, value);

        // Verify the cell value
        int retrievedValue = maze.getCell(row, col);
        Assertions.assertEquals(value, retrievedValue);
    }
}
