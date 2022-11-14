package _4_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires[] tires;

    public Car (String model, Engine engine, Cargo cargo, Tires[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return model;
    }

    public boolean hatTireWithLessPressureThanOne() {
        for (Tires tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
