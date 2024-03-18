package typeOfWeapons;

/**
 * The Sword class represents a sword weapon in the game.
 * It extends the Weapon class and provides a specialized attack method.
 */
public class Sword extends Weapon {
    /**
     * Performs an attack action using a sword, providing feedback with the owner's name.
     *
     * @param owner The owner of the weapon who is performing the attack.
     */
    @Override
    public void attack(String owner) {
        System.out.println(owner + " used a sword to attack");
    }
}