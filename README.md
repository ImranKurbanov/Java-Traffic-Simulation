# 🚦 Intelligent Traffic Flow Simulation

A **Java-based** traffic simulation system designed to visualize vehicle flow, intersection dynamics, and traffic light logic using **Object-Oriented Programming (OOP)** principles.

![Traffic Simulation Screenshot](https://github.com/user-attachments/assets/5b70af8f-8aaa-43f4-97fb-43125dede3b5)

## 🚀 Overview
This project simulates a real-time traffic control environment. Users can interact with the system to observe how different variables (speed, traffic light intervals) affect the flow of vehicles. It serves as a practical demonstration of **OOP concepts**, **GUI development**, and **state management**.

## ✨ Key Features (Seen in GUI)
* **Interactive Control Panel:**
    * **Start / Stop:** Pause and resume the simulation instantly.
    * **Clear:** Reset the simulation to a blank state.
    * **Speed Slider:** Dynamically adjust the simulation speed (1x to 5x) to stress-test the traffic logic.
* **Real-Time Data:**
    * Displays **Active Vehicle Count** and current **Simulation Speed** on screen.
* **Smart Traffic Lights:** Automated signaling system (Red/Yellow/Green) managing right-of-way.
* **Collision Avoidance:** Logic to ensure vehicles stop behind one another and respect traffic signals.

## 🛠️ Tech Stack
* **Language:** Java
* **GUI Library:** JavaFX
* **IDE:** IntelliJ IDEA
* **Core Concepts:**
    * **OOP:** Inheritance (Vehicle -> Car, Truck), Polymorphism, Encapsulation.
    * **Multi-threading:** Handling simulation loop and UI updates simultaneously.
    * **Graphics:** Custom rendering of roads and vehicles.

## 🏗️ Architecture
The project follows a modular design:
* **`SimulationManager`:** Controls the main loop and time steps.
* **`Vehicle` (Abstract):** Base class for all moving objects.
* **`Intersection`:** Manages the logic for traffic lights and lane merging.
* **`Renderer`:** Handles the drawing of the road, cars, and signals.

## 💻 How to Run
1.  Clone the repository:
    ```bash
    git clone https://github.com/ImranKurbanov/Java-Traffic-Simulation.git
    ```
2.  Open the project in **IntelliJ IDEA**.
3.  Locate `Main.java` inside the `src` folder.
4.  Run the application.

## 👤 Author
**Imran Kurbanov**
* Computer Engineering Student at Istanbul Commerce University
* [LinkedIn Profile](https://www.linkedin.com/in/imran-k-363777350/)

---
*Developed as a University Final Project demonstrating Software Engineering principles.*
