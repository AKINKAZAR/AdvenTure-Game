package Game.Locations.NormalLocations;

import Game.Inventory.Inventory;
import Game.Locations.Location;
import Game.Player;

public abstract class NormalLoc extends Location {
    public NormalLoc(int id, Player player, String name) {
        super(id, player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
