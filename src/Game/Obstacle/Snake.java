package Game.Obstacle;

public class Snake extends Obstacle{
    public Snake() {
        super(4, (int)(Math.random()*3) + 3, 12, 0, "Yılan", 12);
    }
}
