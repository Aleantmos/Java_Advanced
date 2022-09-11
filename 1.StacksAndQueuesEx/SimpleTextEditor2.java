import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int operationsCnt = Integer.parseInt(scan.nextLine());

        StringBuilder textToManipulate = new StringBuilder();
        ArrayDeque<String> memory = new ArrayDeque();
        ArrayDeque<String> elementsStorage = new ArrayDeque();


        String input = scan.nextLine();
        String[] inputSplit = input.split(" ");
        String command = inputSplit[0];
        String data = inputSplit[1];
        switch (command) {
            case "1":
                memory.push(input);
                addData(data, textToManipulate);
                break;
            case "2":
                int endIndex = textToManipulate.length();
                int startIndex = endIndex - Integer.parseInt(data);
                StringBuilder elementsToDel = new StringBuilder();
                for (int j = startIndex; j < endIndex; j++) {
                    elementsToDel.append(textToManipulate.charAt(j));
                }
                elementsStorage.push(elementsToDel.toString());
                memory.push(input);
                deleteData(data,textToManipulate);
                break;
            case "3":
                int index = Integer.parseInt(data);
                char number = textToManipulate.charAt(index);
                System.out.println(number);
                break;
            case "4":
                String lastInput = memory.pop();
                String lastInputSplit[] = lastInput.split(" ");
                String lastCommand = lastInputSplit[0];
                String lastData = lastInputSplit[1];

                switch (lastCommand) {
                    case "1":
                        int tempCnt = lastData.length();
                        deleteData(tempCnt, textToManipulate);
                        break;
                    case "2":
                        break;
                }
                break;
        }
    }

    private static void deleteData(String data, StringBuilder textToManipulate) {

        int dataInt = Integer.parseInt(data);
        textToManipulate.delete(dataInt,textToManipulate.length());

    }

    private static void addData(String data, StringBuilder textToManipulate) {
        textToManipulate.append(data);
    }
}
