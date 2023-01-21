package Game.Obstacle;

import java.util.Scanner;

public class Obstacle {
    private Scanner scanner = new Scanner(System.in);
    private int id;
    private int damage;
    private int health;
    private int coin;
    private String name;
    private int fullHealth;

    public Obstacle(int id, int damage, int health, int coin, String name, int fullHealth) {
        this.fullHealth = fullHealth;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
        this.name = name;
    }

    public int obstacleNumber(){
        return (int)(Math.random() * 3) + 1;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
