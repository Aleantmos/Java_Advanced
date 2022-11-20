import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] getVowels = scan.nextLine().split(" ");
        ArrayDeque<Character> vowelQueue = new ArrayDeque<>();
        for (String vowel : getVowels) {
            char vowelAsChar = vowel.charAt(0);
            vowelQueue.add(vowelAsChar);
        }

        String[] getConsonats = scan.nextLine().split(" ");
        ArrayDeque<Character> consonantStack = new ArrayDeque<>();
        for (String consonant : getConsonats) {
            char consonantAsChar = consonant.charAt(0);
            consonantStack.push(consonantAsChar);
        }

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        while (!consonantStack.isEmpty()) {

            char currVowel = vowelQueue.pop();
            char currConsonant = consonantStack.pop();

            for (int currWord = 0; currWord < words.length; currWord++) {

                String word = words[currWord];
                int indexVowel = word.indexOf(currVowel);
                int indexConsonant = word.indexOf(currConsonant);

                if (indexVowel >= 0) {
                    foundWords[currWord] = foundWords[currWord].substring(0, indexVowel) + currVowel + foundWords[currWord].substring(indexVowel + 1);
                }

                if (indexConsonant >= 0) {
                    foundWords[currWord] = foundWords[currWord].substring(0, indexConsonant) + currConsonant + foundWords[currWord].substring(indexConsonant + 1);
                }
            }
            vowelQueue.add(currVowel);
        }
        List<String> output = Arrays.stream(foundWords)
                .filter(word -> !word.contains("*"))
                .collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);

    }
}