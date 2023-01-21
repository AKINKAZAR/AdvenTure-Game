package Game.Locations.BattleLocations;

import Game.Obstacle.Obstacle;
import Game.Obstacle.Snake;
import Game.Player;

public class Mine extends BattleLoc{
    public Mine( Player player) {
        super(6, player, "Maden", new Snake());
    }
}
