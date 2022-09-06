import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input = scan.nextLine();
        String message;

        while (!"print".equals(input)) {
            if ("cancel".equals(input)){
                if (printerQueue.isEmpty()) {
                    message = "Printer is on standby";
                } else {
                    message = "Canceled " + printerQueue.pollFirst();
                }
                print(message);
            } else {
                printerQueue.offer(input);
            }
            input = scan.nextLine();
        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.pollFirst());
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
