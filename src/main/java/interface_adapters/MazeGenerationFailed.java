package interface_adapters;

public class MazeGenerationFailed extends RuntimeException {
    public MazeGenerationFailed(String error) {
        super(error);
    }
}
