package com.example.trafficsimulation.models;

import javafx.scene.paint.Color;

public class Truck extends Vehicle {

    public Truck(double x, double y) {
        super(x, y, 2.5, Color.ORANGE, 80, 30);
    }

    @Override
    public void move() {
        this.x += this.speed;
    }
}

