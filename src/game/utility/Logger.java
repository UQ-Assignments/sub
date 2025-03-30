package game.utility;

/**
 * Represents a logger that logs text messages.
 * Implementations of this interface will define how the messages are logged.
 */
public interface Logger {

    /**
     * Logs a message.
     *
     * @param text The message to log.
     */
    void log(String text);
}
