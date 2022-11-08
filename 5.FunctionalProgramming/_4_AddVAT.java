import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _4_AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = val -> val * 1.2;

        System.out.println("Prices with VAT:");

        String values = Arrays.stream(scan.nextLine().split(", "))
                .map(e ->
                        String.format("%.2f", vatAdder.apply(Double.parseDouble(e))))
                        .collect(Collectors.joining(System.lineSeparator()));


        System.out.println(values);
    }
}
