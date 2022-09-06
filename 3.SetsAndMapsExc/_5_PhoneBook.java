import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!"search".equals(input)) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            phonebook.putIfAbsent(name, phoneNumber);
            if (phonebook.containsKey(name)) {
                phonebook.put(name, phoneNumber);
            }

            input = scan.nextLine();
        }

        String searchedName = scan.nextLine();
        while (!searchedName.equals("stop")) {

            if (phonebook.containsKey(searchedName)) {
                System.out.printf("%s -> %s%n", searchedName, phonebook.get(searchedName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchedName);
            }
            searchedName = scan.nextLine();
        }
    }
}
