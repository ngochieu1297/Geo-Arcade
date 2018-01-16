package game.enemy;

import core.FrameCounter;
import core.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public EnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = new Enemy();
            enemy.position.set(random.nextInt(350) + 30, 0);
            enemy.velocity.set(0, random.nextInt(2) + 2);
            GameObject.add(enemy);
            this.frameCounter.reset();
        }
    }
}