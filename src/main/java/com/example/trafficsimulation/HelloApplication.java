package com.example.trafficsimulation;

import com.example.trafficsimulation.gui.RoadRenderer;
import com.example.trafficsimulation.logic.SimulationManager;
import com.example.trafficsimulation.logic.TrafficGenerator;
import com.example.trafficsimulation.models.TrafficLight;
import com.example.trafficsimulation.models.Vehicle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane mainLayout = new BorderPane();
        Pane simPane = new Pane();
        Canvas canvas = new Canvas(800, 550);
        simPane.getChildren().add(canvas);
        mainLayout.setCenter(simPane);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        List<Vehicle> vehicles = new ArrayList<>();
        TrafficLight light = new TrafficLight(600, 0);

        RoadRenderer roadRenderer = new RoadRenderer();
        TrafficGenerator trafficGenerator = new TrafficGenerator();
        SimulationManager simManager = new SimulationManager();

        Slider speedSlider = new Slider(1.0, 5.0, 1.0);
        speedSlider.setShowTickMarks(true);
        speedSlider.setShowTickLabels(true);
        speedSlider.setMajorTickUnit(1.0);
        speedSlider.setBlockIncrement(1.0);
        speedSlider.setPrefWidth(150);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int loops = (int) speedSlider.getValue();

                for (int i = 0; i < loops; i++) {

                    roadRenderer.drawRoad(gc);

                    trafficGenerator.trySpawnVehicle(vehicles);

                    light.update();
                    light.draw(gc);

                    simManager.updateVehicles(gc, vehicles, light);
                }

                gc.setFill(Color.BLACK);
                gc.fillText("Active Vehicles: " + vehicles.size(), 10, 20);
                gc.fillText("Sim Speed: " + loops + "x", 10, 40);
            }
        };

        HBox controlPanel = new HBox(15);
        controlPanel.setStyle("-fx-background-color: #333; -fx-padding: 15; -fx-alignment: center;");

        Button btnStart = createButton("Start", "#4CAF50", e -> timer.start());
        Button btnStop = createButton("Stop", "#f44336", e -> timer.stop());
        Button btnReset = createButton("Clear", "#2196F3", e -> {
            vehicles.clear();
            roadRenderer.drawRoad(gc);
            light.draw(gc);
        });

        Label lblSpeed = new Label("Speed:");
        lblSpeed.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        controlPanel.getChildren().addAll(btnStart, btnStop, btnReset, lblSpeed, speedSlider);
        mainLayout.setBottom(controlPanel);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setTitle("Traffic Simulation - Final Project");
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();
    }

    private Button createButton(String text, String color, javafx.event.EventHandler<javafx.event.ActionEvent> action) {
        Button btn = new Button(text);
        btn.setStyle("-fx-font-size: 14; -fx-base: " + color + "; -fx-text-fill: white;");
        btn.setPrefWidth(100);
        btn.setOnAction(action);
        return btn;
    }


    public static void main(String[] args) {
        launch();
    }
}