import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String guestToAddOnList = scan.nextLine();

        TreeSet<String> guestList = new TreeSet<>();

        while (!"PARTY".equals(guestToAddOnList)) {

            if (guestToAddOnList.length() == 8) {
                guestList.add(guestToAddOnList);
            }

            guestToAddOnList = scan.nextLine();
        }

        String guestsArrived = scan.nextLine();

        while (!"END".equals(guestsArrived)) {

            guestList.remove(guestsArrived);

            guestsArrived = scan.nextLine();
        }

        System.out.println(guestList.size());

        for (String guestNotHere : guestList) {
            System.out.println(guestNotHere);
        }

    }
}
