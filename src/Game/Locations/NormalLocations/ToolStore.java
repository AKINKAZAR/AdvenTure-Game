package Game.Locations.NormalLocations;

import Game.Inventory.WearableItems.Armors.Armors;
import Game.Inventory.WearableItems.Armors.Heavy;
import Game.Inventory.WearableItems.Armors.Light;
import Game.Inventory.WearableItems.Armors.Medium;
import Game.Inventory.WearableItems.Weapons.Gun;
import Game.Inventory.WearableItems.Weapons.Rifle;
import Game.Inventory.WearableItems.Weapons.Sword;
import Game.Inventory.WearableItems.Weapons.Weapons;
import Game.Inventory.WearableItems.WearableItem;
import Game.Locations.NormalLocations.NormalLoc;
import Game.Player;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    private Scanner scanner = new Scanner(System.in);

    public ToolStore(Player player) {
        super(2, player, "Mağaza");
    }

    @Override
    public boolean onLocation() {

        mainMenu();
        return true;
    }

    public void armorMenu() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------- ZIRHLAR -------------------------------");
        Armors[] armorList = {new Light(), new Medium(), new Heavy()};
        for (Armors armors : armorList) {
            System.out.println("Zırh | Id -> " + armors.getId() +
                    "\t Name -> " + armors.getName() +
                    "\t Defans -> " + armors.getDefense() +
                    "\t Para -> " + armors.getCoin());
        }
        System.out.println("-----------------------------------------------------------------------");
        buyArmor();
    }

    public void weaponMenu() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------- SİLAHLAR ------------------------------");
        Weapons[] weaponList = {new Gun(), new Sword(), new Rifle()};
        for (Weapons weapons : weaponList) {
            System.out.println("Silah | Id -> " + weapons.getId() +
                    "\t Name -> " + weapons.getName() +
                    "\t Hasar -> " + weapons.getDamage() +
                    "\t Para -> " + weapons.getCoin());
        }
        System.out.println("-----------------------------------------------------------------------");
        buyWeapon();
    }


    public void mainMenu() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("--------------------------- MAĞAZA ANA MENU ---------------------------");
        WearableItem[] itemList = {new Armors(), new Weapons()};
        for (WearableItem wearableItems : itemList) {
            System.out.println("Tür Id -> " + wearableItems.getTypeId() + "\t Eşya Türü -> " + wearableItems.getType());
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Üst menü için 0 tuşlayınız.");
        System.out.print("Eşya Türü Seçin: ");
        int selectType = scanner.nextInt();

        switch (selectType) {
            case 0:
                getPlayer().selectLocation();
                break;
            case 1:
                armorMenu();
                break;
            case 2:
                weaponMenu();
                break;
        }
    }

    public void chooseArmorForBuy(Armors armors) {
        if (getPlayer().getCoin() >= armors.getCoin()) {
            getPlayer().setArmorDefense(armors.getDefense());
            getPlayer().setArmorName(armors.getName());

            System.out.println("Satın alma başarılı. Ana menüye yönlendiriliyorsunuz");
            System.out.println("Hasar Engelleme -> " + getPlayer().getArmorDefense());
            getPlayer().setCoin(getPlayer().getCoin() - armors.getCoin());
            System.out.println("-----------------------------------------------------------------------");


            mainMenu();
        } else {
            System.out.println("                  !!!!!!!!! Yetersiz Bakiye !!!!!!!!!                  ");
            armorMenu();
        }

    }

    public void buyArmor() {
        System.out.println("Paranız: " + getPlayer().getCoin());
        System.out.println("Üst menü için 0 tuşlayınız.");
        System.out.print("Almak istediğiniz ürün ID giriniz:");
        int selectProduct = scanner.nextInt();
        switch (selectProduct) {
            case 0:
                mainMenu();
                break;
            case 1:
                chooseArmorForBuy(new Light());
                break;
            case 2:
                chooseArmorForBuy(new Medium());
                break;
            case 3:
                chooseArmorForBuy(new Heavy());
                break;
            default:
                System.out.println("aaaaa");
        }
    }


    public void chooseWeaponForBuy(Weapons weapons) {
        if (getPlayer().getCoin() >= weapons.getCoin()) {
            getPlayer().setWeaponDamage(weapons.getDamage());
            getPlayer().setWeaponName(weapons.getName());

            System.out.println("Satın alma başarılı. Ana menüye yönlendiriliyorsunuz");
            System.out.println("Yeni Hasar Değeri -> " + (getPlayer().getDamage() + getPlayer().getWeaponDamage()));
            getPlayer().setCoin(getPlayer().getCoin() - weapons.getCoin());
            System.out.println("-----------------------------------------------------------------------");
            mainMenu();
        } else {
            System.out.println("                  !!!!!!!!! Yetersiz Bakiye !!!!!!!!!                  ");
            weaponMenu();
        }
    }


    public void buyWeapon() {
        System.out.println("Üst menü için 0 tuşlayınız.");
        System.out.println("Paranız: " + getPlayer().getCoin());
        System.out.print("Almak istediğiniz ürün ID giriniz:");
        int selectProduct = scanner.nextInt();
        switch (selectProduct) {
            case 0:
                mainMenu();
                break;
            case 1:
                chooseWeaponForBuy(new Gun());
                break;
            case 2:
                chooseWeaponForBuy(new Sword());
                break;
            case 3:
                chooseWeaponForBuy(new Rifle());
        }
    }
}
