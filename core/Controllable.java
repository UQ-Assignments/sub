package game.core;

import game.exceptions.BoundaryExceededException;
import game.utility.Direction;

import java.nio.BufferOverflowException;

public abstract class Controllable extends ObjectWithPosition{

    public Controllable(int x, int y) {
        super(x, y);
    }

    public void move(Direction direction) throws BoundaryExceededException {
        if (direction == Direction.UP) {
            int newY = getY() -1;
            if (newY < 0) {
                throw new BoundaryExceededException("Cannot move up z. Out of Bounds!");


            } else {
                this.y += -1;
            }
        } else if (direction == Direction.DOWN) {
            int newY = getY() +1;
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
