package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents a Bullet, which is an object with a position that moves upward.
 *
 */
public class Bullet extends ObjectWithPosition {

    /**
     * Constructs a Bullet with the specified initial position.
     *
     * @param x The x-coordinate of the bullet.
     * @param y The y-coordinate of the bullet.
     */
    public Bullet(int x, int y) {
        super(x, y);
    }

    /**
     * Subtracts 1 from y position, causing Bullet instance
     * to move up.
     *
     * @param tick The current game tick
     */
    public void tick(int tick) {
        y -= 1;
    }

    /**
     * Returns a new ObjectGraphic instance which contains the textRepresentation
     * and the pathToImage.
     */
    public ObjectGraphic render() {
        return new ObjectGraphic("🔺", "assets/bullet.png");
    }
}
