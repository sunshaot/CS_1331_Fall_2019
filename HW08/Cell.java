/**
 * Represents a basic cell in Game of Life
 * @author 1331 TAs
 * @version 13.3.1
 */
public class Cell {

    private boolean alive;

    /**
     * Creates a dead cell
     */
    public Cell() {
        this(false);
    }

    /**
     * Creates a cell
     * @param cond The alive status of the cell
     */
    public Cell(boolean cond) {
        alive = cond;
    }

    /**
     * Changes the alive status of the cell
     * @param status the new status
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Get the alive status of the cell
     * @return true if cell is alive, false if dead
     */
    public boolean getAlive() {
        return alive;
    }
}
