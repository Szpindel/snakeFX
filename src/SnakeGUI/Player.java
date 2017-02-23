package SnakeGUI;

import SnakeLogic.GameObject;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by brunofloerke on 22/02/2017.
 */
public class Player implements GameObject {

    private int x;
    private int y;
    Random random = new Random();

    @Override
    public void update() {

    }

    @Override
    public void draw(Controller controller) {
        // draw 'player'

        controller.g.setFill(Color.BLACK);
        controller.g.fillRoundRect(this.x * controller.getFieldWidth(), this.y * controller.getFieldHeight(), controller.getFieldWidth(), controller.getFieldHeight(), 3, 3);
    }

    @Override
    public void getRandomPosition(Controller controller) {
        this.x = random.nextInt(controller.getWidth());
        this.y = random.nextInt(controller.getHeight());
    }

    public void moveDown() {
        this.y++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public void moveUp() {
        this.y--;
    }
}
