package userinterface.generateMazeUserInterface;

import interfaceadapters.generateMazeInterfaceAdapters.MazeGenerationFailed;
import interfaceadapters.generateMazeInterfaceAdapters.MazeGeneratorController;
import interfaceadapters.generateMazeInterfaceAdapters.MazePresenter;
import usecases.generateMazeUseCase.MazeGeneratorResponseModel;

import java.util.Scanner;

/**
 * Screen that handles the user input. This application is built using the terminal, thus the screen displays
 * inputs for rows and columns and calls the appropriate controller to run the use case. There are two constructors,
 * one is when you want to input your own presenter (a presenter with a *specific* generator), having a specific
 * generator requires you to create a presenter in the Main.java file. Thus you could plug in your screen with that
 * specific instance of the presenter.
 */
public class MazeGeneratorScreen {
    private final MazeGeneratorController mazeGeneratorController;

    public MazeGeneratorScreen(MazePresenter presenter) {
        this.mazeGeneratorController = presenter.getGeneratorController();
    }

    public MazeGeneratorScreen() {
        MazePresenter presenter = new MazePresenter();
        this.mazeGeneratorController = presenter.getGeneratorController();
    }

    public void renderScreen() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int rows = input.nextInt();
        System.out.println("Enter columns: ");
        int columns = input.nextInt();
        input.close();

        try {
            MazeGeneratorResponseModel responseModel = mazeGeneratorController.generateMaze(rows, columns);

            System.out.println("\nMaze Generated:");
            System.out.println(responseModel.getMaze());
        } catch(MazeGenerationFailed e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
