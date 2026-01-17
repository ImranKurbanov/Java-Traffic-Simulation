package com.example.trafficsimulation.logic;

import com.example.trafficsimulation.models.TrafficLight;
import com.example.trafficsimulation.models.Vehicle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.List;

public class SimulationManager {

    public void updateVehicles(GraphicsContext gc, List<Vehicle> vehicles, TrafficLight light) {

        Iterator<Vehicle> iterator = vehicles.iterator();

        while (iterator.hasNext()) {
            Vehicle v = iterator.next();
            boolean mustStop = false;

            double vehicleFront = v.getX() + v.getWidth();
            double stopLine = light.getX();

            if (light.getColor() == Color.RED || light.getColor() == Color.YELLOW) {
                if (vehicleFront > stopLine - 50 && vehicleFront < stopLine) {
                    mustStop = true;
                }
            }

            // Collision
            for (Vehicle other : vehicles) {
                if (v != other && v.getY() == other.getY()) {
                    if (other.getX() > v.getX()) {
                        double gap = other.getX() - (v.getX() + v.getWidth());
                        if (gap < 20) {
                            mustStop = true;
                        }
                    }
                }
            }

            if (!mustStop) {
                v.move();
            }

            if (v.getX() > 850) {
                iterator.remove();
            } else {
                drawVehicle(gc, v, mustStop);
            }
        }
    }

    private void drawVehicle(GraphicsContext gc, Vehicle v, boolean isStopped) {
        // Body
        gc.setFill(v.getColor());
        gc.fillRect(v.getX(), v.getY(), v.getWidth(), v.getHeight());

        // Roof
        gc.setFill(v.getColor().darker());
        gc.fillRect(v.getX() + 10, v.getY() + 2, v.getWidth() - 20, v.getHeight() - 4);

        // Wheels
        gc.setFill(Color.BLACK);
        gc.fillRect(v.getX() + 5, v.getY() + v.getHeight(), 10, 5);
        gc.fillRect(v.getX() + v.getWidth() - 15, v.getY() + v.getHeight(), 10, 5);
        gc.fillRect(v.getX() + 5, v.getY() - 5, 10, 5);
        gc.fillRect(v.getX() + v.getWidth() - 15, v.getY() - 5, 10, 5);

        if (isStopped) {
            gc.setFill(Color.RED);
            gc.fillOval(v.getX(), v.getY(), 5, 5);
            gc.fillOval(v.getX(), v.getY() + v.getHeight() - 5, 5, 5);
        } else {
            gc.setFill(Color.YELLOW);
            gc.fillOval(v.getX() + v.getWidth() - 2, v.getY(), 5, 5);
            gc.fillOval(v.getX() + v.getWidth() - 2, v.getY() + v.getHeight() - 5, 5, 5);
        }
    }
}