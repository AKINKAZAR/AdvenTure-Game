package Game.Locations.BattleLocations;

import Game.Inventory.WearableItems.Armors.Heavy;
import Game.Inventory.WearableItems.Armors.Light;
import Game.Inventory.WearableItems.Armors.Medium;
import Game.Inventory.WearableItems.Weapons.Gun;
import Game.Inventory.WearableItems.Weapons.Rifle;
import Game.Inventory.WearableItems.Weapons.Sword;
import Game.Locations.Location;
import Game.Obstacle.Obstacle;
import Game.Player;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;

    public BattleLoc(int id, Player player, String name, Obstacle obstacle) {
        super(id, player, name);
        this.obstacle = obstacle;
    }

    public void winMessage() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------ Kazandınız -----------------------------");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void getReward() {
        if (obstacle.getId() == 1) {
            getPlayer().setFood(true);
            System.out.println("Yemek Kazandınız.");
        } else if (obstacle.getId() == 2) {
            getPlayer().setFirewood(true);
            System.out.println("Odun Kazandınız.");
        } else if (obstacle.getId() == 3) {
            getPlayer().setWater(true);
            System.out.println("Su Kazandınız.");
        }
        winMessage();
    }

    public void playerHit() {
        obstacle.setHealth(obstacle.getHealth() - getPlayer().getDamage());
        System.out.println(getPlayer().getName() + " " + getPlayer().getDamage() + " Hasar verdi");
        System.out.println(getPlayer().getName() + " Can -> " + getPlayer().getHealth());
        System.out.println(obstacle.getName() + " Can -> " + obstacle.getHealth());

        System.out.println("-----------------------------------------------------------------------");

    }

    public void monsterHit() {
        int sumTakenDamage = obstacle.getDamage() - getPlayer().getArmorDefense();
        if (sumTakenDamage <= 0) {
            System.out.println("Hasar Engellendi.");
            sumTakenDamage = 0;
        } else {
            getPlayer().setHealth(getPlayer().getHealth() - sumTakenDamage);
        }


        System.out.println(obstacle.getName() + " " + sumTakenDamage + " Hasar verdi.");
        System.out.println(getPlayer().getName() + " Can -> " + getPlayer().getHealth());
        System.out.println(obstacle.getName() + " Can -> " + obstacle.getHealth());
        System.out.println("-----------------------------------------------------------------------");
    }

    public int hitFirst() {
        return (int) (Math.random() * 100);
    }

    public void MineRandomReward() {
        int totalChance = (int) (Math.random() * 100);
        int weaponTypeChange = (int) (Math.random() * 100);
        int armorTypeChange = (int) (Math.random() * 100);
        int coinAmountChange = (int) (Math.random() * 100);

        if (totalChance <= 15) {
            if (weaponTypeChange <= 50) {
                Gun gun = new Gun();
                getPlayer().setWeaponDamage(gun.getDamage());
                System.out.println(gun.getName() + " Kazandınız.");
            } else if (weaponTypeChange <= 80) {
                Sword sword = new Sword();
                getPlayer().setWeaponDamage(sword.getDamage());
                System.out.println(sword.getName() + " Kazandınız.");
            } else {
                Rifle rifle = new Rifle();
                getPlayer().setWeaponDamage(rifle.getDamage());
                System.out.println(rifle.getName() +" Kazandınız.");
            }
        } else if (totalChance <= 30) {
            if (armorTypeChange <= 50) {
                Light light = new Light();
                getPlayer().setArmorDefense(light.getDefense());
                System.out.println(light.getName() +" Zırh Kazandınız.");
            } else if (armorTypeChange <= 80) {
                Medium medium = new Medium();
                getPlayer().setArmorDefense(medium.getDefense());
                System.out.println(medium.getName() + "Zırh Kazandınız.");
            } else {
                Heavy heavy = new Heavy();
                getPlayer().setArmorDefense(heavy.getDefense());
                System.out.println(heavy.getName() + "Zırh Kazandınız.");
            }
        } else if (totalChance <= 55) {
            if (coinAmountChange <= 50) {
                getPlayer().setCoin(getPlayer().getCoin() + 1);
                System.out.println("1 Para Kazandınız");
            } else if(coinAmountChange <= 80){
                getPlayer().setCoin(getPlayer().getCoin() + 5);
                System.out.println("5 Para Kazandınız");
            } else {
                getPlayer().setCoin(getPlayer().getCoin() + 10);
                System.out.println("10 Para Kazandınız");
            }
        } else {
            System.out.println("Bir item Kazanamadınız....!!");
        }
    }

    public void combat() {
        int monsterNumber = obstacle.obstacleNumber();
        int i = 0;
        int whoHitfirst = hitFirst();
        while (i < monsterNumber) {
            if (getPlayer().getHealth() > 0) {
                if (obstacle.getHealth() > 0) {
                    if (whoHitfirst <= 50) {
                        playerHit();
                        if (obstacle.getHealth() <= 0) {
                            if (obstacle.getName().equals("Yılan")){
                                MineRandomReward();
                            }
                            i++;
                            getPlayer().setCoin(getPlayer().getCoin() + obstacle.getCoin());
                            if (i == monsterNumber) {
                                getReward();
                                getPlayer().selectLocation();
                                break;
                            } else {
                                obstacle.setHealth(obstacle.getFullHealth());
                            }
                        }
                        if (i != (obstacle.obstacleNumber())) {
                            monsterHit();
                        }
                    } else {
                        if (i != (obstacle.obstacleNumber())) {
                            monsterHit();
                        }
                        playerHit();
                        if (obstacle.getHealth() <= 0) {
                            i++;
                            getPlayer().setCoin(getPlayer().getCoin() + obstacle.getCoin());
                            if (i == monsterNumber) {
                                getReward();
                                getPlayer().selectLocation();
                                break;
                            } else {
                                obstacle.setHealth(obstacle.getFullHealth());
                            }
                        }
                    }

                }

            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("----------------------------- Kaybettiniz -----------------------------");
                System.out.println("-----------------------------------------------------------------------");
                getPlayer().gameOverMessage();
                break;
            }
        }
    }

    @Override
    public boolean onLocation() {
        combat();
        return getPlayer().getHealth() != 0;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
