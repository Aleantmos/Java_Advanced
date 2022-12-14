import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _1_SumOfLines {
    private static final String Path = "src/StreamsFilesDirectories/ressources/input.txt";
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader(Path))) {

            String line = reader.readLine();
            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
