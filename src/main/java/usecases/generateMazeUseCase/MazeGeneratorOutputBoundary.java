package usecases.generateMazeUseCase;

public interface MazeGeneratorOutputBoundary {
    MazeGeneratorResponseModel prepareSuccessView(MazeRepresentation mazeRepresentation);

    MazeGeneratorResponseModel prepareFailView(String error);
}
