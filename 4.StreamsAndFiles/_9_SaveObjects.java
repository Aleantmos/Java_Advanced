import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class _9_SaveObjects {
    public static void main(String[] args) throws Exception {

        List<String> names = new ArrayList<>();

        names.add("Martin");
        names.add("Pesho");
        names.add("Gosho");
        names.add("Optimus Prime");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("list.txt"));


        outputStream.writeObject(names);

        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.txt"));

        List<String> readName = inputStream.readObject();
    }
}
