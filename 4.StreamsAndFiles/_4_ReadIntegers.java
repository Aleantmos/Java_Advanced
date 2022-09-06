import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _4_ReadIntegers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\user\\Desktop\\SoftUni\\3. Java Advanced\\4. StreamsFilesDirectories\\ressources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileWriter writer = new FileWriter("out.txt");

        Scanner scan = new Scanner(inputStream);

        while (scan.hasNext()) {
            if(scan.hasNextInt()) {
                int number = scan.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scan.next();
        }
        writer.flush();
        writer.close();
    }
}
