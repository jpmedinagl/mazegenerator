import entities.MazeFactory;
import usecases.generateMazeUseCase.MazeGeneratorInteractor;
import interfaceadapters.generateMazeInterfaceAdapters.MazeGeneratorController;
import interfaceadapters.generateMazeInterfaceAdapters.MazeGeneratorScreen;
import interfaceadapters.generateMazeInterfaceAdapters.MazePresenter;

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