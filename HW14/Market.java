import java.util.function.Consumer;

/**
 * Represents a market for stocks.
 * @author CS 1331 TAs
 * @version 1.0
 */
public interface Market {
    /**
     * Register an event handler that gets called whenever a stock value gets
     * updated on the market.
     * @param stock        Stock ticker to watch
     * @param eventHandler Handler that will be called when the value of the
     *                     stock gets updated. Called with the new value of the
     *                     stock.
     */
    void registerHandler(Stock stock, Consumer<Integer> eventHandler);
}
