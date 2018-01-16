package game.circlesquare;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import game.square.Square;

import java.util.Vector;

public class MatrixSquare extends GameObject {
    private Vector2D veclocity;
    private Vector<Square> squares;

    public MatrixSquare(){
        this.veclocity = new Vector2D(3,0);
        squares = new Vector<>();
        for (double angle = 0.0; angle <= 180.0; angle += 180.0/6) {
            Square square = new Square();
            square.position.set(new Vector2D(50, 10).rotate(angle)).addUp(60, 60);
            squares.add(square);
            GameObject.add(square);
        }
    }

    @Override
    public void run() {
        super.run();
        for (Square square : squares){
            if (square.position.x == 380) {
                this.veclocity.x = 0;
                this.veclocity.y = 3;
            }
        }

        for (Square square : squares) {
            square.velocity.set(this.veclocity);
        }
    }
}
