package game.core;

import game.exceptions.BoundaryExceededException;
import game.utility.Direction;

import java.nio.BufferOverflowException;

/**
 * Represents an abstract controllable object that can move in four directions.
 * It extends ObjectWithPosition and provides movement functionality while handling boundaries.
 */
public abstract class Controllable extends ObjectWithPosition {

    /**
     * Constructs a Controllable object with the specified initial position.
     *
     * @param x The x-coordinate of the object.
     * @param y The y-coordinate of the object.
     */
    public Controllable(int x, int y) {
        super(x, y);
    }

    /**
     * Moves the object in the specified direction while ensuring it stays within bounds.
     *
     * @param direction The direction in which the object should move.
     * @throws BoundaryExceededException If the movement exceeds the allowed boundaries.
     */
    public void move(Direction direction) throws BoundaryExceededException {
        if (direction == Direction.UP) {
            int newY = getY() - 1;
            if (newY < 0) {
                throw new BoundaryExceededException("Cannot move up. Out of Bounds!");
            } else {
                this.y += -1;
            }
        } else if (direction == Direction.DOWN) {
            int newY = getY() + 1;
            if (newY >= 20) {
                throw new BoundaryExceededException("Cannot move down. Out of Bounds!");
            } else {
                this.y += 1;
            }
        } else if (direction == Direction.RIGHT) {
            int newX = getX() + 1;
            if (newX >= 20) {
                throw new BoundaryExceededException("Cannot move right. Out of Bounds!");
            } else {
                this.x += 1;
            }
        } else if (direction == Direction.LEFT) {
            int newX = getX() - 1;
            if (newX < 0) {
                throw new BoundaryExceededException("Cannot move left. Out of Bounds!");
            } else {
                this.x += -1;
            }
        }
    }
}
