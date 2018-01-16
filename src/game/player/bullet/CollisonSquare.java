package game.player.bullet;

import core.GameObject;
import game.player.Player;
import game.square.Square;

public class CollisonSquare {
    public void run(Player player) {
        Square square = GameObject.checkCollider(player.boxCollider, Square.class);
        if(square != null) {
            player.getHit();
            square.getHit();
        }
    }
}
