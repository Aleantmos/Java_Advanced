import java.io.*;
import java.nio.Buffer;

public class _5_WriteEveryThirdLine {
    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\user\\Desktop\\SoftUni\\3. Java Advanced\\4. StreamsFilesDirectories\\ressources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        BufferedReader reader = new BufferedReader(new FileReader(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));

        String line = reader.readLine();

        int lineNumber = 1;

        while (line != null) {
            lineNumber++;
            line = reader.readLine();

            if(lineNumber % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
        }
        writer.close();


    }
}
