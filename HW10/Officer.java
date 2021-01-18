//I worked on the homework assignment alone, using only course materials.
/**
 * This file contains the Officer interface.  It contains 2 methods, getName() and
 * getRank(), which should be implemented in its subclasses.
 *
 * Additionally, capitalizeEachWord() is provided to you as a utility method to be used
 * in your implementation of rankString().  Do not modify this method.
 *
 * You need to complete the method rankString(), which should only have an implementation
 * in this file.  Its behavior is described below.
 *
 * @author Shaotong Sun
 * @version 1.0
 */
public interface Officer {
    /**
     * @return the String name of this particular Officer object
     */
    String getName();
    /**
     * @return the Rank rank of this particular Officer object (Rank is an enum implemented in Rank.java)
     */
    Rank getRank();

    /**
     * @return "Unranked" if getRank() is null, otherwise
     *         the result of calling capitalizeEachWord on the String representation
     *         of getRank()
     */
    default String rankString() {
        if (getRank() == null) {
            return "Unranked";
        } else {
            String str = getRank().name();
            return capitalizeEachWord(str);
        }
    }

    /**
     * Returns a underscore separated String of all capital letters as a space separated
     * string of capitalized words separated by spaces.
     * @param rank the String value the operations are acting on
     * @return the String rank modified as described above
     */
    private String capitalizeEachWord(String rank) {
        String[] words = rank.split("_");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1) + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

}
