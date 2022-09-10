import java.util.LinkedHashSet;
import java.util.Scanner;

public class _1_ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        String command = input[0];
        String carNumber = "";

        LinkedHashSet<String> cars = new LinkedHashSet();

        while (!"END".equals(command)) {

            carNumber = input[1];


            if("IN".equals(command)) {
                cars.add(carNumber);
            } else if ("OUT".equals(command)) {
                cars.remove(carNumber);
            }

            input = scan.nextLine().split(", ");
            command = input[0];
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
