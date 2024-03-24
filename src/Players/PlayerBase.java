package Players;

/**
 * Represents a base class for players in the game.
 */
public abstract class PlayerBase {
    protected int health;

    /**
     * Constructs a player with the specified initial health.
     * @param health The initial health of the player.
     */
    public PlayerBase(int health) {
        this.health = health;
    }

    /**
     * Gets the current health of the player.
     * @return The current health of the player.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Reduces the player's health by the specified amount of damage.
     * @param damage The amount of damage to be taken.
     */
    public void takeDamage(int damage) {
        health -= damage;
    }
}