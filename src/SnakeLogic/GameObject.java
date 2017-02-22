package SnakeLogic;

import SnakeGUI.Controller;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * Created by Ebbe Vang on 23-01-2017.
 */
public interface GameObject {

    void update();

    void draw(Controller controller);

    void getRandomPosition(Controller controller);
}
