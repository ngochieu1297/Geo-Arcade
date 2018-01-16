package core;

import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    protected BufferedImage image;
    public boolean isAlive;

    static private Vector<GameObject> vector = new Vector<>();
    static private Vector<GameObject> newVector = new Vector<>();

    public static void add(GameObject gameObject) {
        newVector.add(gameObject);
    }

    public static void runAll() {
        for (GameObject gameObject : vector) {
            if(gameObject.isAlive) {
                gameObject.run();
            }
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public static void renderAll(Graphics graphics) {
        for(GameObject gameObject : vector) {
            if(gameObject.isAlive) {
                gameObject.render(graphics);
            }
        }
    }

    public static <T extends GameObject > T checkCollider(BoxCollider boxCollider, Class<T> cls) {
        for(GameObject gameObject : vector) {
            if(!gameObject.isAlive) continue;
            if(!cls.isInstance(gameObject)) continue;
            if(!(gameObject instanceof PhysicBody)) continue;
            BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
            if(boxCollider.checkBoxCollider(other)) {
                return (T) gameObject;
            }
        }
        return null;
    }

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
    }

    public void run() {

    }

    public void render(Graphics graphics) {
        if(this.image != null) {
            graphics.drawImage(image, (int)this.position.x - this.image.getWidth() / 2, (int)this.position.y - this.image.getHeight() / 2, null);
        }
    }
}
