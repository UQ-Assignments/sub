package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a health power-up that restores health to a ship when collected.
 * This class extends PowerUp and provides a graphical representation.
 */
public class HealthPowerUp extends PowerUp {

    /**
     * Constructs a HealthPowerUp with the specified initial position.
     *
     * @param x The x-coordinate of the power-up.
     * @param y The y-coordinate of the power-up.
     */
    public HealthPowerUp(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a new ObjectGraphic instance representing the health power-up.
     *
     * @return A new ObjectGraphic containing both a text and image representation of the power-up.
     */
    public ObjectGraphic render() {
        return new ObjectGraphic("❤️", "assets/health.png");
    }

    /**
     * Applies the health restoration effect to the given ship.
     * Increases the ship's health by 20 points.
     *
     * @param ship The ship receiving the health power-up.
     */
    @Override
    public void applyEffect(Ship ship) {
        ship.heal(20);
        System.out.println("Health restored by 20!");
    }
}
