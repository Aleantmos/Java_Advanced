import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue =  new ArrayDeque();

        boolean isFound = false;

        String[] ops = scan.nextLine().split(" ");
        String[] nums = scan.nextLine().split(" ");

        for (int i = 0; i < ops.length; i++) {
            if (i == 0) {
                int reps = Integer.parseInt(ops[0]);
                for (int j = 0; j < reps; j++) {
                    int num = Integer.parseInt(nums[j]);
                    queue.offer(num);
                }
            } else if (i == 1) {
                int reps = Integer.parseInt(ops[1]);
                for (int j = 0; j < reps; j++) {
                    queue.poll();
                }
            } else if (i == 2) {
                int magicNum = Integer.parseInt(ops[2]);
                for (int number : queue) {
                    if (number == magicNum) {
                        isFound = true;
                        break;
                    }
                }
            }
        }
        if (!queue.isEmpty()) {
            if (isFound) {
                System.out.println(true);
            } else {
                int min = Collections.min(queue);
                System.out.println(min);
            }
        } else {
            System.out.println("0");
        }

    }
}
