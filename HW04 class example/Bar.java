//I worked on the homework assignment alone, using only course materials.
/**
 * This class represents a Bar object
 * @author Shaotong Sun
 * @version 1.0
 */
public class Bar {
    /**
     * This is for the Bar test
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Bar bar = new Bar("milk", 4, 4);
        bar.drawBar();
    }

    private String chocolateType;

    private int barLength;

    private int barWidth;
    /**
     * Creates a chocolate bar
     */
    public Bar() {
    }
    /**
     * This method calculates the Perimeter value (length + width) * 2 and
     * returns the Perimeter value back to user.
     * @return the Perimeter value
     */
    public int getPerimeter() {
        return (barLength + barWidth) * 2;
    }
    /**
     * This method calculates the Area value (length * width) and returns the
     * Area value back to user.
     * @return the Area value
     */
    public int getArea() {
        return barLength * barWidth;
    }
    /**
     * This method tells the user whether the chocolate bar is square or not
     * if it is square it returns true otherwise returns false.
     * @return true or false
     */
    public boolean isSquare() {
        return (barLength == barWidth);
    }
    /**
     * This method calculates the Cost of making chocolate bar.
     * @param  chocolateCost chocolate cost
     * @param  trimCost      trim cost
     * @return               total cost
     */
    public double calculateCost(double chocolateCost, double trimCost) {
        return getArea() * chocolateCost + getPerimeter() * trimCost;
    }
    /**
     * This method shows the details of the chocolate, the type, length and
     * width.
     * @return String that show the detail of the chocolate
     */
    public String getDetails() {
        if (isSquare()) {
            return "Square " + getArea() + " piece bar of " + chocolateType + " chocolate";
        } else {
            return barLength + " by " + barWidth + " bar of " + chocolateType + " chocolate";
        }
    }
    /**
     * This method prints out a text drawing og the chocolate bar with the
     * correct dimensions using the capitalized first letter of the
     * chocolateType.
     */
    public void drawBar() {
        String type = chocolateType.toUpperCase();
        char firstLetter = type.charAt(0);
        for (int count1 = 0; count1 < barLength; count1++) {
            for (int count2 = 0; count2 < barWidth; count2++) {
                System.out.print(firstLetter);
            }
            System.out.println("");
        }
    }
    /**
     * This method determines the value of chocolateType, barLength and
     * barWidth.
     * @param  chocolateType chocolate type
     * @param  barLength     bar length
     * @param  barWidth      bar width
     */
    public Bar(String chocolateType, int barLength, int barWidth) {
        this.chocolateType = chocolateType;
        this.barLength = barLength;
        this.barWidth = barWidth;
    }

}
