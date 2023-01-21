package Game.Locations.BattleLocations;

import Game.Obstacle.Obstacle;
import Game.Obstacle.Vampire;
import Game.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(3, player, "Orman", new Vampire());
    }
}
