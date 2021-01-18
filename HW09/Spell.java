/**
 * This class represents Spell
 * @author Shaotong Sun
 * @version 9.1.1
 */
public class Spell {
    private String name;
    private int damage;
    /**
     * Spell constructor with everything we need
     * @param  name   [spell name]
     * @param  damage [spell damage]
     */
    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    /**
     * toString method, returns the description of spell
     * @return [description of spell]
     */
    public String toString() {
        return String.format("%s: %d attack power", name, damage);
    }
    /**
     * getName method, gets the name of spell
     * @return [name of spell]
     */
    public String getName() {
        return name;
    }
    /**
     * getDamage method, gets the damage of spell
     * @return [damage of spell]
     */
    public int getDamage() {
        return damage;
    }
    /**
     * equals method, checks if two spells are equal
     * @param  o [another spell]
     * @return   [boolean value]
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Spell)) {
            return false;
        }
        Spell spell = (Spell) o;
        return damage == spell.damage
            && name.equals(spell.name);
    }
}
