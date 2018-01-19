import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.background.Background;
import game.circlesquare.CircleSquare;
//import game.circlesquare.MatrixSquare;
import game.circlesquare.MatrixSquare;
import game.enemy.EnemySpawner;
import game.player.bullet.BulletPlayer;
import game.player.Player;
import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBufferd;
    Graphics graphics;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.setupSquare();
        this.setupEnemy();
//        GameObjectManager.instance.add(new CircleSquare());
//        GameObjectManager.instance.add(new MatrixSquare());
    }

    private void setupBackground () {
        GameObjectManager.instance.add(GameObjectManager.instance.recycle(Background.class));
    }

    private void setupPlayer () {
        GameObjectManager.instance.recycle(Player.class);
    }

    private void setupBackBuffered () {
        this.backBufferd = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBufferd.getGraphics();
    }

    private void setupSquare () {
        GameObjectManager.instance.add(GameObjectManager.instance.recycle(SquareSpawner.class));
    }

    private void setupEnemy () {
        GameObjectManager.instance.add(GameObjectManager.instance.recycle(EnemySpawner.class));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferd, 0,0,null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
    }
}