package com.example.trafficsimulation.models;

import javafx.scene.paint.Color;

public abstract class Vehicle {
    protected double x, y;
    protected double speed;
    protected Color color;
    protected double width;
    protected double height;

    public Vehicle(double x, double y, double speed, Color color, double width, double height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public abstract void move();

    public double getX() { return x; }
    public double getY() { return y; }
    public Color getColor() { return color; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}