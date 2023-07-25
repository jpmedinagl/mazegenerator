package usecases.generateMazeUseCase;

/**
 * Maze Representation data structure that is created to represent the Maze Entity. This is passed to the Presenter
 * which is why we require this data structure.
 */
public class MazeRepresentation {
    private final int[][] maze;

    public MazeRepresentation(int[][] maze) {
        this.maze = maze;
    }

    public int[][] getMaze() {
        return maze;
    }
}
