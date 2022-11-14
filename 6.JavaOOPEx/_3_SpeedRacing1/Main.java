package _3_SpeedRacing1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());


        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelPerKm, 0);
            cars.put(model, car);
        }

        String line;

        while (!"End".equals(line = scan.nextLine())) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String model = tokens[1];
            double distanceTravelled = Double.parseDouble(tokens[2]);

            if (command.equals("Drive")) {
                double fuel = cars.get(model).getFuelAmount();
                double fuelPerKm = cars.get(model).getFuelPerKm();

                double capacity = fuel / fuelPerKm;

                if (capacity >= distanceTravelled && distanceTravelled != 0) {

                    double distanceAsFuel = distanceTravelled * fuelPerKm;
                    fuel -= distanceAsFuel;

                    cars.get(model).setFuelAmount(fuel);
                    cars.get(model).setDistanceTravelled(distanceTravelled);

                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
        for (Car car : cars.values()) {
            System.out.printf("%s %.2f %.0f%n", car.getModel(), car.getFuelAmount(), car.getDistance());
        }


    }
}
