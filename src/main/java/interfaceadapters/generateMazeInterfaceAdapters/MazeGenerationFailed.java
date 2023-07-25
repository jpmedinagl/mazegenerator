package interfaceadapters.generateMazeInterfaceAdapters;

/**
 * Error class that is thrown when something goes wrong with the maze generation.
 */
public class MazeGenerationFailed extends RuntimeException {

    public MazeGenerationFailed(String error) {
        super(error);
    }
}
