package game.player;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import game.player.bullet.BulletPlayer;

public class PlayerShoot {
    private FrameCounter frameCounter = new FrameCounter(20);
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(new Vector2D(player.position.x + 10, player.position.y));
            BulletPlayer bulletPlayer1 = new BulletPlayer();
            bulletPlayer1.position.set(new Vector2D(player.position.x - 10, player.position.y));
            bulletPlayer.velocity.set(new Vector2D(0,5));
            bulletPlayer1.velocity.set(new Vector2D(0,5));
            GameObject.add(bulletPlayer);
            GameObject.add(bulletPlayer1);
            this.frameCounter.reset();
        }
    }
}

