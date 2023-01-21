package Game.Inventory.WearableItems.Armors;

import Game.Inventory.WearableItems.WearableItem;

public class Armors extends WearableItem {

    private int id;
    private String name;
    private int defense;
    private int coin;

    public Armors(int typeId, String typeName, int id, String name, int defense, int coin) {
        super(typeId, typeName);
        this.id = id;
        this.name = name;
        this.defense = defense;
        this.coin = coin;
    }

    public Armors(){
        super(1,"Zırh");

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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
