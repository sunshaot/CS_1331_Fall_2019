//I worked on the homework assignment alone, using only course materials.
/**
 * This class represents PokemonSpecies implements Comparable interface
 * @author Shaotong Sun
 * @version 12.1.1
 */
public class PokemonSpecies implements Comparable<PokemonSpecies> {
    private final int speciesNumber;
    private final String speciesName;
    private String speciesNickname;
    private String description;
    /**
     * PokemonSpecies constructor with 4 data fields
     * @param  speciesName     [speciesName]
     * @param  speciesNumber   [speciesNumber]
     * @param  speciesNickname [speciesNickname]
     * @param  description     [description]
     */
    public PokemonSpecies(String speciesName, int speciesNumber, String speciesNickname, String description) {
        this.speciesName = speciesName;
        this.speciesNumber = speciesNumber;
        this.speciesNickname = speciesNickname;
        this.description = description;
    }
    /**
     * PokemonSpecies constructor with 2 data fields
     * @param  speciesName   [speciesName]
     * @param  speciesNumber [speciesNumber]
     */
    public PokemonSpecies(String speciesName, int speciesNumber) {
        this(speciesName, speciesNumber, null, null);
    }
    /**
     * compareTo method
     * @param  other [another PokemonSpecies]
     * @return       [-1 if smaller,0 for equal, 1 for greater]
     */
    @Override
    public int compareTo(PokemonSpecies other) {
        if (this.speciesNumber == other.speciesNumber) {
            return 0;
        } else if (this.speciesNumber >= other.speciesNumber) {
            return 1;
        } else {
            return -1;
        }
    }
    /**
     * equals method
     * @param  other [another object]
     * @return       [boolean]
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PokemonSpecies)) {
            return false;
        }
        PokemonSpecies o = (PokemonSpecies) other;
        return this.speciesName == o.speciesName && this.speciesNumber == o.speciesNumber;
    }
    /**
     * hashCode method
     * @return [int]
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + speciesNickname.hashCode();
        result = prime * result + speciesNumber;
        return result;
    }
    /**
     * toString method
     * @return [String]
     */
    @Override
    public String toString() {
        return speciesNumber + ": " + speciesName + ", the " + speciesNickname + " Pokemon. " + description + ".";
    }
    /**
     * getSpeciesNumber method
     * @return [speciesNumber]
     */
    public int getSpeciesNumber() {
        return speciesNumber;
    }
    /**
     * getSpeciesName method
     * @return [speciesName]
     */
    public String getSpeciesName() {
        return speciesName;
    }
    /**
     * getSpeciesNickname method
     * @return [speciesNickname]
     */
    public String getSpeciesNickname() {
        return speciesNickname;
    }
    /**
     * getDescription method
     * @return [description]
     */
    public String getDescription() {
        return description;
    }
    /**
     * setSpeciesNickname method
     * @param speciesNickname [new speciesNickname]
     */
    public void setSpeciesNickname(String speciesNickname) {
        this.speciesNickname = speciesNickname;
    }
    /**
     * setDescription method
     * @param description [new description]
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
