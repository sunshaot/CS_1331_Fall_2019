/**
 * Represents a stock on the market. Composed of
 * the 10 most traded stocks in America
 * @author 1331 TAs
 * @version 1.0
 */
public enum Stock {
    BAC("Bank of America", 300),
    AAPL("Apple", 400),
    GE("General Electric", 500),
    MSFT("Microsoft", 350),
    INTC("Intel", 250),
    CSCO("Cisco", 410),
    T("AT&T", 135),
    PFE("Pfizer", 600),
    F("Ford", 300),
    FB("Facebook", 700);

    private String name;
    private int initialValue;

    Stock(String name, int initialValue) {
        this.name = name;
        this.initialValue = initialValue;
    }

    /**
     * Getter for the common name of the company associated with
     * the stock ticker.
     * @return The company name
     */
    public String getCompanyName() {
        return name;
    }

    /**
     * Getter for the initial value of the stock
     * @return The initial value
     */
    public int getInitialValue() {
        return initialValue;
    }
}
