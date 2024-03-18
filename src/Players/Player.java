package Players;

import typeOfArmors.Armor;
import typeOfWeapons.Weapon;

/**
 * The Player class represents a human-controlled player in the game.
 * It holds references to its weapon and armor, and provides methods for attacking and defending.
 */
public class Player {
    private final Weapon weapon; // The weapon equipped by the player
    private final Armor armor;   // The armor equipped by the player

    /**
     * Constructs a new Player with the specified weapon and armor.
     *
     * @param weapon The weapon to be equipped by the player.
     * @param armor  The armor to be equipped by the player.
     */
    public Player(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    /**
     * Initiates an attack action by the player.
     * It calls the attack method of the weapon.
     */
    public void attack() {
        weapon.attack("Player");
    }

    /**
     * Initiates a defense action by the player.
     * It calls the defend method of the armor.
     */
    public void defend() {
        armor.defend("Player");
    }
}
