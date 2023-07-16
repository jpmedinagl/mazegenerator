package generate_maze_use_case;

import entities.MazeFacade;
import entities.MazeFactory;

public class MazeGeneratorInteractor implements MazeGeneratorInputBoundary{

    private final MazeGeneratorOutputBoundary mazePresenter;
    private final MazeFactory mazeFactory;

    public MazeGeneratorInteractor(MazeGeneratorOutputBoundary mazePresenter, MazeFactory mazeFactory) {
        this.mazePresenter = mazePresenter;
        this.mazeFactory = mazeFactory;
    }

    public MazeGeneratorResponseModel generateMaze(MazeGeneratorRequestModel requestModel) {
        if (requestModel.getRows() < 0 || requestModel.getColumns() < 0) {
            mazePresenter.prepareFailView("Invalid: Rows or columns are less than zero. ");
        }

        MazeFacade mazeManager = mazeFactory.create(requestModel.getRows(), requestModel.getColumns());

        mazeManager.generateMaze();

        MazeRepresentation representationModel = new MazeRepresentation(mazeManager.getMazeRepresentation());

        return mazePresenter.prepareSuccessView(representationModel);
    }
}