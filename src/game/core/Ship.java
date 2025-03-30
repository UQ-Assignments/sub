package game.core;

import game.ui.ObjectGraphic;

public class Ship extends Controllable{

    private int health;
    private int score;

    public Ship(int x, int y, int health) {
        super(x,y);
        this.health = health;
        this.score = 0;
    }

    public Ship() {
        this(5,10,100);
    }

    public ObjectGraphic render() {
        return new ObjectGraphic( "🚀", "assets/ship.png");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void heal(int amount) {
        this.health += amount;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getHealth() {
        return this.health;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public void tick(int tick) {
    }
}
