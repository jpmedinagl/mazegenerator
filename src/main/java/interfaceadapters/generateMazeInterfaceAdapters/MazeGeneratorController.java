package interfaceadapters.generateMazeInterfaceAdapters;

import usecases.generateMazeUseCase.MazeGeneratorInteractor;
import usecases.generateMazeUseCase.MazeGeneratorRequestModel;
import usecases.generateMazeUseCase.MazeGeneratorResponseModel;

/**
 * Controller which creates a request model and calls on the interactor to run the use case.
 */
public class MazeGeneratorController {
    private final MazeGeneratorInteractor mazeGeneratorInteractor;

    public MazeGeneratorController(MazeGeneratorInteractor mazeGeneratorInteractor) {
        this.mazeGeneratorInteractor = mazeGeneratorInteractor;
    }

    public MazeGeneratorResponseModel generateMaze(int rows, int columns) {
        MazeGeneratorRequestModel requestModel = new MazeGeneratorRequestModel(rows, columns);
        return mazeGeneratorInteractor.generateMaze(requestModel);
    }
}
