package Game.Locations.BattleLocations;

import Game.Obstacle.Obstacle;
import Game.Obstacle.Zombie;
import Game.Player;

public class Cave extends BattleLoc{
    public Cave( Player player) {
        super(4, player, "Mağara", new Zombie());
    }
}
