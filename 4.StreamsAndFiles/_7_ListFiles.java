import java.io.File;

public class _7_ListFiles {
    public static void main(String[] args) {

        String fileName = "C:/Users/user/Desktop/SoftUni/3. Java Advanced/4. StreamsFilesDirectories/ressources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if(!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }


    }
}
