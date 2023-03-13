import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class getActiveData {

    getActiveData(){
        getInputData();
        getInputDataCounter();
    };

    public int numberOfInputTypes;
    public List<String> listOfFiles;


    private void getInputDataCounter(){
        List<String> fileNames = new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(".NN\\inputData"));
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {

        }
        System.out.println("File Count:"+fileNames.size());

        numberOfInputTypes = fileNames.size();
    }

    public void getInputData(){
        List<String> fileNames = new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(".NN\\inputData"));
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {

        }
        listOfFiles = fileNames;
    }
}
