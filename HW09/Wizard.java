//I worked on the homework assignment alone, using only course materials.
import java.util.Random;
/**
 * This class represents Wizard
 * @author Shaotong Sun
 * @version 9.2.1
 */
public class Wizard {
    private String name;
    private String color;
    private int health;
    private int maxHealth;
    private int power;
    private Spell[] book;
    /**
     * Wizard constructor with everything we need
     * @param  name      [name of the wizard]
     * @param  color     [favorite color]
     * @param  maxHealth [max health]
     * @param  power     [attack power]
     * @param  book      [spell book]
     */
    public Wizard(String name, String color, int maxHealth, int power, Spell[] book) {
        this.name = name;
        this.color = color;
        this.maxHealth = maxHealth;
        this.power = power;
        this.book = book;
        health = maxHealth;
    }
    /**
     * Wizard constructor without max health
     * @param  name  [name of the wizard]
     * @param  color [favorite color]
     * @param  power [attack power]
     * @param  book  [spell book]
     */
    public Wizard(String name, String color, int power, Spell[] book) {
        this(name, color, 25, power, book);
    }
    /**
     * Wizard constructor without spell book
     * @param  name      [name of the wizard]
     * @param  color     [favorite color]
     * @param  maxHealth [max health]
     * @param  power     [attack power]
     */
    public Wizard(String name, String color, int maxHealth, int power) {
        this(name, color, maxHealth, power, new Spell[]{new Spell("Wingardium Leviosa", 0)});
    }
    /**
     * Wizard constructor without spell book and max health
     * @param  name  [name of the wizard]
     * @param  color [favorite color]
     * @param  power [attack power]
     */
    public Wizard(String name, String color, int power) {
        this(name, color, 25, power, new Spell[]{new Spell("Wingardium Leviosa", 0)});
    }
    /**
     * cast method, randomly choose spell card from book
     * @param  spellBook [spell book]
     * @return           [random spell form book]
     */
    public Spell cast(Spell[] spellBook) {
        Random random = new Random();
        int i = random.nextInt(spellBook.length);
        return spellBook[i];
    }
    /**
     * toString method, returns the description of wizard
     * @return [description of the Wizard]
     */
    @Override
    public String toString() {
        return
        String.format("%s wishes to join the %s house at Hogwarts! They have %d health points and %d attack power."
                        , name, color, health, power);
    }
    /**
     * duel method, fright between a and b, after duel, reset health to max
     * @param other [another Wizard]
     */
    public void duel(Wizard other) {
        while (this.health > 0 && other.health > 0) {
            //drink potion (1~20 in 0~99 = 20/100 = 20%)?
            Random random = new Random();
            int chance = random.nextInt(100);
            if ((this.health < this.maxHealth || other.health < other.maxHealth) && this.health != other.health) {
                if (chance < 20) {
                    String potion;
                    //this has lower health than max and other, this drink
                    if (this.health < this.maxHealth && this.health < other.health) {
                        this.health += 3;
                        if (this.health > this.maxHealth) {
                            this.health = this.maxHealth;
                        }
                        potion =
                        String.format("%s drinks an invigoration potion and restores 3 health! %s now has %d health."
                                        , this.name, this.name, this.health);
                        System.out.println(potion);
                    }
                    //other has lower health than max and this, other drink
                    if (other.health < other.maxHealth && other.health < this.health) {
                        other.health += 3;
                        if (other.health > other.maxHealth) {
                            other.health = other.maxHealth;
                        }
                        potion =
                        String.format("%s drinks an invigoration potion and restores 3 health! %s now has %d health."
                                        , other.name, other.name, other.health);
                        System.out.println(potion);
                    }
                }
            }
            Wizard a;
            Wizard b;
            //who attack first?
            if (this.health <= other.health) {
                a = this;
                b = other;
            } else {
                a = other;
                b = this;
            }
            Spell aSpell = a.cast(a.book);
            Spell bSpell = a.cast(b.book);
            //a attacks
            int aPower = a.power + aSpell.getDamage();
            b.health -= aPower;
            //b health to 0 first
            if (b.health < 0) {
                b.health = 0; //health never below 0
            }
            String aResult = String.format("%s casts %s and deals %d damage. %s now has %d health.",
                    a.name, aSpell.getName(), aPower, b.name, b.health);
            System.out.println(aResult);
            //print win message
            if (b.health == 0) {
                String aFinal = String.format("%s falls to the ground. %s wins the duel!", b.name, a.name);
                System.out.println(aFinal);
                break;
            }
            //b attacks
            int bPower = b.power + bSpell.getDamage();
            a.health -= bPower;
            //a health to 0 first
            if (a.health < 0) {
                a.health = 0; //health never below 0
            }
            String bResult = String.format("%s casts %s and deals %d damage. %s now has %d health.",
                    b.name, bSpell.getName(), bPower, a.name, a.health);
            System.out.println(bResult);
            //print win message
            if (a.health == 0) {
                String bFinal = String.format("%s falls to the ground. %s wins the duel!", a.name, b.name);
                System.out.println(bFinal);
                break;
            }
        }
        //reset health to max
        this.health = this.maxHealth;
        other.health = other.maxHealth;
    }
    /**
     * interact method, a interact with b
     * @param other [another Wizard]
     */
    public void interact(Wizard other) {
        String interact = String.format("%s: Hey %s, let's be friends!", this.name, other.name);
        System.out.println(interact);
        this.duel(other);
    }
    /**
     * equals method, determines if two Wizard are equal
     * @param  o [another Wizard]
     * @return   [boolean value]
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Wizard)) {
            return false;
        }
        Wizard other = (Wizard) o;
        if (this.name == other.name && this.health == other.health && this.power == other.power
                && this.color == other.color) {
            boolean result = true;
            for (int i = 0; i < this.book.length; i++) {
                if (!(this.book[i].equals(other.book[i]))) {
                    result = false;
                }
            }
            return result;
        } else {
            return false;
        }
    }
}
