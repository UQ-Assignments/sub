package game.core;

/**
 * Represents an enemy that moves downward over time.
 * This class extends ObjectWithPosition and updates its position periodically.
 */
public abstract class DescendingEnemy extends ObjectWithPosition {

    /**
     * Constructs a DescendingEnemy with the specified initial position.
     *
     * @param x The x-coordinate of the enemy.
     * @param y The y-coordinate of the enemy.
     */
    public  DescendingEnemy(int x, int y) {
        super(x, y);
    }

    /**
     * Updates the enemy's position based on the game tick.
     * The enemy moves downward every 10 ticks.
     *
     * @param tick The current game tick.
     */
    @Override
    public void tick(int tick) {
        if (tick % 10 == 0) {
            this.y += 1;
        }
    }
}
