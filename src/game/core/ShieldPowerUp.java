package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a shield power-up that increases the score when collected.
 * This class extends PowerUp and provides a graphical representation.
 */
public class ShieldPowerUp extends PowerUp {

    /**
     * Constructs a ShieldPowerUp with the specified initial position.
     *
     * @param x The x-coordinate of the shield power-up.
     * @param y The y-coordinate of the shield power-up.
     */
    public ShieldPowerUp(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a new ObjectGraphic instance representing the shield power-up.
     *
     * @return A new ObjectGraphic containing both a text and image representation of the shield power-up.
     */
    public ObjectGraphic render() {
        return new ObjectGraphic("💠", "assets/shield.png");
    }

    /**
     * Applies the shield power-up effect to the given ship.
     * Increases the ship's score by 50 points when the shield is activated.
     *
     * @param ship The ship receiving the shield power-up effect.
     */
    @Override
    public void applyEffect(Ship ship) {
        ship.addScore(50);
        System.out.println("Shield activated! Score increased by 50.");
    }
}
