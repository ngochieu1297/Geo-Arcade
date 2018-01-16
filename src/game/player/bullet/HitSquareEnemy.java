package game.player.bullet;

import core.GameObject;
import game.enemy.bullet.BulletEnemy;

public class HitSquareEnemy {
    public void run(BulletPlayer bulletPlayer) {
        BulletEnemy bulletEnemy = GameObject.checkCollider(bulletPlayer.boxCollider, BulletEnemy.class);
        if(bulletEnemy != null) {
            bulletPlayer.getHit();
            bulletEnemy.getHit();
        }
    }
}
