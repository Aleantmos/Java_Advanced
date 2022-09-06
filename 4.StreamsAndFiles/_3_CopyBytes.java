import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class _3_CopyBytes {
    public static void main(String[] args) throws Exception {


        String path = "C:\\Users\\user\\Desktop\\SoftUni\\3. Java Advanced\\4. StreamsFilesDirectories\\ressources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {

            if(singleByte == 10 || singleByte == 32) {
                writer.print((char)singleByte);
            } else {
                writer.print(singleByte);
            }

            singleByte = inputStream.read();
        }
        writer.close();
        inputStream.close();

    }
}
