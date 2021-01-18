/**
 * This class is simply provided as a helper driver class for testing your code.
 * No need to submit it.
 *
 * @author CS 1331 TAs
 * @version 1.0
 */
public class Enterprise {

    /**
     * Some very basic tests are provided here.  These are in no way comprehensive; ensure your code
     * fully meets the specifications laid out at the top of the files as well as in the README.
     *
     * Don't forget JavaDocs on methods you implement and to fill in your name at the top of the file!
     *
     * Main method; contains the starting point for the execution of a Java application
     * @param args command-line arguments with which the program can be run
     */
    public static void main(String[] args) {
        Officer[] crew = new Officer[9];
        crew[0] = new Human("Kirk", 4);
        crew[1] = new Human("Picard", 4);
        crew[2] = new Human("Forrest", 5);
        crew[3] = new Android("Data", 2);
        crew[4] = new Android();
        crew[5] = new Vulcan("Spock", 3);
        crew[6] = new Vulcan("T'Pol", 3);
        crew[7] = new Human("Picard", 4);
        crew[8] = new Human("Daniels", -1);

        Human officer1 = new Human("Kirk", 4);
        Human officer2 = new Human("Kirk", 5);
        Vulcan officer3 = new Vulcan("Kirk", 4);
        Vulcan officer4 = new Vulcan("Kirk", 5);

        System.out.println(crew[0].equals(officer1));
        System.out.println(crew[0].equals(officer2));
        System.out.println(crew[0].equals(officer3));
        System.out.println(crew[0].equals(officer4));
        /*
         * The output of the following toString() method tests should be:
         * Captain Kirk
         * Captain Picard
         * Admiral Forrest
         * Android Lieutenant Commander Data
         * Android Lieutenant Commander Data
         * Commander Spock from Vulcan
         * Commander T'Pol from Vulcan
         * Captain Picard
         * Unranked Daniels
         */
        for (Officer officer: crew) {
            System.out.println(officer);
        }

        System.out.println();
        System.out.println(crew[5].equals(crew[6])); // Should be 'false'
        System.out.println(crew[3].equals(crew[4])); // Should be 'true'
        System.out.println(crew[0].equals(crew[1])); // Should be 'false'
        System.out.println(crew[1].equals(crew[7])); // Should be 'true'
        System.out.println();
        Vulcan tPol = (Vulcan) crew[6];
        Android data  = (Android) crew[4];
        System.out.println(tPol.isPrime(50)); // Should be 'false'
        System.out.println(tPol.isPrime(667)); // Should be 'true'
        System.out.println(data.isPrime(667)); // Should be 'false'
        System.out.println(data.isPrime(3, 50, 7)); // Should be 'false'
    }

}