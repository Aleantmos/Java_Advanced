import java.io.File;

public class _8_NestedFolder {
    public static int foldersCnt = 0;

    public static void main(String[] args) throws Exception {

        String fileName = "C:/Users/user/Desktop/SoftUni/3. Java Advanced/4. StreamsFilesDirectories/ressources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        dfs(file);

        System.out.println(foldersCnt + " folders");

    }

    public static void dfs(File file) {


        foldersCnt++;
        for (File f : file.listFiles()) {
            if(f.isDirectory()) {
                dfs(f);
            }
        }
        System.out.println(file.getName());

    }
}
