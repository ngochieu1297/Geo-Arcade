package game.player;

import core.GameObjectManager;

import java.util.Vector;

public class PlayerHealth {
    private int health;
    private Vector<PlayerLife> heart = new Vector<>();

    public PlayerHealth(int health) {
        this.health = health;
        for (int i = 1; i <= health; i++) {
            PlayerLife playerLife = GameObjectManager.instance.recycle(PlayerLife.class);
            playerLife.position.set(20 * i, 20);
            this.heart.add(playerLife);
        }
    }

    public boolean run() {
        if(this.health == 0){
            return false;
        } else {
            this.health -= 1;
            heart.elementAt(health).isAlive = false;
            return true;
        }
    }
}
