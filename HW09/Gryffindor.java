/**
 * This class represents Gryffindor
 * @author Shaotong Sun
 * @version 9.0.1
 */
public class Gryffindor extends Wizard {
    /**
     * Gryffindor constructor only with name
     * @param  name [name of the Gryffindor]
     */
    public Gryffindor(String name) {
        super(name, "scarlet", (int) (6 * Math.random()) + 25, (int) (3 * Math.random()) + 4
            , new Spell[] {new Spell("Expecto Patronum", 3)
            , new Spell("Expelliarmus", 2)
            , new Spell("Ridikkulus", 1)
            , new Spell("Wingardium Leviosa", 0)});
    }
    /**
     * interact method, a interact with b
     * @param other [another Gryffindor]
     */
    @Override
    public void interact(Wizard other) {
        super.interact(other);
    }
}
