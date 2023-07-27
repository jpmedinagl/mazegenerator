package interfaceadapters.generateMazeInterfaceAdapters;

import entities.MazeFactory;
import usecases.generateMazeUseCase.DFSGenerator;
import usecases.generateMazeUseCase.MazeGeneratorInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MazeGeneratorControllerTest {
    private MazeGeneratorController mazeGeneratorController;

    @BeforeEach
    public void setup() {
        MazeFactory mazeManager = new MazeFactory();
        MazePresenter mazePresenter = new MazePresenter();
        DFSGenerator mazeGenerator = new DFSGenerator();
        MazeGeneratorInteractor mazeGeneratorInteractor = new MazeGeneratorInteractor(mazePresenter, mazeManager, mazeGenerator);
        mazeGeneratorController = new MazeGeneratorController(mazeGeneratorInteractor);
    }

    @Test
    public void testInvalidInputsNegativeNumbers() {
        // Invalid input (non-integer, 0, and then valid input)
        int rows = -5;
        int columns = -10;

        try {
            mazeGeneratorController.generateMaze(rows, columns);
            Assertions.fail();
        } catch (MazeGenerationFailed error) {
            Assertions.assertTrue(true);
        }
    }
}
