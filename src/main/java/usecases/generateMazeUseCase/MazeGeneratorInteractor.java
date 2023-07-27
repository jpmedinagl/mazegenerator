package usecases.generateMazeUseCase;

import entities.Maze;
import entities.MazeFactory;

/**
 * Interactor that is responsible for executing the use case. If the inputs are valid it creates
 * a mazeManager that generates the Maze.
 */
public class MazeGeneratorInteractor implements MazeGeneratorInputBoundary{
    private final MazeGeneratorOutputBoundary mazePresenter;
    private final MazeFactory mazeFactory;
    private final Generator mazeGenerator;

    public MazeGeneratorInteractor(MazeGeneratorOutputBoundary mazePresenter, MazeFactory mazeFactory, Generator generator) {
        this.mazePresenter = mazePresenter;
        this.mazeFactory = mazeFactory;
        this.mazeGenerator = generator;
    }

    public MazeGeneratorResponseModel generateMaze(MazeGeneratorRequestModel requestModel) {
        if (requestModel.getRows() <= 0 || requestModel.getColumns() <= 0) {
            mazePresenter.prepareFailView("Invalid: Rows or columns are less than zero.");
        }

        // MazeFacade mazeManager = mazeFactory.create(requestModel.getRows(), requestModel.getColumns());

        Maze maze = mazeFactory.create(requestModel.getRows(), requestModel.getColumns());

        // mazeManager.generateMaze();

        mazeGenerator.generateMaze(maze);

        MazeRepresentation representationModel = new MazeRepresentation(maze.getMaze());

        return mazePresenter.prepareSuccessView(representationModel);
    }
}
