package game.circlesquare;

import core.GameObject;
import core.Vector2D;
import game.square.Square;

import java.util.Vector;

public class CircleSquare extends GameObject{
    Vector2D veclocity;
    Vector<Square> squares;

    public CircleSquare(){
        this.veclocity = new Vector2D(2,2);
        squares = new Vector<>();
        for (double angle = 0.0; angle <= 360.0; angle += 360.0/15) {
            Square square = new Square();
            square.position.set(new Vector2D(50,10).rotate(angle)).addUp(60,60);
            squares.add(square);
            GameObject.add(square);
        }
    }

    @Override
    public void run() {
        super.run();
        for (Square square : squares){
            if (square.position.x <= 0|| square.position.x >= 400) {
                this.veclocity.x = -this.veclocity.x;
                break;
            }

            if (square.position.y <= 0 || square.position.y >= 560) {
                this.veclocity.y = -this.veclocity.y;
                break;
            }
        }

        for (Square square : squares) {
            square.velocity.set(this.veclocity);
        }
    }
}
