import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _2_WriteToFile {
    public static void main(String[] args) throws IOException {


        String input = "C:\\Users\\user\\Desktop\\SoftUni\\3. Java Advanced\\4. StreamsFilesDirectories\\ressources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(input);
        FileOutputStream outputStream = new FileOutputStream("out.txt");


        PrintWriter writer = new PrintWriter(outputStream);

        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('!');
        punctuations.add('?');



        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            char symbol = (char) singleByte;
            if (!punctuations.contains(symbol)) {
                writer.print(symbol);
            }
            singleByte = inputStream.read();
        }

        writer.close();
        inputStream.close();
    }
}
