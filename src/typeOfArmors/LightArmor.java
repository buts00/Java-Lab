package typeOfArmors;

/**
 * The LightArmor class represents a light type of armor in the game.
 * It extends the Armor class and provides a specialized defense method.
 */
public class LightArmor extends Armor {
    /**
     * Defends against an attack using light armor, providing feedback with the owner's name.
     *
     * @param owner The owner of the armor who is defending.
     */
    @Override
    public void defend(String owner) {
        System.out.println(owner + " used light armor to defend");
    }
}
