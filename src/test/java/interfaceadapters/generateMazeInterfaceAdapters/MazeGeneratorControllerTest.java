package interface_adapters;

import entities.MazeFactory;
import generate_maze_use_case.MazeGeneratorInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MazeGeneratorControllerTest {
    private MazeGeneratorController mazeGeneratorController;

    @BeforeEach
    public void setup() {
        MazeFactory mazeManager = new MazeFactory();
        MazePresenter mazePresenter = new MazePresenter();
        MazeGeneratorInteractor mazeGeneratorInteractor = new MazeGeneratorInteractor(mazePresenter, mazeManager);
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
