/**
 * This class represents Slytherin
 * @author Shaotong Sun
 * @version 9.0.1
 */
public class Slytherin extends Wizard {
    /**
     * Slytherin constructor only with name
     * @param  name [name of the Slytherin]
     */
    public Slytherin(String name) {
        super(name, "green", (int) (6 * Math.random()) + 22, (int) (3 * Math.random()) + 5,
                new Spell[] {new Spell("Expulso", 3)
                , new Spell("Levicorpus", 2)
                , new Spell("Oppugno", 1)
                , new Spell("Flipendo", 1)
                , new Spell("Wingardium Leviosa", 0)});
    }
    /**
     * interact method, a interact with b
     * @param other [another Slytherin]
     */
    @Override
    public void interact(Wizard other) {
        super.interact(other);
    }
}
