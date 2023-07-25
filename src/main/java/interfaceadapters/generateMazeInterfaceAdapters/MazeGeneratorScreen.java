package interfaceadapters.generateMazeInterfaceAdapters;

import usecases.generateMazeUseCase.MazeGeneratorResponseModel;

import java.sql.SQLOutput;
import java.util.Scanner;
public class MazeGeneratorScreen {

    private final MazeGeneratorController mazeGeneratorController;

    public MazeGeneratorScreen(MazeGeneratorController controller) {
        this.mazeGeneratorController = controller;
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
