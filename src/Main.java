import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int rows = 20;
        int columns = 20;

        Maze maze = new Maze(rows, columns);
        maze.generateMaze();

        maze.printMaze();
    }
}