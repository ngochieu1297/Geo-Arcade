package game.background;

import core.GameObject;
import utils.Utils;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.image = Utils.loadImage("resources/background/background.png");
    }

    @Override
    public void render(Graphics graphics) {
        if(image != null){
            graphics.drawImage(image, 0, 0, null);
        }
    }
}
