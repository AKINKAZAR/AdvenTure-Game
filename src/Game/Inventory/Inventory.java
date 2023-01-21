package Game.Inventory;

public class Inventory {

    private boolean water;
    private boolean food;
    private boolean firewood;
    private int amount;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefense;

    public Inventory(boolean water, boolean food, boolean firewood, int amount, String weaponName, String armorName, int weaponDamage, int armorDefense) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.amount = amount;
        this.weaponName = weaponName;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefense = armorDefense;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }
}
