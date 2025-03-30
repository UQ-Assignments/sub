package game.exceptions;


/**
 * Exception thrown when an attempt is made to exceed the boundaries of the game world.
 * This class extends RuntimeException, allowing for unchecked exceptions.
 */
public class BoundaryExceededException extends RuntimeException {

    /**
     * Constructs a new BoundaryExceededException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public BoundaryExceededException(String message) {
        super(message);
    }
}
