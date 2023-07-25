package usecases.generateMazeUseCase;

/**
 * Input boundary that is implemented by Interactor for the Controller to call on its method.
 */
public interface MazeGeneratorInputBoundary {
    MazeGeneratorResponseModel generateMaze(MazeGeneratorRequestModel requestModel);
}
