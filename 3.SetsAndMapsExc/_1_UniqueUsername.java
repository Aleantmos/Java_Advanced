import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_UniqueUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());

        Set<String> users = new LinkedHashSet<>();

        while (lines-- > 0) {
            String user = scan.nextLine();
            if (!users.contains(user)) {
                users.add(user);
            }
        }
        users.forEach(user -> System.out.println(user));
    }
}
