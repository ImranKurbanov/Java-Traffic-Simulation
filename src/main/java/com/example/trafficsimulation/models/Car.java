package com.example.trafficsimulation.models;

import javafx.scene.paint.Color;

public class Car extends Vehicle {

    public Car(double x, double y) {
        super(x, y, 5.0, Color.BLUE, 40, 20);
    }

    @Override
    public void move() {
        this.x += this.speed;
    }
}
