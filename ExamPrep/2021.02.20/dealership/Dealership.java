package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership (String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void add(Car car) {
        int size = this.data.size();
        if (size < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String givenManufacturer, String givenModel) {
        boolean carBought = false;
        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(givenManufacturer) && car.getModel().equals(givenModel)) {
                    data.remove(car);
                    carBought = true;
                    break;
                }
            }
        }
        return carBought;
    }

    public Car getLatestCar() {
        int latestYear = 0;
        Car latestCar = null;

        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getYear() > latestYear) {
                    latestYear = car.getYear();
                    latestCar = car;
                }
            }
        }
        return latestCar;
    }

    public Car getCar(String givenManufacturer, String givenModel) {
        Car carToReturn = null;
        if (!this.data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(givenManufacturer) && car.getModel().equals(givenModel)) {
                    carToReturn = car;
                }
            }
        }
        return carToReturn;
    }

    public int getCount() {
        int size = this.data.size();
        return size;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("The cars are in a car dealership %s:", getName()));
        for (Car car : data) {
            result.append(car.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

}
