package interfaceadapters.generateMazeInterfaceAdapters;

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
            System.out.println(mazeGeneratorController.generateMaze(rows, columns).getMaze());
        } catch(MazeGenerationFailed e) {
            System.out.println(e.getMessage());
        }
    }
}
