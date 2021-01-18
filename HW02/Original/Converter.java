public class Converter {

    public static void main(String[] args) {
        // You can use this main method to test your other methods
        System.out.println("fahrenheitToCelsius: " + fahrenheitToCelsius(34));
        System.out.println("celsiusToFahrenheit: " + celsiusToFahrenheit(4));
        System.out.println("printFahrenheitConversionTable:");
        printFahrenheitConversionTable(32, 35);
        // Feel free to add your own tests!

    }

    /**
     * This method takes in a temperature in fahrenheit and should return that
     * temperature in celsius as a double.
     * @param temp the temperature to convert
     * @return the converted temperature as a double
     */
    public static double fahrenheitToCelsius(int temp) {

    }

    /**
     * This method takes in a temperature in celsius and should return that
     * temperature in fahrenheit as a double.
     * @param temp the temperature to convert
     * @return the converted temperature to convert
     */
    public static double celsiusToFahrenheit(int temp) {

    }

    /**
     * This method prints out a table of fahrenheit temperatures from the
     * specified lower bound (inclusive) to the specified
     * upper bound (inclusive) and that temperature converted to celsius.
     * Round to three decimal places.
     *
     * Ex) if we ran printFahrenheitConversionTable(32, 33) we should get what's
     * printed below. Please make sure to use this format exactly or you will
     * not get credit.
     *
     * Fahrenheit: 32 -> Celsius: 0.000
     * Fahrenheit: 33 -> Celsius: 0.556
     *
     * Note: This method should be completed using a FOR loop. You MAY NOT use
     * a while loop anywhere in this method. Doing so will yeild no credit
     * @param lower the lower bound of the fahrenheit temperatures.
     * @param upper the upper bound of the fahrenheit temperatues.
     */
    public static void printFahrenheitConversionTable(int lower, int upper) {

    }

    /**
     * This method prints out a table of celsius temperatures from the
     * specified lower bound (inclusive) to the specified
     * upper bound (inclusive) and that temperature converted to Fahrenheit.
     * Round to three decimal places.
     *
     * Ex) if we ran printCelsiusConversionTable(32, 33) we should get what's
     * printed below. Please make sure to use this format exactly or you will
     * not get credit.
     *
     * Celsius: 32 -> Fahrenheit: 89.600
     * Celsius: 33 -> Fahrenheit: 91.400
     *
     * Note: This method should be completed using a WHILE loop. You MAY NOT use
     * a for loop anywhere in this method. Doing so will yeild no credit.
     * @param lower - the lower bound of the celsius temperatures
     * @param upper - the upper bound of the celsius temperatures.
     **/
    public static void printCelsiusConversionTable(int lower, int upper) {

    }

    /**
     * This method takes in two temperatures, the first in celsius and the second
     * in fahrenheit, it should return true if the first temperature is warmer
     * than the second.
     *
     * Note:Do NOT use a ternary expression. Doing so will yeild no credit.
     * @param celsius the first temperature in degrees celsius
     * @param fahrenheit the second temperature in degrees fahrenheit
     * @return true iff the first temperature is bigger.
     */
    public static boolean celsiusWarmer(int celsius, int fahrenheit) {

    }

    /**
     * This method takes in two temperatures, the first in fahrenheit and the
     * second in celsius, it should return true if the first temperature is
     * warmer than the second.
     *
     * Note: you should use a ternary expression to complete this method. Do NOT
     * use an if statement. Doing so will yeild no credit.
     * @param fahrenheit the first temperature in degrees fahrenheit
     * @param celsius the second temperature in degrees celsius
     * @return true iff the first temperature is bigger.
     */
    public static boolean fahrenheitWarmer(int fahrenheit, int celsius) {

    }
}
