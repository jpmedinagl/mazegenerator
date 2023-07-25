package interfaceadapters.generateMazeInterfaceAdapters;

import usecases.generateMazeUseCase.MazeGeneratorOutputBoundary;
import usecases.generateMazeUseCase.MazeGeneratorResponseModel;
import usecases.generateMazeUseCase.MazeRepresentation;

/**
 * Presenter which builds a maze representation model from the maze representation such that it is able
 * to present this to the user. Throws a MazeGenerationFailed if there is invalid input.
 */
public class MazePresenter implements MazeGeneratorOutputBoundary {
    @Override
    public MazeGeneratorResponseModel prepareSuccessView(MazeRepresentation mazeRepresentation) {
        StringBuilder mazeRep = new StringBuilder();

        for (int[] row : mazeRepresentation.getMaze()) {
            for (int cell : row) {
                if (cell == 1) {
                    mazeRep.append("# "); // Wall
                } else if (cell == 2) {
                    mazeRep.append("S "); // Start
                } else if (cell == 3) {
                    mazeRep.append("E "); // End
                } else {
                    mazeRep.append("  "); // Path
                }
            }
            mazeRep.append("\n");
        }

        return new MazeGeneratorResponseModel(mazeRep.toString());
    }

    @Override
    public MazeGeneratorResponseModel prepareFailView(String error) throws MazeGenerationFailed {
        throw new MazeGenerationFailed(error);
    }
}
