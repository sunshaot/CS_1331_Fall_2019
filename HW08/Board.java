//I worked on the homework assignment alone, using only course materials.
/**
 * This class represents the board for cells
 * @author Shaotong Sun
 * @version 8.1.0
 */
public class Board {

    private Cell[][] universe;

    private int dimensionLength = 0;

    private int generationCount = 0;

    /**
     * Constructor to create a Board object
     * @param dimensionLength length to make universe Cell array, sets value of dimensionLength instance variable
     * @param seed Initial board state that contains non-zero values where there should be living cells
     */
    public Board(int dimensionLength, int[][] seed) {

        this.dimensionLength = dimensionLength;

        universe = new Cell[dimensionLength][dimensionLength];

        for (int x = 0; x < dimensionLength; x++) {

            for (int y = 0; y < dimensionLength; y++) {

                Cell cell = new Cell();

                universe[x][y] = cell;
            }

        }

        applySeed(seed);

    }

    /**
     * Initializing universe based on the seed
     * @param seed Initial board state that contains non-zero values where there should be living cells
     */
    private void applySeed(int[][] seed) {

        for (int x = 0; x < seed.length; x++) {

            for (int y = 0; y < seed[x].length; y++) {

                if (seed[x][y] != 0) {

                    universe[x][y].setAlive(true);

                }

            }

        }

    }

    /**
     * The program moves one "step" forward, and the status of the next generation of Cells is calculated and applied
     */
    public void tick() {

        generationCount++;

        Cell[][] newUniverse = new Cell[dimensionLength][dimensionLength];

        for (int x = 0; x < dimensionLength; x++) {

            for (int y = 0; y < dimensionLength; y++) {

                if (universe[x][y].getAlive()) {

                    if (getAliveNeighbors(universe, x, y) >= 2 && getAliveNeighbors(universe, x, y) <= 3) {

                        Cell cellT = new Cell(true);

                        newUniverse[x][y] = cellT;

                    } else {

                        Cell cellF = new Cell(false);

                        newUniverse[x][y] = cellF;
                    }

                } else if (getAliveNeighbors(universe, x, y) == 3) {

                    Cell cellT = new Cell(true);

                    newUniverse[x][y] = cellT;

                } else {

                    Cell cellF = new Cell(false);

                    newUniverse[x][y] = cellF;
                }

            }

        }

        universe = newUniverse;
    }

    /**
     * Retrieve whether a Cell within a given Cell array is alive or dead/out of bounds.
     * @param arr 2D Cell array that contains living and dead Cells
     * @param x X location to query
     * @param y Y location to query
     * @return 1 if the queried Cell is alive, 0 otherwise.
     */
    private int getCellStatus(Cell[][] arr, int x, int y) {
        return (x >= 0 && x < dimensionLength && y >= 0 && y < dimensionLength && universe[x][y].getAlive()) ? 1 : 0;
    }

    /**
     * Count the number of alive neighbors a given Cell in a Cell array has.
     * @param arr 2D Cell array that contains living and dead Cells
     * @param x X location to query
     * @param y Y location to query
     * @return The number of alive neighbors the queried Cell has
     */
    private int getAliveNeighbors(Cell[][] arr, int x, int y) {
        int total = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                total += getCellStatus(arr, x + i, y + j);
            }
        }
        total -= getCellStatus(arr, x, y);
        return total;
    }

    /**
     * @return The backing array of the board
     */
    public Cell[][] getUniverse() {
        return universe;
    }

    /**
     * toString method that visualizes universe and the generationCount
     * @return String representation of this object
     */
    @Override
    public String toString() {
        String output = String.format("Generation: %s\n",  generationCount);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                output += (universe[i][j].getAlive() ? "[*]" : "[ ]");
            }
            output += "\n";
        }
        return output;
    }
}
