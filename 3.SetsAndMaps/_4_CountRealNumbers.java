import java.util.*;

public class _4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();

        Map<Double, Integer> valuesWithOcc = new TreeMap<>();

        for (double value : values) {
            if (!valuesWithOcc.containsKey(value)){
                valuesWithOcc.put(value, 1);
            } else {
                valuesWithOcc.put(value, valuesWithOcc.get(value) + 1);
            }
        }

        for (Double key: valuesWithOcc.keySet()) {
            System.out.printf("%.1f -> %d%n", key, valuesWithOcc.get(key));
        }

    }
}
