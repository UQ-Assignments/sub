package game;

import game.core.*;
import game.GameModel;
import game.ui.UI;
import game.utility.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The Controller handling the game flow and interactions.
 *
 * Holds references to the UI and the Model, so it can pass information and references back and forth as necessary.
 * Manages changes to the game, which are stored in the Model, and displayed by the UI.
 */
public class GameController {
    private long startTime;
    private UI ui;
    private GameModel model;

    /**
     * Initializes the game controller with the given UI and Model.
     * Stores the ui, model and start time.
     * The start time System.currentTimeMillis() should be stored as a long.
     *
     * @param ui the UI used to draw the Game
     * @param model the model used to maintain game information
     * @provided
     */
    public GameController(UI ui, GameModel model) {
        this.ui = ui;
        this.model = model;
        this.startTime = System.currentTimeMillis(); // Start the timer
    }

    /**
     * Initializes the game controller with the given UI and a new GameModel (taking ui::log as the logger).
     * This constructor should call the other constructor using the "this()" keyword.
     *
     * @param ui the UI used to draw the Game
     * @provided
     */
    public GameController(UI ui) {
        this(ui, new GameModel(ui::log));
    }

    /**
     * Renders the game state, updating the UI with the current score, health, level, and time survived.
     * Also, renders all space objects, including the ship.
     */
    public void renderGame() {
        ui.setStat("Score", String.valueOf(model.getShip().getScore()));
        ui.setStat("Health", String.valueOf(model.getShip().getHealth()));
        ui.setStat("Level", String.valueOf(model.getLevel()));
        ui.setStat("Time Survived", ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
        ui.render(model.getSpaceObjects());
    }

    /**
     * Pauses the game, halting the game actions and displaying a pause message in the UI.
     */
    public void pauseGame() {
        ui.pause();
        ui.log("Game paused.");
    }

    /**
     * Handles player input, interpreting movement and action commands for the ship.
     * The input is checked for valid commands (W, A, S, D for movement, F for firing, and P for pausing).
     * Logs each action and updates the ship's position or performs the relevant action.
     *
     * @param input The player input as a string (e.g., "W", "A", "S", "D", "F", "P").
     */
    public void handlePlayerInput(String input) {
        input = input.toUpperCase(Locale.ROOT);
        if (input.equals("W")) {
            model.getShip().move(Direction.UP);
            ui.log("Core.Ship moved to (" + model.getShip().getX() + ", "
                    + model.getShip().getY() + ")");
        } else if (input.equals("S")) {
            model.getShip().move(Direction.DOWN);
            ui.log("Core.Ship moved to (" + model.getShip().getX() + ", "
                    + model.getShip().getY() + ")");
        } else if (input.equals("A")) {
            model.getShip().move(Direction.LEFT);
            ui.log("Core.Ship moved to (" + model.getShip().getX() + ", "
                    + model.getShip().getY() + ")");
        } else if (input.equals("D")) {
            model.getShip().move(Direction.RIGHT);
            ui.log("Core.Ship moved to (" + model.getShip().getX() + ", "
                    + model.getShip().getY() + ")");
        } else if (input.equals("F")) {
            model.fireBullet();
        } else if (input.equals("P")) {
            pauseGame();
        } else {
            ui.log("Invalid input. Use W, A, S, D, F, or P.");
        }
    }

    /**
     * Starts the main game loop.
     * Passes onTick and handlePlayerInput to ui.onStep and ui.onKey respectively.
     * @provided
     */
    public void startGame() {
        ui.onStep(this::onTick);

        ui.onKey(this::handlePlayerInput); // Pass Callback to UI
    }

    /**
     * Uses the provided tick to call and advance the following:
     *      - A call to renderGame() to draw the current state of the game.
     *      - A call to model.updateGame(tick) to advance the game by the given tick.
     *      - A call to model.checkCollisions() to handle game interactions.
     *      - A call to model.spawnObjects() to handle object creation.
     *      - A call to model.levelUp() to check and handle leveling.
     *
     * @param tick the provided tick
     * @provided
     */
    public void onTick(int tick) {
        renderGame(); // Update Visual
        model.updateGame(tick); // Update GameObjects
        model.checkCollisions(); // Check for Collisions
        model.spawnObjects(); // Handles new spawns
        model.levelUp(); // Level up when score threshold is met
    }

    /**
     * Returns the current instance of the GameModel.
     * This method provides access to the GameModel, which contains the game state and logic.
     *
     * @return The current instance of the GameModel.
     */
    public GameModel getModel() {
        return model;
    }
}

