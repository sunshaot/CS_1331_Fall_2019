import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Testing class for StockTracker
 * @author 1331 TAs
 * @version 1.0
 */
public class Tester {

    /**
     * Runs sample tests
     * @param args unused parameter
     */
    public static void main(String[] args) {

        // number of iterations to test
        int iterations = 10;

        // Create new tracker with a cutoff of 10 (unrelated to the number of iterations)
        // getMarket is a helper method that we created to give you an instance of Market
        StockTracker tracker = new StockTracker(getMarket(iterations), Stock.values(), 10);
        // Start the event driven simulation
        startSimulation(tracker);
    }

    /* ==================================================================
     * ALL code beneath here may be confusing feel free to ignore
     * =================================================================
     */

    /**
     * Return a Market that can be tested with
     * @param iterations How long to simulate for
     * @return A market that can be tested with
     */
    private static Market getMarket(int iterations) {
        return new SampleMarket(iterations);
    }

    /**
     * Start the event driven simulation
     * @param tracker Which StockTracker to use
     */
    private static void startSimulation(StockTracker tracker) {
        Market market = tracker.getMarket();

        // This is gross but I don't want to make this more confusing.
        if (!(market instanceof SampleMarket)) {
            throw new IllegalArgumentException("Unable to simulate with this tracker and market.");
        }
        new Thread((SampleMarket) tracker.getMarket()).start();
    }

    /**
     * Sample implementation of a Market. Don't worry too much about what's
     * going on inside here and remember that the Market used while grading
     * may be different.
     */
    private static class SampleMarket implements Market, Runnable {
        private static final PseudoRandom RANDOM = new PseudoRandom(1331);

        private Map<Stock, List<Consumer<Integer>>> handlers = new EnumMap<>(Stock.class);
        private Map<Stock, Integer> values = new HashMap<>();
        private int iterations;

        private static class PseudoRandom {
            private int next;
            public PseudoRandom(int seed) {
                next = seed;
            }
            private int next() {
                next = next * 1103515245 + 12345;
                return next / 65535 % 32768;
            }
            public int nextInt(int bound) {
                return Math.abs(next()) % bound;
            }
            public boolean nextBoolean() {
                return next() % 2 == 0;
            }
        }

        /**
         * Creates a SampleMarket
         * @param iterations how long to simulate
         */
        public SampleMarket(int iterations) {
            this.iterations = iterations;
        }

        @Override
        public void registerHandler(Stock stock, Consumer<Integer> handler) {
            handlers.putIfAbsent(stock, new ArrayList<>());
            handlers.get(stock).add(handler);
            values.putIfAbsent(stock, stock.getInitialValue());
        }

        @Override
        public void run() {
            while (iterations != 0) {
                iterations--;

                for (Stock s: handlers.keySet()) {

                    if (RANDOM.nextBoolean()) {

                        // Randomly change price
                        int newValue = values.get(s);
                        newValue += RANDOM.nextInt(20) - 10;
                        if (newValue < 0) {
                            newValue = 0;
                        }
                        values.put(s, newValue);

                        for (Consumer<Integer> handler: handlers.get(s)) {
                            handler.accept(newValue);
                        }
                    }
                }

                try {
                    // Simulate asynchronous code
                    Thread.sleep(RANDOM.nextInt(1500));
                } catch (InterruptedException e) {
                    System.out.println("An unexpected exception has occurred. Come to Office Hours if this persists.");
                    e.printStackTrace();
                }
            }
        }
    }
}
