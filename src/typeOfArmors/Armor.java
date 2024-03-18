package typeOfArmors;

/**
 * The Armor class represents a piece of armor in the game.
 * It provides a method for defending against attacks.
 */
public class Armor {
    /**
     * Defends against an attack, providing feedback with the owner's name.
     *
     * @param owner The owner of the armor who is defending.
     */
    public void defend(String owner) {
        System.out.println(owner + " used armor to defend!");
    }
}
