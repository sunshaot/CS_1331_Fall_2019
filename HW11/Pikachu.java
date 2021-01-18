/**
 * this class represents Pikachu
 * @author Shaotong Sun
 * @version 11.11.11
 */
public class Pikachu extends Pokemon {
    private int friendshipLevel;
    /**
     * Pikachu constructor with trainer's name, health, max health
     * and friend ship level
     * @param  trainerName     [trainer's name']
     * @param  health          [health]
     * @param  maxHealth       [max health]
     * @param  friendshipLevel [friend ship level]
     */
    public Pikachu(String trainerName, int health, int maxHealth, int friendshipLevel) {
        super(trainerName, health, maxHealth);
        this.friendshipLevel = friendshipLevel;
    }
    /**
     * Pikachu copy constructor
     * @param  p [another Pikachu]
     */
    public Pikachu(Pikachu p) {
        super((Pokemon) p);
        this.friendshipLevel = p.friendshipLevel;
    }
    /**
     * Override heal method, heal Pikachu
     * @param amount [heal amount]
     */
    @Override
    public void heal(int amount) {
        super.heal(2 * amount);
    }
    /**
     * Override equals method
     * @param  other [another object]
     * @return       [boolean value]
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pikachu)) {
            return false;
        }
        Pikachu o = (Pikachu) other;
        return super.equals(other) && o.friendshipLevel == this.friendshipLevel;
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
        result = prime * result + (int) friendshipLevel;
        return result;
    }
}
