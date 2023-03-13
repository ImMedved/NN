import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;

public class ListOfArrays {
    public String[] keys;
    public String[] values;
    public ListOfArrays(LinkedList allData) throws FileNotFoundException {
        String path = null;
        JFileChooser j = new JFileChooser("D:");
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected file
            path = j.getSelectedFile().getAbsolutePath();
        }

        keys = (String[]) allData.get(0);
        values = (String[]) allData.get(1);

        PrintStream fileStream = new PrintStream(new File(path));
        for (int i = 0; i <= keys.length; i++) {
            fileStream.println("Q: " + keys[i]);
            fileStream.println("A: " + values[i]);
        }
    }
}
