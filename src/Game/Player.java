package Game;

import Game.GameCharacter.Archer;
import Game.GameCharacter.GameChar;
import Game.GameCharacter.Knight;
import Game.GameCharacter.Samurai;
import Game.Inventory.Inventory;
import Game.Locations.BattleLocations.Cave;
import Game.Locations.BattleLocations.Forest;
import Game.Locations.BattleLocations.Mine;
import Game.Locations.BattleLocations.River;
import Game.Locations.Location;
import Game.Locations.NormalLocations.SafeHause;
import Game.Locations.NormalLocations.ToolStore;

import java.util.Scanner;

public class Player {
    private Scanner scanner = new Scanner(System.in);
    private GameChar gameChar;
    private Inventory inventory;
    private int damage;
    private int tempDamage;
    private int health;
    private int tempHealth;
    private int coin;
    private String charName;
    private String name;
    private boolean water = false;
    private boolean food = false;
    private boolean firewood = false;
    private int amount;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefense;

    public Player(String name) {
        this.name = name;
    }


    public boolean gameOver() {
        if (isFirewood() && isFood() && isWater()) {
            return true;
        } else {
            return false;
        }
    }

    public void gameOverMessage(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------ GAME OVER ------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void errorMessage() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("--------------- Bu Bölgenin Ödülü Alındı Tekrar Girilemez -------------");
        selectLocation();
    }

    public void selectLocation() {
        gameOver();
        if (gameOver()) {
           gameOverMessage();

        } else {
            Location[] locations = {new SafeHause(this), new ToolStore(this), new Forest(this), new Cave(this), new River(this), new Mine(this)};
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------------- LOKASYONLAR -----------------------------");
            for (Location loc : locations) {
                System.out.println("Lokasyon id -> " + loc.getId() + "\t Lokasyon Adı -> " + loc.getName());
            }
            System.out.println("-----------------------------------------------------------------------");

            System.out.print("Lokasyon Seçiniz:");
            int selectLocation = scanner.nextInt();

            Location location;
            switch (selectLocation) {
                case 1:
                    location = new SafeHause(this);
                    location.onLocation();
                    break;
                case 2:

                    location = new ToolStore(this);
                    location.onLocation();
                    break;
                case 3:
                    if (isFirewood()) {
                        errorMessage();
                    } else {
                        location = new Forest(this);
                        location.onLocation();
                    }
                    break;
                case 4:
                    if (isFood()) {
                        errorMessage();
                    } else {
                        location = new Cave(this);
                        location.onLocation();
                    }
                    break;
                case 5:
                    if (isWater()) {
                        errorMessage();
                    } else {
                        location = new River(this);
                        location.onLocation();
                    }
                    break;
                case 6:
                    location = new Mine(this);
                    location.onLocation();
                    break;
                default:
                    System.out.println("Oyundan Çıkış Yapıldı..");
            }
        }


    }

    public void showCharacters() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("----------------------------- KARAKTERLER -----------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Id -> " + gameChar.getId() +
                    "\t Karakter -> " + gameChar.getName() +
                    "   \tHasar -> " + gameChar.getDamage() +
                    "\t Sağlık -> " + gameChar.getHealth() +
                    "\t Para -> " + gameChar.getCoin());
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void selectChar() {
        showCharacters();
        boolean isSelectOkay = false;
        while (!isSelectOkay) {
            System.out.print("Karakter Seçiniz: ");
            int selectChar = scanner.nextInt();
            switch (selectChar) {
                case 1:
                    initPlayer(new Samurai());
                    isSelectOkay = true;
                    break;
                case 2:
                    initPlayer(new Archer());
                    isSelectOkay = true;
                    break;
                case 3:
                    initPlayer(new Knight());
                    isSelectOkay = true;
                    break;
                default:
                    System.out.println("Girilen Değer Belirlenen Id değerlerinin dışında!!");
            }
        }
        System.out.println("Seçilen Karakter -> " + this.getCharName() +
                "\t |\tHasar -> " + this.getDamage() +
                " \tSağlık -> " + this.getHealth() +
                " \tPara -> " + this.getCoin());

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
        this.setCharName(gameChar.getName());
        this.setTempDamage(gameChar.getTempDamage());
        this.setTempHealth(gameChar.getTempHealth());
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

