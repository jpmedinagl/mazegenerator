package usecases.generateMazeUseCase;

public class MazeRepresentation {

    private final int[][] maze;

    public MazeRepresentation(int[][] maze) {
        this.maze = maze;
    }

    public int[][] getMaze() {
        return maze;
    }
}
