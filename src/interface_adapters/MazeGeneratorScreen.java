package interface_adapters;

import java.util.Scanner;
public class MazeGeneratorScreen {

    private final MazeGeneratorController mazeGeneratorController;

    public MazeGeneratorScreen(MazeGeneratorController controller) {
        this.mazeGeneratorController = controller;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int rows = input.nextInt();
        System.out.println("Enter columns: ");
        int columns = input.nextInt();
        input.close();

        try {
            System.out.println("\nGenerated Maze");
            System.out.println(mazeGeneratorController.generateMaze(rows, columns).getMaze());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
