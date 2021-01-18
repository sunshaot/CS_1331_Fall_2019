/**
 * This file contains the Logic interface.  It contains one method,
 * isPrime, whose logic is to be implemented by classes that use it.
 * @author CS 1331 TAs
 * @version 1.0
 */
public interface Logic {
    /**
     * Returns whether or not num is prime.
     *
     * Note that the implementation of this method will be different depending on the class!!!
     *
     * @param num the number we are are checking for primality
     * @return true if the number is prime, false if it is not
     */
    boolean isPrime(int num);
}
