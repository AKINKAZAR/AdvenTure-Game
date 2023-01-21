package Game.Locations.BattleLocations;

import Game.Obstacle.Bear;
import Game.Obstacle.Obstacle;
import Game.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(5, player, "Nehir", new Bear());
    }
}
