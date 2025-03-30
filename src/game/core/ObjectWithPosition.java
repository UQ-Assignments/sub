package game.core;

/**
 * Represents an object that has a position in 2D space.
 * This class provides basic position handling and implements SpaceObject.
 */
public abstract class ObjectWithPosition implements SpaceObject {

    /** The x-coordinate of the object. */
    protected int x;
    /** The y-coordinate of the object. */
    protected int y;

    /**
     * Constructs an ObjectWithPosition with the specified coordinates.
     *
     * @param x The initial x-coordinate of the object.
     * @param y The initial y-coordinate of the object.
     */
    public ObjectWithPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the object.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the object.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return this.y;
    }
}
