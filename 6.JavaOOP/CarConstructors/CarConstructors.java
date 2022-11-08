package CarConstructors;

public class CarConstructors {
    private String brand;
    private String model;
    private int horsePower;

    public CarConstructors(String brand) {
        this(brand, "unknown", -1);
    }

    public CarConstructors(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() { return this.brand;}

    public String getModel() {return this.model;}

    public int getHorsePower() {return this.horsePower;}

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String toString(CarConstructors car) {
        return String.format("The car is: %s %s - %d HP.",
                car.getBrand(), car.getModel(), car.getHorsePower());
    }
}
