package game.square;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class SquareSpawner extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public SquareSpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(80);
    }

    public void run() {
        if(this.frameCounter.run()) {
            Square square = new Square();
            square.position.set(new Vector2D(random.nextInt(350),0));
            square.velocity.set(new Vector2D(0, random.nextInt(4) + 2));
            GameObjectManager.instance.add(square);
            this.frameCounter.reset();
        }
    }
}
