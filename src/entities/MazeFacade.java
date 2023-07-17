package entities;

public class MazeFacade {

    private final Maze maze;
    private final Generator generator;

    public MazeFacade(int rows, int columns) {
        this.maze = new Maze(rows, columns);
        this.generator = new DFSGenerator();
    }

    public void generateMaze() {
        generator.generateMaze(maze);
    }

    public int[][] getMazeRepresentation() {
        return this.maze.getMaze();
    }
}
