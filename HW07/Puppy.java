//I worked on the homework assignment alone, using only course materials.
import java.util.Random;
/**
 * This class represents the puppy
 * @author Shaotong Sun
 * @version 7.0.1
 */
public class Puppy {
    private String name;
    private int age;
    private int health;
    /**
     * Creates a new puppy with name age and health
     * @param  name   name of the puppy
     * @param  age    age of the puppy
     * @param  health health of the puppy
     */
    public Puppy(String name, int age, int health) {
        this.name = name;
        this.age = age;
        this.health = health;
    }
    /**
     * Creates a new puppy with the given name and random age & health
     * @param  name name of the puppy
     */
    public Puppy(String name) {
        this.name = name;
        Random ageR = new Random();
        age = ageR.nextInt(16);
        Random healthR = new Random();
        health = healthR.nextInt(31) + 5;
    }
    /**
     * Method to get the name of the puppy
     * @return name of the puppy
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set the name of the puppy
     * @param name name of the puppy
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get the age of the puppy
     * @return age of the puppy
     */
    public int getAge() {
        return age;
    }
    /**
     * Method to set the age of the puppy
     * @param age age of the puppy
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Method to get the health of the puppy
     * @return health of the puppy
     */
    public int getHealth() {
        return health;
    }
    /**
     * Method to set the health of the puppy
     * @param health health of the puppy
     */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * Method to show the puppy
     * @return information about the puppy
     */
    public String toString() {
        return String.format("%s: a puppy %d years old with %d health", name, age, health);
    }
    /**
     * Method to know whether the puppy can adopt
     * @return true if the puppy can adopt otherwise false
     */
    public boolean canAdopt() {
        return health >= 50;
    }
    /**
     * Increases the puppy’s health by 1
     */
    public void fetch() {
        health++;
    }
    /**
     * Method to change the health If inside, increase health by 5. If not inside, increase health by 10.
     * @param inside [description]
     */
    public void fetch(boolean inside) {
        if (inside) {
            health += 5;
        } else {
            health += 10;
        }
    }
    /**
     * Increase the puppy’s healthy by distance divided by 10.
     * @param distance distance
     */
    public void fetch(int distance) {
        health += distance / 10;
    }
}
