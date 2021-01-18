//I worked on the homework assignment alone, using only course materials.
import java.io.File;
/**
 * This class represents CatException exception.
 * @author Shaotong Sun
 * @version 13.0.1
 */
public class CatException extends Exception {
    private final String problemFile;
    /**
     * CatException constructor
     * @param  message     [exception message]
     * @param  problemFile [file path]
     */
    public CatException(String message, String problemFile) {
        super(message);
        this.problemFile = problemFile;
    }
    /**
     * override getMessage method
     * @return [exception message]
     */
    @Override
    public String getMessage() {
        File file = new File(problemFile);
        String path = file.getAbsolutePath();
        return super.getMessage() + " Problem with file " + path + "!";
    }
}
