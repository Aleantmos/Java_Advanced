import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] ops = scan.nextLine().split(" ");
        String[] numbersSet = scan.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        int magicNum = 0;
        boolean isFound = false;

        for (int i = 0; i < ops.length; i++) {
            int reps = 0;
            if (i == 0) {
                reps = Integer.parseInt(ops[0]);
                for (int j = 0; j < reps; j++) {
                    stack.push(numbersSet[j]);
                }
            } else if (i == 1) {
                reps = Integer.parseInt(ops[1]);
                for (int j = 0; j < reps; j++) {
                    stack.pop();
                }
            } else {
                String num = ops[2];

                for (String nums : stack) {
                    if (nums.equals(num)) {
                        isFound = true;
                        break;
                    } else {
                        List<Integer> numbersSetInt = new ArrayList();
                        for (int j = 0; j < numbersSet.length; j++) {
                            numbersSetInt.add(Integer.parseInt(numbersSet[j]));
                        }
                        magicNum = Collections.max(numbersSetInt);
                    }
                }
            }
        }
        if (isFound){
            System.out.println(true);
        } else {
            System.out.println(magicNum);
        }
    }
}
