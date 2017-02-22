package SnakeGUI;


import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.*;

public class Controller {

    @FXML
    Label labelStatus;
    @FXML
    Canvas canvas;

    private double fieldHeight;
    private double fieldWidth;
    private int width = 30;
    private int height = 20;
    private Random random = new Random();
    private int gameLoopDelay = 500;
    private float refreshRate = 300;

    private Player player = new Player();

    private KeyCode keyPressed = KeyCode.BACK_SPACE;
    public static GraphicsContext g;

    ArrayList<Item> items = new ArrayList<Item>();

    public void btnStartAction(ActionEvent event) {
        System.out.println("btn clicked");
        labelStatus.setText("test");
        getRandomPosition();
        drawCanvas();
    }

    /**
     * Executed when JavaFX is initialized. Used to setup the Snake game
     */
    public void initialize() {
        AddItems();

        calculateFields();
        getRandomPosition();
        //drawCanvas();

        // Start and control game loop
        new AnimationTimer() {
            long lastUpdate;

            public void handle(long now) {
                if (now > lastUpdate + refreshRate * 1000000) {
                    lastUpdate = now;
                    update(now);
                }
            }
        }.start();
    }

    private void AddItems() {
        items.add(new Item(Color.GREEN, 3, 3));
        items.add(new Item(Color.RED, 12, 9));


    }

    public void keyPressed(KeyCode keyCode) {
        this.keyPressed = keyCode;
    }

    /**
     * Game loop - executed continously during the game
     *
     * @param now game time in nano seconds
     */
    private void update(long now) {
        switch (keyPressed) {
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case RIGHT:
                player.moveRight();
                break;
            case UP:
                player.moveUp();
                break;
        }
        //getRandomPosition();
        drawCanvas();
        //System.out.println(now);

    }

    /**
     * Get a random position
     */


    private void getRandomPosition() {
    }

    /**
     * Calculate height and width of each field
     */
    private void calculateFields() {
        this.setFieldHeight(canvas.getHeight() / this.getHeight());
        this.setFieldWidth(canvas.getWidth() / this.getWidth());
    }

    /**
     * Draw the canvas - used in the gameloop
     */
    private void drawCanvas() {
        g = canvas.getGraphicsContext2D();

        g.clearRect(0, 0, getWidth() * getFieldWidth(), getHeight() * getFieldHeight());

        // draw all fields
        g.setFill(Color.WHITE);
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                g.fillRoundRect(i * getFieldWidth(), j * getFieldHeight(), getFieldWidth(), getFieldHeight(), 5, 5);
            }
        }

        // draw items
        for (Item item : items) {
            g.setFill(item.getColor());
            g.fillRoundRect(item.getX() * getFieldWidth(), item.getY() * getFieldHeight(), getFieldWidth(), getFieldHeight(), 5, 5);
        }

        player.draw(this);

    }

    public double getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(double fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public double getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(double fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
