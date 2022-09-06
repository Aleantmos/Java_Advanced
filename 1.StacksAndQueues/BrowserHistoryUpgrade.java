import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        //todo

        
        String input = scan.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwards =  new ArrayDeque<>();

        String message;
        String currURL = input;
        String lastURL = "";

        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (history.isEmpty()) {
                    message = "no previous URLs";
                    print(message);
                } else {
                    //when history isn't empty

                    String currForwardToAdd = history.pop();
                    forwards.offer(currForwardToAdd);
                    message = history.peek();
                    print(message);
                }
            } else if ("forward".equals(input)) {
                if (forwards.isEmpty()) {
                    //when forwards is empty
                    message = "no next URLs";
                    print(message);
                } else {
                    //when forwards not empty
                    String currHistoryToAdd = forwards.poll();
                    history.add(currHistoryToAdd);
                    message = currHistoryToAdd;
                    print(message);
                }

            } else {


                lastURL = currURL;
                history.push(lastURL);

                currURL = input;
                message = currURL;
                print(message);

            }
            input = scan.nextLine();
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
