import entities.MazeFactory;
import generate_maze_use_case.MazeGeneratorInteractor;
import interface_adapters.MazeGeneratorController;
import interface_adapters.MazeGeneratorScreen;
import interface_adapters.MazePresenter;

public class Main {
    public static void main(String[] args) {
        MazeFactory mazeFactory = new MazeFactory();
        MazePresenter mazePresenter = new MazePresenter();
        MazeGeneratorInteractor generatorInteractor = new MazeGeneratorInteractor(mazePresenter, mazeFactory);
        MazeGeneratorController generatorController = new MazeGeneratorController(generatorInteractor);
        MazeGeneratorScreen generatorScreen = new MazeGeneratorScreen(generatorController);

        generatorScreen.renderScreen();
    }
}