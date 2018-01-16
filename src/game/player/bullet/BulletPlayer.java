package game.player.bullet;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import utils.Utils;

public class BulletPlayer extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;
    private HitEnemy hitEnemy;
    private  HitSquareEnemy hitSquareEnemy;

    public BulletPlayer() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.hitSquare = new HitSquare();
        this.hitEnemy = new HitEnemy();
        this.hitSquareEnemy = new HitSquareEnemy();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitSquare.run(this);
        this.hitEnemy.run(this);
        this.hitSquareEnemy.run(this);
    }

    public void getHit() {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
