package CarConstructors;

import Car.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<CarConstructors> cars = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            CarConstructors car;
            if (tokens.length == 1) {
                String brand = tokens[0];
                car = new CarConstructors(brand);
            } else {
                String brand = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new CarConstructors(brand, model,horsePower);
            }
            cars.add(car);
        }
        for (CarConstructors car: cars) {
            System.out.println(car.toString(car));
        }
    }
}
