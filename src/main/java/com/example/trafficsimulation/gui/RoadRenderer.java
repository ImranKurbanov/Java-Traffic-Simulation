package com.example.trafficsimulation.gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RoadRenderer {

    public void drawRoad(GraphicsContext gc) {

        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, 800, 600);

        gc.setFill(Color.rgb(50, 50, 50));
        gc.fillRect(0, 150, 800, 300);

        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.setLineDashes(20);
        gc.strokeLine(0, 300, 800, 300);
        gc.setLineDashes(null);
    }
}