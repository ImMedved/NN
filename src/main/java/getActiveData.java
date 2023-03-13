import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class getActiveData extends LinkedList {

    LinkedList getActiveData() {
        getInputDataCounter();
        getInputData();
        try {
            getFileInside(numberOfInputTypes, listOfFiles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Output;
    }

    public LinkedList Questions = new LinkedList();
    public LinkedList Answers = new LinkedList();
    public LinkedList Output = new LinkedList();

    public int numberOfInputTypes;
    public List<String> listOfFiles;

    private void getInputDataCounter() {
        List<String> fileNames = new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(".NN\\inputData"));
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {

        }
        System.out.println("File Count:" + fileNames.size());

        numberOfInputTypes = fileNames.size();
    }

    public void getInputData() {
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(".NN\\inputData"));
            for (Path path : directoryStream) {
                listOfFiles.add(path.toString());
            }
        } catch (IOException ex) {

        }
    }


    public void getFileInside(int numberOfInputTypes, List<String> listOfFiles) throws IOException {
        String path = new String();
        int j = 0;
        for (int i = 0; i <= numberOfInputTypes; i++) {
            path = listOfFiles.get(i);
            File file = new File(path);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String key = scanner.nextLine();
                String value = scanner.nextLine();
                Questions.add(j, key);
                Answers.add(j, value);
                j++;
            }
            j = 0;
        }
    }
    public void makeOutput(){
        if (Questions != null || Answers != null){
            Output.add(0, Questions);
            Output.add(1, Answers);
        }
    }
}




