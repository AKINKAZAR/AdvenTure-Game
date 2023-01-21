package Game.GameCharacter;

import Game.Inventory.Inventory;

public abstract class GameChar {

    private int id;
    private String name;
    private int damage;
    private int tempDamage;
    private int health;
    private int tempHealth;
    private int coin;

    public GameChar(int id, String name,int damage, int health, int coin, int tempDamage, int tempHealth) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
        this.tempDamage = tempDamage;
        this.tempHealth = tempHealth;
    }


    public int getTempDamage() {
        return tempDamage;
    }

    public void setTempDamage(int tempDamage) {
        this.tempDamage = tempDamage;
    }

    public int getTempHealth() {
        return tempHealth;
    }

    public void setTempHealth(int tempHealth) {
        this.tempHealth = tempHealth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
