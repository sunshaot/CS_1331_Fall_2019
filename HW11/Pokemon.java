//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
/**
 * this class represents Pokemon
 * @author Shaotong Sun
 * @version 11.11.11
 */
public abstract class Pokemon implements Comparable<Pokemon> {
    private ArrayList<Integer> medicalHistory;
    private String trainerName;
    private int health;
    private int maxHealth;
    /**
     * Pokemon constructor with trainer's name, health and max health
     * @param  trainerName [trainer's name]
     * @param  health      [health]
     * @param  maxHealth   [max health]
     */
    public Pokemon(String trainerName, int health, int maxHealth) {
        this.trainerName = trainerName;
        this.health = health;
        this.maxHealth = maxHealth;
        medicalHistory = new ArrayList<Integer>();
    }
    /**
     * Pokemon copy constructor
     * @param  p [another Pokemon]
     */
    public Pokemon(Pokemon p) {
        this.trainerName = p.trainerName;
        this.health = p.health;
        this.maxHealth = p.maxHealth;
        this.medicalHistory = new ArrayList<Integer>();
        for (Integer i : medicalHistory) {
            this.medicalHistory.add(i);
        }
    }
    /**
     * heal method, heal Pokemon
     * @param amount [heal amount]
     */
    public void heal(int amount) {
        if ((health + amount) > maxHealth) {
            medicalHistory.add(maxHealth - health);
            health = maxHealth;
        } else {
            medicalHistory.add(amount);
            health += amount;
        }
    }
    /**
     * damage method, damage Pokemon
     * @param amount [damage amount]
     */
    public void damage(int amount) {
        if ((health - amount) < 0) {
            medicalHistory.add(-health);
            health = 0;
        } else {
            medicalHistory.add(-amount);
            health -= amount;
        }
    }
    /**
     * override compareTo method
     * @param  other [another Pokemon]
     * @return       [int]
     */
    @Override
    public int compareTo(Pokemon other) {
        if (this.health > other.health) {
            return 1;
        } else if (this.health < other.health) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * Override equals method
     * @param  other [another object]
     * @return       [boolean value]
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pokemon)) {
            return false;
        }
        Pokemon o = (Pokemon) other;
        return this.trainerName.equals(o.trainerName) && this.health == o.health
                && this.maxHealth == o.maxHealth && this.medicalHistory.equals(o.medicalHistory);
    }
    /**
     * Override hashCode method
     * @return [int]
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + medicalHistory.hashCode();
        return result;
    }
    /**
     * get trainer's name
     * @return [trainer's name']
     */
    public String getTrainerName() {
        return trainerName;
    }
    /**
     * set trainer's name
     * @param trainerName [trainer's name]
     */
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    /**
     * get Pokemon's health
     * @return [health]
     */
    public int getHealth() {
        return health;
    }
    /**
     * get the max health of pokemon
     * @return [maxHealth]
     */
    public int getMaxHealth() {
        return maxHealth;
    }
}
