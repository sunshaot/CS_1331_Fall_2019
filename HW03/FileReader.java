import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//I worked on the homework assignment alone, using only course materials.
/**
 * Represents the program that can read the command file.
 *
 * @author Shaotong Sun
 * @version 3.2
 *
 */
public class FileReader {
/**
 * For methods: allCaps(), power(), makeSubstring() test and debug
 * @param  args                  command-line arguments
 * @throws FileNotFoundException exception for file not found condition
 */
    public static void main(String[] args) throws FileNotFoundException {
        File commandsFile = new File(args[0]);
        Scanner sc = new Scanner(commandsFile);
        //read the file line by line
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //check allCaps command
            if (line.contains("allcaps")) {
                int strID = line.indexOf(" ") + 1;
                String strNeed = line.substring(strID);
                String strCap = allCaps(strNeed);
                System.out.println(strCap);
            //check power command
            } else if (line.contains("power")) {
                int baseID = line.indexOf(" ") + 1;
                int powerID = line.indexOf(" ", baseID) + 1;
                int base = Integer.parseInt(line.substring(
                    baseID, powerID - 1));
                int power = Integer.parseInt(line.substring(powerID));
                double powerResult = power(base, power);
                System.out.println(powerResult);
            //check maleSubstring command
            } else if (line.contains("substring")) {
                int strID = line.indexOf(" ") + 1;
                int index1ID = line.indexOf(" ", strID) + 1;
                int index2ID = line.indexOf(" ", index1ID) + 1;
                String str = line.substring(strID, index1ID - 1);
                int startIndex = Integer.parseInt(line.substring(
                    index1ID, index2ID - 1));
                int endIndex = Integer.parseInt(line.substring(index2ID));
                int strLastIndex = str.length() - 1;
                int substrLastIndex = endIndex - 1;
                String resultStr = makeSubstring(str, startIndex, endIndex);
                System.out.println(resultStr);
            }
        }
    }

    // place the three required static methods here

    /**
     * This method will convert the string to uppercase and return the string
     * @param  str string that will be converted to uppercase
     * @return     String with all capital letters
     */
    public static String allCaps(String str) {
        String capStr = str.toUpperCase();
        return capStr;
    }

    /**
     * This method will return the power of two integers
     * @param  base  the base number
     * @param  power the power number
     * @return       the power result in double type
     */
    public static double power(int base, int power) {
        double result = Math.pow(base, power);
        return result;
    }

    /**
     * This method will return the substring of the string that we input
     * @param  str        the origional string
     * @param  startIndex the start index of the substring
     * @param  endIndex   the end index of the substring
     * @return            the substring tha from start index to end index
     *                        if either the start or end index out of bounds
     *                        return "Invalid command"
     */
    public static String makeSubstring(String str, int startIndex
        , int endIndex) {
        int strLastIndex = str.length() - 1;
        int subStrLastIndex = endIndex - 1;
        int subStrFirstIndex = startIndex;
        //check the whether index in boundary
        if (subStrLastIndex <= strLastIndex && subStrFirstIndex <= strLastIndex
            && subStrFirstIndex <= subStrLastIndex && subStrFirstIndex >= 0) {
            String subStr = str.substring(startIndex, endIndex);
            return subStr;
        } else {
            String errorI = "Invalid command";
            return errorI;
        }
    }

}
