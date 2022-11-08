package Car;

public class Car {

    private String brand;
    private String model;
    private int horsePower;


    public Car(String brandParam, String modelParam, int horsePowerParam) {
        brand = brandParam;
        model = modelParam;
        horsePower = horsePowerParam;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower (int horsePower) {
        this.horsePower = horsePower;
    }


    public String infoMethod(Car car) {
        return String.format("The car is: %s %s - %d HP.",
                car.getBrand(), car.getModel(), car.getHorsePower()
        );
    }

}
