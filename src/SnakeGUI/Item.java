package SnakeGUI;

import SnakeLogic.GameObject;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by Ebbe Vang on 19-01-2017.
 */
public class Item implements GameObject{
    private Color Color;
    private int x;
    private int y;
    Random random;

    public Item(Color color, int x, int y) {
        Color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return Color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void update() {

    }

    @Override
    public void getRandomPosition(Controller controller) {
        this.x = random.nextInt(controller.getWidth());
        this.x = random.nextInt(controller.getHeight());
    }

    @Override
    public void draw(Controller controller) {

    }
}
