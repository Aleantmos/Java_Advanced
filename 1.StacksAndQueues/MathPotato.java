import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s++");
        int rotations = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            children.offer(input[i]);
        }
        int cycle = 1;
        boolean isPrime;
        while (children.size() != 1) {
            for (int i = 1; i < rotations; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            isPrime = checkPrime(cycle);
            if (!isPrime) {
                String childToRemove = children.poll();
                System.out.println("Removed " + childToRemove);
            } else if (isPrime) {
                String childToRemovePrime = children.peek();
                System.out.println("Prime " + childToRemovePrime);
            }
            cycle++;
        }
        String lastChild = children.peek();
        System.out.println("Last is " + lastChild);
    }

    public static boolean checkPrime (int cycle) {
        boolean isPrime = true;
        if (cycle == 1) {
            isPrime = false;
        } else {
            for (int i = cycle - 1; i > 1; i--) {
                if (cycle % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }
}
