import java.util.ArrayList;
import java.util.Collections;
/**
 * this class represents PokemonCenter
 * @author Shaotong Sun
 * @version 11.11.11
 */
public class PokemonCenter {
    private ArrayList<Pokemon> injured;
    private int nurses;
    /**
     * PokemonCenter constructor with injured value and nurses number
     * @param  injured [injured value]
     * @param  nurses  [nurses number]
     */
    public PokemonCenter(ArrayList<Pokemon> injured, int nurses) {
        this.injured = injured;
        this.nurses = nurses;
    }
    /**
     * PokemonCenter constructor
     */
    public PokemonCenter() {
        this(new ArrayList<Pokemon>(), 1);
    }
    /**
     * add a pokemon method
     * @param  pokemon [pokemon]
     * @return         [boolean]
     */
    public boolean add(Pokemon pokemon) {
        for (Pokemon p: injured) {
            if (p.equals(pokemon)) {
                return false;
            }
        }
        injured.add(pokemon);
        return true;
    }
    /**
     * heal the pokemon method
     * @param amount [heal amount]
     */
    public void heal(int amount) {
        ArrayList<Pokemon> injuredNew = new ArrayList<Pokemon>();
        if (nurses >= injured.size()) {
            for (Pokemon p: injured) {
                p.heal(amount);
                if (p.getHealth() < p.getMaxHealth()) {
                    injuredNew.add(p);
                }
                injured = injuredNew;
            }
        } else {
            int n = 0;
            for (int i = 0; i < injured.size(); i++) {
                ++n;
                Pokemon p = injured.get(i);
                if (n <= nurses) {
                    p.heal(amount);
                    injured.remove(i);
                    i--;
                    if (p.getHealth() < p.getMaxHealth()) {
                        injured.add(p);
                    }
                }

            }
        }
    }
    /**
     * heal the most injured pokemon method
     * @param amount [heal amount]
     */
    public void healMostInjured(int amount) {
        Collections.sort(injured);
        heal(amount);
    }
    /**
     * Override toString method
     * @return [String]
     */
    @Override
    public String toString() {
        return "This Pokemon Center has " + nurses + " nurses and " + injured.size() + " pokemon waiting to be seen.";
    }
}
