//I worked on the homework assignment alone, using only course materials.
/**
 * The class represents the water fountain.
 *
 * @author Shaotong Sun
 * @version 5.1.1
 */
public class WaterFountain {

    private String modelName;

    private boolean requiresMaintenance;

    private int cupsPoured;

    private static int totalWaterFountains;

    public static final String SOFTWARE_VERSION = "2.0.0";

    /**
     * Create a WaterFountain
     * @param  modelName  model name of the water fountain
     * @param  cupsPoured  the number of cups of water the
     *                     waterfountain has poured
     */
    public WaterFountain(String modelName, int cupsPoured) {
        this.modelName = modelName;
        this.cupsPoured = cupsPoured;
        requiresMaintenance = false;
        totalWaterFountains++;
    }
    /**
     * getter for variable modelName, get the value of the modelName
     * @return model name of the water fountain
     */
    public String getModelName() {
        return modelName;
    }
    /**
     * setter for variable modelName, set the value of the modelName
     * @param modelName model name of the water fountain, String type
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    /**
     * getter for requiresMaintenance, get the value of the requireMaintenance
     * @return get whether the water fountainrequires maintenance or not
     */
    public boolean getRequiresMaintenance() {
        return requiresMaintenance;
    }
    /**
     * setter for requiresMaintenance, set the value of the requireMaintenance
     * @param requiresMaintenance whether the water fountainrequires
     *                            maintenance or not, boolean type
     */
    public void setRequiresMaintenance(boolean requiresMaintenance) {
        this.requiresMaintenance = requiresMaintenance;
    }
    /**
     * getter for cupsPoured, get the value of the cupsPoured
     * @return the number of cups of water the waterfountain has poured
     */
    public int getCupsPoured() {
        return cupsPoured;
    }
    /**
     * setter for cupsPoured, set the value of the cupsPoured
     * @param cupsPoured the number of cups of water the
     *                   waterfountain has poured
     */
    public void setCupsPoured(int cupsPoured) {
        this.cupsPoured = cupsPoured;
    }
    /**
     * getter for totalWaterFountains
     * @return the number of water foun-tains that have been created
     */
    public static int getTotalWaterFountains() {
        return totalWaterFountains;
    }
    /**
     * If the water fountaindoes not require maintenance, cupsPoured
     * should be incremented by one. If the water fountaindoes require
     * maintenance, do nothing.
     */
    public void pourCup() {
        if (requiresMaintenance) {
            assert true;
        } else {
            cupsPoured++;
        }
    }
    /**
     * Mehtod to know water fountain is logically equal to this water fountain
     * @param  other another water fountain
     * @return       whether they are equal, boolean type
     */
    public boolean equals(WaterFountain other) {
        String otherModelName = other.getModelName();
        int otherCupsPoured = other.getCupsPoured();
        String otherSV = WaterFountain.SOFTWARE_VERSION;
        return modelName == otherModelName && cupsPoured
            == otherCupsPoured && SOFTWARE_VERSION == otherSV;
    }
    /**
     * Details of the water fountain
     * @return the details of the water fountain, String type
     */
    public String toString() {
        String result;
        if (requiresMaintenance) {
            result = modelName + " has poured " + cupsPoured
                    + " cups, requires maintenance, and is running version: "
                    + SOFTWARE_VERSION;
        } else {
            result = modelName + " has poured " + cupsPoured
                    + " cups, does not require maintenance, and is running "
                    + "version: " + SOFTWARE_VERSION;
        }
        return result;
    }
}
