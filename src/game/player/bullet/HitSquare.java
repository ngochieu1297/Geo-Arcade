package game.player.bullet;

import core.GameObject;
import game.square.Square;

public class HitSquare {
    public void run(BulletPlayer bulletPlayer) {
        Square square = GameObject.checkCollider(bulletPlayer.boxCollider, Square.class);
        if(square != null) {
            bulletPlayer.getHit();
            square.getHit();
        }
    }
}
