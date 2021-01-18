/**
 * I worked on the homework assignment alone, using only course materials.
 * Q1:
 * What are the pros and cons of using named inner classes, anonymous inner classes, and lambda expressions?
 *  Pros:
 *      lambda expressions: allows developers to define and implement a functional interface where it's needed
 *               lambda expressions can greatly simplified the code
 *      named inner class: can access all the members (data members and methods) of outer class
 *                            the user can pass arguments to the constructor that stores them in instance variables
 *                            that run uses
 *      anonymous inner class: users are able to create additional classes with less number of keystrokes.
 *  Cons:
 *      lambda expressions: ability to reuse this code is muted
 *      named inner class: increases the total number of classes being used by the application
 *                     get limited support of IDE
 *      anonymous inner class: can't have explicit constructors. People can't pass them any parameters when they
 *                         are instantiated.
 * Q2:
 * Why syntactically can we use a lambda expression when we are registering an event handler for the market?
 *        There is only one parameter in that handler, and lambda expressions can be used to implement functional
 *        interfaces. In this code, the lambda expression implements Consumer Functional Interface.
 * Q3:
 * Why would we decide to use event driven programming to access the stock market?
 *        Because the value of the stock changes over time, we need to handle it when the stock's value changes.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/**
 * This class represents stock tracker
 * @author Shaotong Sun
 * @version 14.0.1
 */
public class StockTracker {
    private List<Stock> trackedStocks;
    private int cutoff;
    private Market market;
    /**
     * StockTracker constructor, takes in market stocks list and cutoff
     * @param  market [market]
     * @param  stocks [stock list]
     * @param  cutoff [cutoff]
     */
    public StockTracker(Market market, Stock[] stocks, int cutoff) {
        trackedStocks = new ArrayList<Stock>();
        trackedStocks.addAll(Arrays.asList(stocks));
        this.market = market;
        this.cutoff = cutoff;
        for (Stock s: trackedStocks) {
            registerBuyTracker(s);
            registerHoldTracker(s);
            registerSellTracker(s);
        }
    }
    /**
     * get the deep copy trackedStocks
     * @return [the deep copy of the trackedStocks]
     */
    public List<Stock> getTrackedStocks() {
        List<Stock> deepCopyTrackedStocks = new ArrayList<>();
        deepCopyTrackedStocks.addAll(trackedStocks);
        System.out.println(trackedStocks == deepCopyTrackedStocks);
        for (int i = 0; i < trackedStocks.size(); i++) {
            System.out.println(deepCopyTrackedStocks.get(i) == trackedStocks.get(i));
        }
        return deepCopyTrackedStocks;
    }
    /**
     * get the value of cutoff
     * @return [cutoff value]
     */
    public int getCutoff() {
        return cutoff;
    }
    /**
     * get the value of market
     * @return [value of market]
     */
    public Market getMarket() {
        return market;
    }
    /**
     * register hold tracker method
     * @param stock [stock list]
     */
    private void registerHoldTracker(Stock stock) {
        Consumer handler = new ConsumerHandler(stock);
        market.registerHandler(stock, handler);
    }
    /**
     * This class represents ConsumerHandler
     */
    class ConsumerHandler implements Consumer<Integer> {
        private Stock stock;
        /**
         * ConsumerHandler constructor
         * @param  stock [stock list]
         */
        public ConsumerHandler(Stock stock) {
            this.stock = stock;
        }
        /**
         * accept method
         * @param integer [integer]
         */
        @Override
        public void accept(Integer integer) {
            if (integer >= stock.getInitialValue() && integer <= (stock.getInitialValue() + cutoff)) {
                System.out.println(stock.getCompanyName() + " is valued at $" + integer
                        + ". Hold on to what you have.");
            }
        }
    }
    /**
     * register buy tracker method
     * @param stock [stock list]
     */
    private void registerBuyTracker(Stock stock) {
        Consumer handler = new Consumer<Integer>() {
            /**
             * accept method
             * @param integer [integer]
             */
            @Override
            public void accept(Integer integer) {
                if (integer < (stock.getInitialValue() - cutoff)) {
                    System.out.println(stock.getCompanyName() + " just dropped to $" + integer
                            + ". Buy now!");
                }
            }

        };
        market.registerHandler(stock, handler);
    }
    /**
     * register sell tracker method
     * @param stock [stock list]
     */
    private void registerSellTracker(Stock stock) {
        Consumer handler = (Consumer<Integer>) integer -> {
            if (integer > (stock.getInitialValue() + cutoff)) {
                System.out.println(stock.getCompanyName() + " just rose to $" + integer
                        + ". Sell now!");
            }
        };
        market.registerHandler(stock, handler);
    }
}
