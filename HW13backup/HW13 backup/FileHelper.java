//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
        File file = new File(path);
        System.out.println(file.getName());
        printLsHelper(path, 1);
    }
    /**
     * printLsHelper, help to print the child file contents
     * @param path             [file path]
     * @param indentationLevel [indentation level]
     */
    private static void printLsHelper(String path, int indentationLevel) {
        File file = new File(path);
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
     * @throws CatException          [not file type exception]
     * @throws FileNotFoundException [file not found exception]
     */
    public static void printCat(String path) throws CatException, FileNotFoundException {
        File file = new File(path);
        if (!(file.isFile()) || file.isDirectory()) {
            throw new CatException("Path invalid.", path);
        } else {
            Scanner sc = new Scanner(file);
            int lineNum = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(lineNum++ + ": " + line);
            }
        }
    }
}
