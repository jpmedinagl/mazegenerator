package usecases.generateMazeUseCase;

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
