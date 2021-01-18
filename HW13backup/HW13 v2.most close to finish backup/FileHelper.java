//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.util.Scanner;
import java.nio.file.Paths;
/**
 * This class represents FileHelper
 * @author Shaotong Sun
 * @version 13.0.1
 */
public class FileHelper {
    /**
     * printLs method, print the file contents
     * @param path [file path]
     */
    public static void printLs(String path) {
        String newpath = Paths.get(path).normalize().toAbsolutePath().toString();
        File file = new File(newpath);
        System.out.println(file.getName());
        printLsHelper(newpath, 1);
    }
    /**
     * printLsHelper, help to print the child file contents
     * @param path             [file path]
     * @param indentationLevel [indentation level]
     */
    private static void printLsHelper(String path, int indentationLevel) {
        String newpath = Paths.get(path).normalize().toAbsolutePath().toString();
        File file = new File(newpath);
        File[] fileList = file.listFiles();
        for (File f: fileList) {
            System.out.print("    ".repeat(indentationLevel));
            if (f.isFile()) {
                System.out.println(f.getName());
            } else if (f.isDirectory()) {
                System.out.println(f.getName());
                printLsHelper(f.getPath(), indentationLevel + 1);
            }
        }

    }
    /**
     * [printCat method, print out the file
     * @param  path                  [file path]
     * @throws CatException          [not file exception]
     */
    public static void printCat(String path) throws CatException {
        String newpath = Paths.get(path).normalize().toAbsolutePath().toString();
        try {
            File file = new File(newpath);
            Scanner sc = new Scanner(file);
            int lineNum = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(lineNum++ + ": " + line);
            }
        } catch (Exception ex) {
            throw new CatException("Path invalid.", newpath);
        }
    }
}
