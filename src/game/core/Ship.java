package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a ship that can be controlled and interacted with in the game.
 * The ship has health, a score, and the ability to take damage, heal, and score points.
 * This class extends Controllable, allowing the ship to move.
 */
public class Ship extends Controllable {

    /** The health of the ship. */
    private int health;

    /** The score of the ship. */
    private int score;

    /**
     * Constructs a Ship with the specified initial position and health.
     *
     * @param x The x-coordinate of the ship.
     * @param y The y-coordinate of the ship.
     * @param health The initial health of the ship.
     */
    public Ship(int x, int y, int health) {
        super(x, y);
        this.health = health;
        this.score = 0;
    }

    /**
     * Constructs a Ship with default position (5, 10) and health (100).
     */
    public Ship() {
        this(5, 10, 100);
    }

    /**
     * Returns a new ObjectGraphic instance representing the ship.
     * This method provides both a text and image representation of the ship.
     *
     * @return A new ObjectGraphic representing the ship.
     */
    public ObjectGraphic render() {
        return new ObjectGraphic("🚀", "assets/ship.png");
    }

    /**
     * Applies damage to the ship and reduces its health.
     * If the health drops below 0, it is set to 0.
     *
     * @param damage The amount of damage to apply to the ship.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Heals the ship by the specified amount.
     *
     * @param amount The amount of health to restore.
     */
    public void heal(int amount) {
        this.health += amount;
    }

    /**
     * Increases the ship's score by the specified number of points.
     *
     * @param points The number of points to add to the score.
     */
    public void addScore(int points) {
        this.score += points;
    }

    /**
     * Gets the current health of the ship.
     *
     * @return The current health of the ship.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Gets the current score of the ship.
     *
     * @return The current score of the ship.
     */
    public int getScore() {
        return this.score;
    }

    @Override
    public void tick(int tick) {
    }
}
