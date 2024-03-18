package Players;

import typeOfArmors.Armor;
import typeOfWeapons.Weapon;

/**
 * The Bot class represents an AI-controlled player in the game.
 * It holds references to its weapon and armor, and provides methods for attacking and defending.
 */
public class Bot {
    private final Weapon weapon; // The weapon equipped by the bot
    private final Armor armor;   // The armor equipped by the bot

    /**
     * Constructs a new Bot with the specified weapon and armor.
     *
     * @param weapon The weapon to be equipped by the bot.
     * @param armor  The armor to be equipped by the bot.
     */
    public Bot(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    /**
     * Initiates an attack action by the bot.
     * It calls the attack method of the weapon.
     */
    public void attack() {
        weapon.attack("Bot");
    }

    /**
     * Initiates a defense action by the bot.
     * It calls the defend method of the armor.
     */
    public void defend() {
        armor.defend("Bot");
    }
}
