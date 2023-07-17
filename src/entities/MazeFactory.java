package entities;

public class MazeFactory {
    public MazeFacade create(int rows, int columns) {
        return new MazeFacade(rows, columns);
    }
}
