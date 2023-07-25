package usecases.generateMazeUseCase;

/**
 * Output boundary that is implemented by the Presenter for the Interactor to call on its methods.
 */
public interface MazeGeneratorOutputBoundary {

    MazeGeneratorResponseModel prepareSuccessView(MazeRepresentation mazeRepresentation);

    MazeGeneratorResponseModel prepareFailView(String error);
}
