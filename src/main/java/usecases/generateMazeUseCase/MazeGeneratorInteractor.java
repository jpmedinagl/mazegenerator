package usecases.generateMazeUseCase;

import entities.Maze;
import entities.MazeFactory;

/**
 * Interactor that is responsible for executing the use case. If the inputs are valid it creates
 * a mazeManager that generates the Maze. Uses a strategy design pattern with the generator as it calls the
 * generator to generate a maze. Different types of generators can generate the maze differently.
 */
public class MazeGeneratorInteractor implements MazeGeneratorInputBoundary{
    private final MazeGeneratorOutputBoundary mazePresenter;
    private final MazeFactory mazeFactory;
    private Generator mazeGenerator;

    public MazeGeneratorInteractor(MazeGeneratorOutputBoundary mazePresenter, MazeFactory mazeFactory, Generator generator) {
        this.mazePresenter = mazePresenter;
        this.mazeFactory = mazeFactory;
        setMazeGenerator(generator);
    }

    public void setMazeGenerator(Generator generator) {
        this.mazeGenerator = generator;
    }

    public MazeGeneratorResponseModel generateMaze(MazeGeneratorRequestModel requestModel) {
        if (requestModel.getRows() <= 0 || requestModel.getColumns() <= 0) {
            mazePresenter.prepareFailView("Invalid: Rows or columns are less than zero.");
        }

        Maze maze = mazeFactory.create(requestModel.getRows(), requestModel.getColumns());

        mazeGenerator.generateMaze(maze);

        MazeRepresentation representationModel = new MazeRepresentation(maze.getMaze());
        return mazePresenter.prepareSuccessView(representationModel);
    }
}
