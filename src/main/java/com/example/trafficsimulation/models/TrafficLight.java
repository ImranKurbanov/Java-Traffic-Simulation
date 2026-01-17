package com.example.trafficsimulation.models;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class TrafficLight {
    private double x, y;
    private Color color;
    private int counter = 0;

    public TrafficLight(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = Color.RED;
    }

    public void update() {
        counter++;

        if (counter < 200) {
            this.color = Color.RED;
        } else if (counter < 400) {
            this.color = Color.GREEN;
        } else if (counter < 500) {
            this.color = Color.YELLOW;
        } else {
            counter = 0;
        }
    }

    public void draw(GraphicsContext gc) {

        gc.setStroke(Color.WHITE);
        gc.setLineWidth(5);
        gc.strokeLine(this.x, 150, this.x, 450);

        gc.setFill(Color.BLACK);
        gc.fillRect(this.x - 15, 20, 30, 90);

        gc.setFill(this.color == Color.RED ? Color.RED : Color.DARKRED);
        gc.fillOval(this.x - 10, 25, 20, 20);

        gc.setFill(this.color == Color.YELLOW ? Color.YELLOW : Color.rgb(100, 100, 0));
        gc.fillOval(this.x - 10, 55, 20, 20);

        gc.setFill(this.color == Color.GREEN ? Color.LIME : Color.DARKGREEN);
        gc.fillOval(this.x - 10, 85, 20, 20);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public Color getColor() { return color; }
}