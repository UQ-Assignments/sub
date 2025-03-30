package game.core;

import game.ui.ObjectGraphic;
import game.ui.Tickable;

/**
 * Represents an object in space with a position and graphical representation.
 * This interface extends Tickable, requiring the implementation of the tick method.
 */
public interface SpaceObject extends Tickable {

    /**
     * Gets the x-coordinate of the space object.
     *
     * @return The x-coordinate of the space object.
     */
    int getX();

    /**
     * Gets the y-coordinate of the space object.
     *
     * @return The y-coordinate of the space object.
     */
    int getY();

    /**
     * Returns a graphical representation of the space object.
     * This method provides both a text and image representation.
     *
     * @return An ObjectGraphic representing the space object.
     */
    ObjectGraphic render();
}
