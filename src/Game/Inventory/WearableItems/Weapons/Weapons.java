package Game.Inventory.WearableItems.Weapons;

import Game.Inventory.WearableItems.WearableItem;

public class Weapons extends WearableItem {
    private int id;
    private String name;
    private int damage;
    private int coin;

    public Weapons(int typeId, String typeName, int id, String name, int damage, int coin) {
        super(typeId, typeName);
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.coin = coin;
    }

    public Weapons(){
        super(2,"Silah");

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

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
