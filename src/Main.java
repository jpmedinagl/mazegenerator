import entities.MazeFacade;

public class Main {
    public static void main(String[] args) {
        int rows = 20;
        int columns = 20;

        MazeFacade manager = new MazeFacade(rows, columns);
        manager.generateMaze();
        System.out.println(manager.printMaze());
    }
}