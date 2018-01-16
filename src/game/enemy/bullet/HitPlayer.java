package game.enemy.bullet;

import core.GameObject;
import game.player.Player;

public class HitPlayer {
    public void run (BulletEnemy bulletEnemy) {
        Player player = GameObject.checkCollider(bulletEnemy.boxCollider, Player.class);
        if(player != null) {
            bulletEnemy.getHit();
            player.getHit();
        }
    }
}
