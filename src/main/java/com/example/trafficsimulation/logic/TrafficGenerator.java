package com.example.trafficsimulation.logic;

import com.example.trafficsimulation.models.Car;
import com.example.trafficsimulation.models.Truck;
import com.example.trafficsimulation.models.Vehicle;

import java.util.List;
import java.util.Random;

public class TrafficGenerator {
    private Random random = new Random();

    public void trySpawnVehicle(List<Vehicle> vehicles) {

        if (random.nextInt(1000) < 8) {

            int lane = random.nextInt(2);
            double yPos = (lane == 0) ? 200 : 350;

            for (Vehicle v : vehicles) {
                if (v.getY() == yPos && v.getX() < 150) {
                    return;
                }
            }

            double startX = -100 - random.nextInt(50);
            if (random.nextDouble() < 0.3) {
                vehicles.add(new Truck(startX, yPos));
            } else {
                vehicles.add(new Car(startX, yPos));
            }
        }
    }
}