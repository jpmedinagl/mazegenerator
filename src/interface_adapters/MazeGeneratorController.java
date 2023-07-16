package interface_adapters;

import generate_maze_use_case.MazeGeneratorInteractor;
import generate_maze_use_case.MazeGeneratorRequestModel;
import generate_maze_use_case.MazeGeneratorResponseModel;

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