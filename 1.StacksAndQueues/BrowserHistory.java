import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> memory = new ArrayDeque<>();
        String currUrl = scan.nextLine();
        String message;

        while (!"Home".equals(currUrl)) {

            if (currUrl.equals("back")) {
                if (memory.size() <= 1) {
                    message = "no previous URLs";
                    print(message);
                } else {
                    memory.pop();
                    print(memory.peek());
                }
            } else {
                memory.push(currUrl);
                print(currUrl);
            }
            currUrl = scan.nextLine();
        }
    }

    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
}
