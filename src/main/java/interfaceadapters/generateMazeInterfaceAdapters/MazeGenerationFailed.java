package interfaceadapters.generateMazeInterfaceAdapters;

public class MazeGenerationFailed extends RuntimeException {
    public MazeGenerationFailed(String error) {
        super(error);
    }
}
