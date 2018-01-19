package game.enemy;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import game.enemy.bullet.BulletEnemy;

public class Enemyshoot {
    private FrameCounter frameCounter = new FrameCounter(30);

    public void run(Enemy enemy) {
        if(this.frameCounter.run()) {
            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0,5);
            this.frameCounter.reset();
        }
    }
}
