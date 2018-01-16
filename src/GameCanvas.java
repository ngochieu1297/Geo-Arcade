import core.GameObject;
import core.Vector2D;
import game.background.Background;
import game.circlesquare.CircleSquare;
import game.circlesquare.MatrixSquare;
import game.enemy.Enemy;
import game.enemy.EnemySpawner;
import game.player.bullet.BulletPlayer;
import game.player.Player;
import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Background background;
    BufferedImage backBufferd;
    Graphics graphics;
    Player player;
    BulletPlayer bulletPlayer;
    CircleSquare circleSquare;
    MatrixSquare matrixSquare;

    public int positionSquareY2 = 0;

    public Vector2D positionPlayer = new Vector2D(180, 280);

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.setupSquare();
        this.setupEnemy();
        GameObject.add(new CircleSquare());
        GameObject.add(new MatrixSquare());
    }

    private void setupBackground () {
        this.background = new Background();
    }

    private void setupPlayer () {
        this.player = new Player();
        this.bulletPlayer = new BulletPlayer();
        GameObject.add(player);
        GameObject.add(bulletPlayer);
    }

    private void setupBackBuffered () {
        this.backBufferd = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBufferd.getGraphics();
    }

    private void setupSquare () {
        GameObject.add(new SquareSpawner());
    }

    private void setupEnemy () {
        GameObject.add(new EnemySpawner());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferd, 0,0,null);
    }

    public void renderAll() {
        this.background.render(graphics);
        GameObject.renderAll(graphics);
        this.repaint();
    }

    public void runAll() {
        this.player.position.set(this.positionPlayer);
        GameObject.runAll();
    }
}