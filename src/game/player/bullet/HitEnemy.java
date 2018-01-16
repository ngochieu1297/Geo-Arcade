package game.player.bullet;

import core.GameObject;
import game.enemy.Enemy;

public class HitEnemy {
    public void run(BulletPlayer bulletPlayer) {
        Enemy enemy = GameObject.checkCollider(bulletPlayer.boxCollider, Enemy.class);
        if(enemy != null) {
            bulletPlayer.getHit();
            enemy.getHit();
        }
    }
}
