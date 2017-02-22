package SnakeGUI;

import SnakeLogic.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by brunofloerke on 22/02/2017.
 */
public class Player implements GameObject {

    private int X;
    private int Y;
    Random random = new Random();

    @Override
    public void update() {

    }

    @Override
    public void draw(Controller controller) {
        // draw 'player'

        controller.g.setFill(Color.BLACK);
        controller.g.fillRoundRect(this.X * controller.getFieldWidth(), this.Y * controller.getFieldHeight(), controller.getFieldWidth(), controller.getFieldHeight(), 3, 3);
    }

    @Override
    public void getRandomPosition(Controller controller) {
        this.X = random.nextInt(controller.getWidth());
        this.Y = random.nextInt(controller.getHeight());
    }

    public void moveDown() {
        this.Y++;
    }

    public void moveLeft() {
        this.X--;
    }

    public void moveRight() {
        this.X++;
    }

    public void moveUp() {
        this.Y--;
    }
}
