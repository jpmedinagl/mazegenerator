package entities;

/**
 * Facade that holds together the Maze as well as the generator. It delegates the functions of generating a Maze
 * as well as getting the Maze representation.
 */
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
