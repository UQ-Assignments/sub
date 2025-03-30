package game.core;

/**
 * Represents a power-up object that can affect a game object.
 * This class extends ObjectWithPosition and implements PowerUpEffect.
 */
public abstract class PowerUp extends ObjectWithPosition implements PowerUpEffect {

    /**
     * Constructs a PowerUp with the specified initial position.
     *
     * @param x The x-coordinate of the power-up.
     * @param y The y-coordinate of the power-up.
     */
    public PowerUp(int x, int y) {
        super(x, y);
    }

    @Override
    public void tick(int tick) {
    }
}
