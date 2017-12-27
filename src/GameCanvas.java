import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage square;
    BufferedImage backBufferd;
    Graphics graphics;

    public int positionPlayerX = 180;
    public int positionPlayerY = 280;

    public int positionSquareX = 80;
    public int positionSquareY = 0;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.setupBackBuffered();

        this.setupBackground();
        this.setupPlayer();

        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupBackground () {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupPlayer () {
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupBackBuffered () {
        this.backBufferd = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBufferd.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferd, 0,0,null);
    }

    public void renderAll() {
        this.graphics.drawImage(this.background,0,0,null);
        this.graphics.drawImage(this.player, this.positionPlayerX - 20, this.positionPlayerY - 40,null);
        this.graphics.drawImage(this.square, this.positionSquareX, this.positionSquareY,null);
        this.repaint();
    }
}
