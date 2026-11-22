import java.io.File;
import java.io.IOException;

public class fileClass {
    public static void main(String[] args) {
        try {
            File f = new File("Hello.txt");

            if(f.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }

            System.out.println("Exists: " + f.exists());
            System.out.println("File name: " + f.getName());
            System.out.println("File Created at Path: " + f.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An Error Occoured");
        }
    }
}