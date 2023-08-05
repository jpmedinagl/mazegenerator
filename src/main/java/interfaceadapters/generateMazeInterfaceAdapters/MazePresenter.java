package interfaceadapters.generateMazeInterfaceAdapters;

import entities.MazeFactory;
import usecases.generateMazeUseCase.*;

/**
 * Presenter which builds a maze representation model from the maze representation such that it is able
 * to present this to the user. Throws a MazeGenerationFailed if there is invalid input. There are two constructors,
 * one that has a default Maze Generator (DFSGenerator), and another that builds a presenter from a specified generator.
 */
public class MazePresenter implements MazeGeneratorOutputBoundary {
    private final MazeGeneratorController generatorController;

    public MazePresenter() {
        this(new DFSGenerator());
    }

    public MazePresenter(Generator generator) {
        MazeFactory mazeFactory = new MazeFactory();
        MazeGeneratorInteractor generatorInteractor = new MazeGeneratorInteractor(this, mazeFactory, generator);
        generatorController = new MazeGeneratorController(generatorInteractor);
    }

    public MazeGeneratorController getGeneratorController() {
        return this.generatorController;
    }

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
