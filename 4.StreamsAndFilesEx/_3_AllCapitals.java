import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class _3_AllCapitals {
    private static final String INPUT_Path = "src/StreamsFilesDirectories/ressources/input.txt";
    private static final String OUTPUT_Path = "src/StreamsFilesDirectories/ressources/output.txt";

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_Path));
            PrintWriter writer = new PrintWriter(OUTPUT_Path )) {
            String line = reader.readLine();
            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
