package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a basic enemy that descends over time.
 * This class extends DescendingEnemy and provides a graphical representation.
 */
public class Enemy extends DescendingEnemy {

    /**
     * Constructs an Enemy with the specified initial position.
     *
     * @param x The x-coordinate of the enemy.
     * @param y The y-coordinate of the enemy.
     */
    public Enemy(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a new ObjectGraphic instance representing the enemy.
     *
     * @return A new ObjectGraphic containing both a text and image representation of the enemy.
     */
    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("👾", "assets/enemy.png");
    }
}
