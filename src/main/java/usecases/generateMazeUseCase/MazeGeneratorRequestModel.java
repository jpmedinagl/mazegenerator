package generate_maze_use_case;

public class MazeGeneratorRequestModel {
    private final int rows;
    private final int columns;

    public MazeGeneratorRequestModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
