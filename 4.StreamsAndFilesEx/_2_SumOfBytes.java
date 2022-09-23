import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _2_SumOfBytes {
    private static final String PATH = "src/StreamsFilesDirectories/ressources/input.txt";
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();
            int sum = 0;

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
