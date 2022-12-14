import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
   //     Scanner scan = new Scanner(System.in);
//
//
   //     String[] input = scan.nextLine().split("\\s+");
   //     int toss = Integer.parseInt(scan.nextLine());
//
   //     ArrayDeque <String> people = new ArrayDeque<>();
//
   //     Collections.addAll(people, input);
//
   //     while (people.size() != 1) {
   //         for (int i = 1; i < toss; i++) {
   //             String current = people.poll();
   //             people.offer(current);
   //         }
   //         String removed = people.poll();
   //         System.out.println("Removed " + removed);
   //     }
   //     String lastChild = people.peek();
   //     System.out.println("Last is " + lastChild);
        //

        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s++");
        int rotations = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        for (int i = 0; i < children.length; i++) {
            childrenQueue.offer(children[i]);
        }

         while (childrenQueue.size() != 1) {
             for (int i = 1; i < rotations; i++) {
                 String currentChild = childrenQueue.poll();
                 childrenQueue.offer(currentChild);
             }
             String childToRemove = childrenQueue.poll();
             System.out.println("Removed " + childToRemove);
         }
         String lastChild = childrenQueue.peek();
         System.out.printf("Last is %s", lastChild);
    }
}




