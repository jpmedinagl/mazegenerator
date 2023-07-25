package generate_maze_use_case;

public interface MazeGeneratorOutputBoundary {
    MazeGeneratorResponseModel prepareSuccessView(MazeRepresentation mazeRepresentation);

    MazeGeneratorResponseModel prepareFailView(String error);
}
