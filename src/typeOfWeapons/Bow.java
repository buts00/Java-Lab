package typeOfWeapons;

/**
 * The Bow class represents a bow weapon in the game.
 * It extends the Weapon class and provides a specialized attack method.
 */
public class Bow extends Weapon {
    /**
     * Performs an attack action using a bow, providing feedback with the owner's name.
     *
     * @param owner The owner of the weapon who is performing the attack.
     */
    @Override
    public void attack(String owner) {
        System.out.println(owner + " used a bow to attack");
    }
}
