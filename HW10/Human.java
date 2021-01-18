//I worked on the homework assignment alone, using only course materials.
/**
 * This file contains the Human class.  You will need to implement many
 * methods, variables, and a constructor in this class.
 *
 * This class should have exactly 2 instance variables, a String name, and an int rank.
 * name should never be able to be changed once initialized in the constructor.  What keyword would allow us to do this?
 *
 * It should also have exactly one constructor, which takes in String name and int rank.
 * It should assign name to its corresponding instance variable.
 * However, we must get the Rank enum value corresponding to int rank.  A rank = 0 corresponds to Rank.ENSIGN,
 * rank = 1 to Rank.LIEUTENANT, and so on.  Note that we can only obtain a valid rank if 0 <= rank <= 5.
 * So, if `int rank` is negative or greater than 5, initialize `Rank rank` to null.
 * Otherwise, obtain the corresponding enum rank using Rank.values().
 *
 * It should also properly implement the getName() and getRank() methods from Officer.
 * Each of these should return its corresponding local instance variable.
 *
 * Additionally, the Human class will implement 2 overridden methods from java.lang.Object.
 * For the overridden method public String toString(), what should be returned is the String
 * "[rankString] [name]", where rankString is the value returned by the interface method rankString()
 * from Officer and where name is the local instance variable name.
 *
 * For the overridden method public boolean equals(Object other), follow the following formula:
 *        First, check if other == this.  If it does, return true.
 *        Next, check if other instanceof Human is false.  If it is false, return false.
 *        Otherwise, cast other to a Human, and return true if its name and rank are equal
 *        to the name and rank of the current object.
 *
 * @author Shaotong Sun
 * @version 1.0
 */
public class Human implements Officer {
    private final String name;
    private Rank rank;
    /**
     * Human constructor with name and rank
     * @param  name name if human
     * @param  rank rank of human
     */
    public Human(String name, int rank) {
        this.name = name;
        if (rank <= 5 && rank >= 0) {
            Rank[] rankArray = Rank.values();
            this.rank = rankArray[rank];
        } else {
            this.rank = null;
        }
    }
    /**
     * get the name of human
     * @return name of human
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * get the rank of human
     * @return rank of human
     */
    @Override
    public Rank getRank() {
        return rank;
    }
    /**
     * toString method
     * @return description of human
     */
    @Override
    public String toString() {
        return rankString() + " " + name;
    }
    /**
     * determine whether two objects are equal
     * @param  o other object
     * @return   boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Human)) {
            return false;
        }
        Human other = (Human) o;
        return this.name.equals(other.name) && this.rank == other.rank;
    }
    /**
     * hashCode method
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + rank.hashCode();
        return result;
    }
}
