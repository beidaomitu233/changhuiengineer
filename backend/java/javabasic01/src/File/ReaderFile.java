package File;

import java.io.*;

public class ReaderFile {
    public static void main(String[] args) {


        Reader01 reader01 = new Reader01("E:\\FileContr\\a\\1.txt");
        try {
            reader01.ShowFileContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


class Reader01{

    private String FilePath=null;

    public Reader01(String filePath) {
        FilePath = filePath;

    }
    public void ShowFileContent() throws IOException {

        try(FileReader fileReader = new FileReader(FilePath)) {
            int FileDateBuffer=0;
            while ((FileDateBuffer=fileReader.read())!=-1){
                char character = (char) FileDateBuffer;
                System.out.print(character);
            }
        }catch (FileNotFoundException e) {
            System.err.println("File not found: " + FilePath);
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("Error reading the file.");
            e.printStackTrace();
        }
    }

}
