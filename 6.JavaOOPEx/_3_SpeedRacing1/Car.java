package _3_SpeedRacing1;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelPerKm;
    private double distance = 0;

    public Car(String model, double fuelAmount, double fuelPerKm, double distance) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
        this.distance = distance;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getFuelPerKm() {
        return this.fuelPerKm;
    }

    public void setFuelAmount (double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTravelled (double distance) {
        this.distance += distance;
    }

    public String getModel() {
        return model;
    }

    public double getDistance() {
        return distance;
    }
}
