/**
 * This class represents Charmander
 * @author Shaotong Sun
 * @version 11.11.11
 */
public class Charmander extends Pokemon {
    private int flameLevel;
    /**
     * Charmander constructor with trainer's name, health,
     * and max health and flame level.
     * @param  trainerName [trainer's name]
     * @param  health      [health]
     * @param  maxHealth   [max health]
     * @param  flameLevel  [flame level]
     */
    public Charmander(String trainerName, int health, int maxHealth, int flameLevel) {
        super(trainerName, health, maxHealth);
        this.flameLevel = flameLevel;
    }
    /**
     * Charmander copy constructor
     * @param  c [another charmander]
     */
    public Charmander(Charmander c) {
        super((Pokemon) c);
        this.flameLevel = c.flameLevel;
    }
    /**
     * Override equals method
     * @param  other [another object]
     * @return       [boolean value]
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Charmander)) {
            return false;
        }
        Charmander o = (Charmander) other;
        return super.equals(other) && o.flameLevel == this.flameLevel;
    }
    /**
     * Override hashCode method
     * @return [int]
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (int) this.getMaxHealth();
        result = prime * result + (int) flameLevel;
        return result;
    }
    /**
     * damage method
     * @param amount        [damage amount]
     * @param isWaterDamage [is it water damage?]
     */
    public void damage(int amount, boolean isWaterDamage) {
        if (isWaterDamage) {
            super.damage(2 * amount);
        } else {
            super.damage(amount);
        }
    }
}
