import java.util.ArrayList;
/**
 * This class represents Pokedex extends from AbstractDex
 * @author Shaotong Sun
 * @version 12.1.1
 */
public class Pokedex extends AbstractDex<PokemonSpecies> {
    /**
     * Pokedex constructor
     */
    public Pokedex() {
        super();
    }
    /**
     * Pokedex constructor with specified entry
     * @param  initialEntries [initialEntries]
     */
    public Pokedex(ArrayList<PokemonSpecies> initialEntries) {
        super();
        super.setEntries(initialEntries);
    }
}
