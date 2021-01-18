//I worked on the homework assignment alone, using only course materials.
import java.io.FileNotFoundException;
import java.io.File;
import java.nio.file.Paths;
/**
 * This class represents tester
 * @author Shaotong Sun
 * @version 13.0.1
 */
public class Tester {
    /**
     * main method with command line argument
     * @param  args                  [command line arguments]
     * @throws FileNotFoundException [file not found exception]
     * @throws CatException          [is not file type exception]
     */
    public static void main(String[] args) throws CatException, FileNotFoundException {
        String path = Paths.get(args[0]).normalize().toAbsolutePath().toString();
        File file = new File(path);
        FileHelper.printLs(file.getParent());
        FileHelper.printCat(args[0]);
    }
}
