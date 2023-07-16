package interface_adapters;

import generate_maze_use_case.MazeGeneratorOutputBoundary;
import generate_maze_use_case.MazeGeneratorResponseModel;
import generate_maze_use_case.MazeRepresentation;

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
    public MazeGeneratorResponseModel prepareFailView(String error) {
        throw new RuntimeException(error);
    }
}
