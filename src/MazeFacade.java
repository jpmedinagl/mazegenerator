public class MazeFacade {

    private final Maze maze;
    private final Generator generator;
    private final Printer printer;

    public MazeFacade(int rows, int columns) {
        this.maze = new Maze(rows, columns);
        this.generator = new DFSGenerator();
        this.printer = new MazePrinter();
    }

    public void generateMaze() {
        generator.generateMaze(maze);
    }

    public void printMaze() {
        printer.printMaze(maze);
    }
}
