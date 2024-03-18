package typeOfWeapons;

/**
 * The Weapon class represents a generic weapon in the game.
 * It provides a method for performing an attack action.
 */
public class Weapon {
    /**
     * Performs an attack action using the weapon, providing feedback with the owner's name.
     *
     * @param owner The owner of the weapon who is performing the attack.
     */
    public void attack(String owner) {
        System.out.println(owner + " used a weapon to attack");
    }
}