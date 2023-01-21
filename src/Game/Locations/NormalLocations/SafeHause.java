package Game.Locations.NormalLocations;

import Game.Locations.NormalLocations.NormalLoc;
import Game.Player;

public class SafeHause extends NormalLoc {

    public SafeHause(Player player) {
        super(1, player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("----------------------------- GÜVENLİ EV ------------------------------");
        System.out.print("Oyuncunun Canı Yenileniyor....   Can: " + getPlayer().getHealth() + " -> " );
        getPlayer().setHealth(getPlayer().getTempHealth());
        System.out.println(getPlayer().getHealth());
        getPlayer().selectLocation();
        return true;

    }
}
