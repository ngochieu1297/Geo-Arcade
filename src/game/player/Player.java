package game.player;

import core.GameObject;
import game.player.bullet.Collision;
import game.player.bullet.CollisonSquare;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class Player extends GameObject implements PhysicBody {
    private PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    public Collision collision;
    public CollisonSquare collisonSquare;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(30,30);
        this.collision = new Collision();
        this.collisonSquare = new CollisonSquare();
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        this.collision.run(this);
        this.collisonSquare.run(this);
    }

    public void getHit() {
        this.isAlive = false;
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}