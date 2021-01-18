//I worked on the homework assignment alone, using only course materials.
/**
 * This file contains the Android class.  You will need to implement many
 * methods, variables, and a constructor in this class.
 *
 * Since this class is actually a subclass of Human, its rank and name actually exist as instance variables in the
 * superclass!  No instance variables need be declared in this class.
 *
 * It should also have a constructor that takes in String name and int rank.  Rather than assigning these values
 * to instance variables, since we don't have access to them, use the `super` keyword to call the superclass
 * constructor, the constructor in the Human class, with the appropriate parameters.
 *
 * It should also have a second constructor that takes no arguments.  This constructor should use constructor chaining
 * to call the other one with arguments "Data" as the name and 2 as the rank.
 *
 * You should also implement the overridden method boolean isPrime(int num) from the Logic interface.
 * You can assume num >= 1.
 *      It should work as follows:
 *         - If num is 1, return false
 *         - If num is 2 or 3, return true
 *         - Otherwise, obtain the square root of num.  If this value is not a whole number, call Math.ceil() on it.
 *           Then, cast it to an integer.  Let this value be called "sqrt". Return false if any of the numbers between 2
 *           and sqrt, inclusive, divide evenly into num.  That is, if any of num % 2, num % 3, ..., num % sqrt are 0.
 *           Otherwise, return true.
 *
 * You should create an additional overloaded method boolean isPrime(int num1, int num2, int num3)
 * This should return true only if num1, num2, and num3 are *all* prime according to the isPrime() method in this class.
 * Otherwise, return false.
 *
 * Additionally, the Android class will implement 1 overridden method from java.lang.Object.
 *  For the overridden method public String toString(), what should be returned is the String
 *  "Android [superString]", where superString is the value returned by calling toString() from the superclass.
 *  You will need a special keyword in order to reference the superclass' toString() method.
 *
 * @author Shaotong Sun
 * @version 1.0
 */
public class Android extends Human implements Logic {
    /**
     * Android constructor with name and rank
     * @param  name name of the Android
     * @param  rank rank of the Android
     */
    public Android(String name, int rank) {
        super(name, rank);
    }
    /**
     * Android constructor without any arguments
     */
    public Android() {
        this("Data", 2);
    }
    /**
     * determine whether the number is prime
     * @param  num number for test
     * @return     boolean value whether is prime
     */
    @Override
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        } else {
            int sqrt = (int) (Math.ceil(Math.sqrt(num)));
            for (int i = 2; i < sqrt; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * determine whether these three numbers are prime
     * @param  num1 first number
     * @param  num2 second number
     * @param  num3 third number
     * @return      boolean value
     */
    public boolean isPrime(int num1, int num2, int num3) {
        return isPrime(num1) && isPrime(num2) && isPrime(num3);
    }
    /**
     * toString method
     * @return description of Android
     */
    @Override
    public String toString() {
        return "Android " + super.toString();
    }
}
