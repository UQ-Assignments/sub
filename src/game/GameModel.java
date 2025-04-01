package game;


import game.core.*;
import game.utility.Logger;
import game.core.SpaceObject;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the game information and state. Stores and manipulates the game state.
 */
public class GameModel {
    public static final int GAME_HEIGHT = 20;
    public static final int GAME_WIDTH = 10;
    public static final int START_SPAWN_RATE = 2; // spawn rate (percentage chance per tick)
    public static final int SPAWN_RATE_INCREASE = 5; // Increase spawn rate by 5% per level
    public static final int START_LEVEL = 1; // Starting level value
    public static final int SCORE_THRESHOLD = 100; // Score threshold for leveling
    public static final int ASTEROID_DAMAGE = 10; // The amount of damage an asteroid deals
    public static final int ENEMY_DAMAGE = 20; // The amount of damage an enemy deals
    public static final double ENEMY_SPAWN_RATE = 0.5; // Percentage of asteroid spawn chance
    public static final double POWER_UP_SPAWN_RATE = 0.25; // Percentage of asteroid spawn chance

    private final Random random = new Random(); // ONLY USED IN this.spawnObjects()

    private List<SpaceObject> spaceObjects;
    private Ship ship;
    private int level;
    private Logger logger;
    private int spawnRate;

    /**
     * Models a game, storing and modifying data relevant to the game.
     * Logger argument should be a method reference to a .log method such as the UI.log method.
     * Example: Model gameModel = new GameModel(ui::log)
     * - Instantiates an empty list for storing all SpaceObjects the model needs to track.
     * - Instantiates the game level with the starting level value.
     * - Instantiates the game spawn rate with the starting spawn rate.
     * - Instantiates a new ship.
     * - Stores reference to the given logger.
     *
     * @param logger a functional interface for passing information between classes.
     */
    public GameModel(Logger logger) {
        this.logger = logger;
        this.spaceObjects = new ArrayList<>();
        this.level = START_LEVEL;
        this.spawnRate = START_SPAWN_RATE;
        this.ship = new Ship();
    }

    /**
     * Returns the current instance of the Ship.
     * @return The current Ship instance.
     */
    public Ship getShip() {
        return ship;
    }


    /**
     * Returns the list of SpaceObjects present in the game.
     * @return A list of SpaceObject instances.
     */
    public List<SpaceObject> getSpaceObjects() {
        return spaceObjects;
    }

    /**
     * Returns the current level of the game.
     * @return The current game level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Adds a SpaceObject to the list of spaceObjects in the game.
     * @param object The SpaceObject to be added.
     */
    public void addObject(SpaceObject object) {
        spaceObjects.add(object);
    }

    /**
     * Updates the game state by processing the tick for each space object and removing those
     * outside the game bounds.
     * @param tick The current tick or frame count in the game loop.
     */
    public void updateGame(int tick) {
        for (SpaceObject object : spaceObjects) {
            object.tick(tick);
        }
        List<SpaceObject> remainingObjects = new ArrayList<>();

        for (SpaceObject object : spaceObjects) {
            if (object.getY() <= GAME_HEIGHT) {
                remainingObjects.add(object);
            }
        }

        spaceObjects = remainingObjects;
    }

    /**
     * Checks for collisions between the ship and other space objects, such as power-ups,
     * asteroids, and enemies. The appropriate effects are applied and objects are removed if
     * they collide with the ship or other objects.
     */
    public void checkCollisions() {
        List<SpaceObject> toRemove = new ArrayList<>();

        for (SpaceObject object : spaceObjects) {
            if (ship.getX() == object.getX() && ship.getY() == object.getY()) {
                if (object instanceof HealthPowerUp) {
                    ((HealthPowerUp) object).applyEffect(ship);
                    logger.log("Power-up collected: " + object.render());
                    toRemove.add(object);

                } else if (object instanceof ShieldPowerUp) {
                    ((ShieldPowerUp) object).applyEffect(ship);
                    logger.log("Power-up collected: " + object.render());
                    toRemove.add(object);

                } else if (object instanceof Asteroid) {
                    ship.takeDamage(ASTEROID_DAMAGE);
                    logger.log("Hit by asteroid! Health reduced by " + ASTEROID_DAMAGE + ".");
                    toRemove.add(object);

                } else if (object instanceof Enemy) {
                    ship.takeDamage(ENEMY_DAMAGE);
                    logger.log("Hit by enemy! Health reduced by " + ENEMY_DAMAGE + ".");
                    toRemove.add(object);
                }
            }
        }

        for (SpaceObject object1 : spaceObjects) {
            for (SpaceObject object2 : spaceObjects) {
                if (object1.getX() == object2.getX() && object1.getY() == object2.getY()) {
                    if (object1 instanceof Bullet && object2 instanceof Enemy) {
                        toRemove.add(object1);
                        toRemove.add(object2);
                    }
                }
            }
        }
        spaceObjects.removeAll(toRemove);
    }


    /**
     * Fires a bullet from the current position of the ship and adds it to the space objects.
     */
    public void fireBullet() {

        Bullet bullet = new Bullet(getShip().getX(), getShip().getY());
        spaceObjects.add(bullet);
        logger.log("Core.Bullet fired!");
    }


    /**
     * Spawns new space objects, such as asteroids, enemies, and power-ups, at random positions
     * based on spawn rates.
     */
    public void spawnObjects() {
        if (random.nextInt(100) < spawnRate) {
            int x = random.nextInt(GAME_WIDTH);
            if (!(ship.getX() == x && ship.getY() == 0)) {
                addObject(new Asteroid(x, 0));
            }
        }

        if (random.nextInt(100) < spawnRate * ENEMY_SPAWN_RATE) {
            int x = random.nextInt(GAME_WIDTH);
            if (!(ship.getX() == x && ship.getY() == 0)) {
                addObject(new Enemy(x, 0));
            }
        }
        if (random.nextInt(100) < spawnRate * POWER_UP_SPAWN_RATE) {
            int x = random.nextInt(GAME_WIDTH);
            if (!(ship.getX() == x && ship.getY() == 0)) {
                if (random.nextBoolean()) {
                    addObject(new ShieldPowerUp(x, 0));
                } else {
                    addObject(new HealthPowerUp(x, 0));
                }
            }
        }
    }

    /**
     * Increases the game level if the score threshold for the current level is reached.
     * It also increases the spawn rate of new objects.
     */
    public void levelUp() {
        if (ship.getScore() >= getLevel() * SCORE_THRESHOLD) {
            spawnRate += SPAWN_RATE_INCREASE;
            level += 1;
            logger.log("Level Up! Welcome to Level " + level
                    + ". Spawn rate increased to " + spawnRate + "%.");
        }
    }

    /**
     * Sets the seed of the Random instance created in the constructor using .setSeed().
     *
     * This method should NEVER be called.
     *
     * @param seed to be set for the Random instance
     * @provided
     */
    public void setRandomSeed(int seed) {
        this.random.setSeed(seed);
    }
}
