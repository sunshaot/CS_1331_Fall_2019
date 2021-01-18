//I worked on the homework assignment alone, using only course materials.
/**
 * This file contains the Vulcan class.  You will need to implement many
 * methods, variables, and a constructor in this class.
 *
 * This class should have exactly 2 instance variables, a String name, and a Rank rank.
 * name should never be able to be changed once initialized in the constructor.  What keyword would allow us to do this?
 *
 * It should also have exactly one constructor, which takes in String name and int rank.
 * It should assign name to its corresponding instance variable.
 * However, we must get the Rank enum value corresponding to int rank.  A rank = 0 corresponds to Rank.ENSIGN,
 * rank = 1 to Rank.LIEUTENANT, and so on.  Note that we can only obtain a valid rank if 0 <= rank <= 5.
 * So, if `int rank` is negative or greater than 5, initialize `Rank rank` to null.  Otherwise, obtain the corresponding
 * enum rank using Rank.values().
 *
 * It should also properly implement the getName() and getRank() methods from Officer.
 * Each of these should return its corresponding local instance variable.
 *
 * Additionally, you should implement getHomePlanet() from the abstract class Alien.  This will be an
 * overridden method.  It should simply return the String "Vulcan".
 *
 * You should also implement the overridden method boolean isPrime(int num) from the Logic interface.
 * You can assume num >= 1.
 * Note that one very notable difference exists between the implementation of this method and that of Android!!!
 *      It should work as follows:
 *         - If num is 1, return false
 *         - If num is 2 or 3, return true
 *         - Otherwise, obtain the square root of num.  If this value is not a whole number, call Math.ceil() on it.
 *           Then, cast it to an integer. Let this value be called "sqrt".
 *         - Vulcans can only do mental math to a certain extent, so if sqrt > 20, change it to 20 instead.
 *         - Return false if any of the numbers between 2 and sqrt, inclusive, divide evenly into num.
 *           That is, if any of num % 2, num % 3, ..., num % sqrt are 0. Otherwise, return true.
 *
 * You should create an additional overloaded method boolean isPrime(int num1, int num2)
 * This should return true only if num1 and num2 are prime according to the isPrime() method in this class.
 * Otherwise, return false.
 *
 * Additionally, the Vulcan class will implement 2 overridden methods from java.lang.Object.
 *  For the overridden method public String toString(), what should be returned is the String
 *  "[rankString] [name] from [homePlanet]", where rankString is the value returned by the interface method rankString()
 *  from Officer, name is the local instance variable name, and homePlanet is the value returned by
 *  getHomePlanet().
 *
 * For the overridden method public boolean equals(Object other), follow the following formula:
 *        First, check if other == this.  If it does, return true.
 *        Next, check if other instanceof Vulcan is false.  If it is false, return false.
 *        Otherwise, cast other to a Vulcan, and return true if its name and rank are equal
 *        to the name and rank of the current object.
 *
 * @author Shaotong Sun
 * @version 1.0
 */
public class Vulcan extends Alien implements Officer, Logic {
    private final String name;
    private Rank rank;
    /**
     * Vulcan constructor
     * @param  name name of Vulcan
     * @param  rank rank of Vulcan
     */
    public Vulcan(String name, int rank) {
        super();
        this.name = name;
        if (rank <= 5 && rank >= 0) {
            Rank[] rankArray = Rank.values();
            this.rank = rankArray[rank];
        } else {
            this.rank = null;
        }
    }
    /**
     * get the name of Vulcan
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * get the rank of Vulcan
     * @return rank
     */
    @Override
    public Rank getRank() {
        return rank;
    }
    /**
     * get the name of the home Planet
     * @return name of the home planet
     */
    @Override
    public String getHomePlanet() {
        return "Vulcan";
    }
    /**
     * determine whether number is prime
     * @param  num number
     * @return     boolean value
     */
    @Override
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        } else {
            int sqrt = (int) (Math.ceil(Math.sqrt(num)));
            if (sqrt >= 20) {
                sqrt = 20;
            }
            for (int i = 2; i < sqrt; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * determine whether these two numbers are prime
     * @param  num1 first number
     * @param  num2 second number
     * @return      boolean value
     */
    public boolean isPrime(int num1, int num2) {
        return isPrime(num1) && isPrime(num2);
    }
    /**
     * toString method
     * @return description of Vulcan
     */
    @Override
    public String toString() {
        return rankString() + " " + name + " from " + getHomePlanet();
    }
    /**
     * determine whether two objects are equal
     * @param  o another object
     * @return   boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vulcan)) {
            return false;
        }
        Vulcan other = (Vulcan) o;
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
