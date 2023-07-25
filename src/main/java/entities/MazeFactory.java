package entities;

/**
 * Maze factory creates a new MazeFacade. This class is designed so that in the future when the user inputs
 * different generators, it is able to create mazes with different generation algorithms.
 */
public class MazeFactory {

    public MazeFacade create(int rows, int columns) {
        return new MazeFacade(rows, columns);
    }
}
