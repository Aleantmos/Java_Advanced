import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class _6_SortLines {
    public static void main(String[] args) throws Exception{

        String fileName = "C:\\Users\\user\\Desktop\\SoftUni\\3. Java Advanced\\4. StreamsFilesDirectories\\ressources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        List<String> lines = Files.readAllLines(Paths.get(fileName))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("out.txt"), lines);
    }
}
