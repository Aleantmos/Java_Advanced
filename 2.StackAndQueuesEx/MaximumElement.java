import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int commandsCnt = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < commandsCnt; i++) {
            String[] command = scan.nextLine().split(" ");

            switch (command[0]) {
                case "1":
                    int curr = Integer.parseInt(command[1]);
                    stack.push(curr);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    Integer max = Collections.max(stack);
                    System.out.println(max);
                    break;
            }
        }
    }
}
