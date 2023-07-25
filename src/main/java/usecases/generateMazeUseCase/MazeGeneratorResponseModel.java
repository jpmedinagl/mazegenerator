package generate_maze_use_case;

public class MazeGeneratorResponseModel {

    private final String maze;

    public MazeGeneratorResponseModel(String mazeRepresentation) {
        this.maze = mazeRepresentation;
    }

    public String getMaze() {
        return this.maze;
    }
}
