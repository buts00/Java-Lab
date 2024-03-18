package typeOfArmors;

/**
 * The HeavyArmor class represents a heavy type of armor in the game.
 * It extends the Armor class and provides a specialized defense method.
 */
public class HeavyArmor extends Armor {
    /**
     * Defends against an attack using heavy armor, providing feedback with the owner's name.
     *
     * @param owner The owner of the armor who is defending.
     */
    @Override
    public void defend(String owner) {
        System.out.println(owner + " used heavy armor to defend");
    }
}
