package game.core;

import game.ui.ObjectGraphic;

/**
 * Represents an Asteroid, which is a type of DescendingEnemy and
 * by extension is a SpaceObject. The asteroid moves downward
 * and has a graphical representation of a white circle.
 */

public class Asteroid extends DescendingEnemy {

    /**
     * Constructs an Asteroid with the specified initial position.
     * The super calls the DescendingEnemy constructor which then calls
     * super on ObjectWithPosition which will then set the position.
     *
     * @param x The x-coordinate of the asteroid.
     * @param y The y-coordinate of the asteroid.
     */

    public Asteroid(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a new ObjectGraphic instance which contains the textRepresentation
     * and the pathToImage.
     */
    public ObjectGraphic render() {
        return new ObjectGraphic("🌑", "assets/asteroid.png");
    }
}
