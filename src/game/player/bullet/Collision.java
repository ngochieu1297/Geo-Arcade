package game.player.bullet;

import core.GameObject;
import game.enemy.Enemy;
import game.player.Player;

public class Collision {
    public void run(Player player) {
        Enemy enemy = GameObject.checkCollider(player.boxCollider, Enemy.class);
        if(enemy != null) {
            player.getHit();
            enemy.getHit();
        }
    }
}
