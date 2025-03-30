package game.core;


/**
 * Represents an effect that a power-up can have on a ship.
 * Any class implementing this interface must define how the effect is applied.
 */
public interface PowerUpEffect {

    /**
     * Applies the effect of the power-up to the given ship.
     *
     * @param ship The ship to which the effect will be applied.
     */
    void applyEffect(Ship ship);
}
