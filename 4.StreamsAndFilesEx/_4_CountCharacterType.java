import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class _4_CountCharacterType {
    private static final String INPUT_PATH = "src/StreamsFilesDirectories/ressources/input.txt";
    private static final String OUTPUT_PATH = "src/StreamsFilesDirectories/ressources/output.txt";

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctuation  = Set.of('!', ',', '.', '?');
            int vowelsCnt = 0;
            int consonantCnt = 0;
            int punctuationCnt = 0;
            String line = reader.readLine();


            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCnt++;
                    } else if (punctuation.contains(symbol)) {
                        punctuationCnt++;
                    } else if (symbol != ' '){
                        consonantCnt++;
                    }
                }

                line = reader.readLine();
            }
            writer.println("Vowels: " + vowelsCnt);
            writer.println("Consonants: " + consonantCnt);
            writer.println("Punctuation: " + punctuationCnt);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
