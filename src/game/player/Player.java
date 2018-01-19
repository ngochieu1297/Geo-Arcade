package game.player;

import core.GameObject;
import game.player.bullet.Collision;
import game.player.bullet.CollisonSquare;
import input.MouseMotionInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import utils.Utils;

public class Player extends GameObject implements PhysicBody {
    private PlayerShoot playerShoot;
    private PlayerHealth playerHealth;
    private ImageRenderer imageRenderer;
    private PlayerLife playerLife;
    private AnimationRenderer animationRenderer;
    public BoxCollider boxCollider;
    public Collision collision;
    public CollisonSquare collisonSquare;

    public Player() {
        this.imageRenderer = new ImageRenderer("resources/player/straight.png");
        this.renderer = this.imageRenderer;
        this.animationRenderer = new AnimationRenderer("resources/player/straight.png",
                "resources/player/straight_white.png",
                "resources/player/straight.png",
                "resources/player/straight_white.png");
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(30,30);
        this.collision = new Collision();
        this.collisonSquare = new CollisonSquare();
        this.playerHealth = new PlayerHealth(5);
        this.playerLife = new PlayerLife();
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
        this.keepInMap();
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        this.collision.run(this);
        this.collisonSquare.run(this);
    }

    public void getHit() {
        this.isAlive = this.playerHealth.run();
        if(this.isAlive) {
            animationRenderer.looped = false;
            this.renderer = this.animationRenderer;
        }
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public void keepInMap() {
        if(this.position.x >= 360) {
            this.position.x = 360;
        }
        if(this.position.x <= 0) {
            this.position.x = 0;
        }
        if(this.position.y <= 0) {
            this.position.y = 0;
        }
        if(this.position.y >= 540) {
            this.position.y = 540;
        }
    }
}