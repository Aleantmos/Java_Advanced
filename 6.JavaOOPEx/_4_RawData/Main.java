package _4_RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();


        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tires[] tires = new Tires[4];

            int cnt = 0;
            for (int j = 5; j < tokens.length; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int age = Integer.parseInt(tokens[j + 1]);
                tires[cnt] = new Tires(tirePressure, age);
                cnt++;
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.putIfAbsent(model, car);

        }
        String cargoType = scan.nextLine();
        for (Car car : cars.values()) {
            if(cargoType.equals("flamable")
                    && "flamable".equals(car.getCargo().getCargoType())) {
                int enginePower = car.getEngine().getEnginePower();
                if (enginePower > 250) {
                    System.out.println(car.getModel());
                }
            } else if(cargoType.equals("fragile")
                    && "fragile".equals((car.getCargo().getCargoType()))) {
                if (car.hatTireWithLessPressureThanOne()) {
                    System.out.println(car.getModel());
                }

            }
        }
    }
}
