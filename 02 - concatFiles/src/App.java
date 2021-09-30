import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import service.BufferedWriterBuilder;
import util.FileUtil;

public class App {
    public static void main(String[] args) {
        String[] filenames = null;
        try(Scanner scanner = new Scanner(System.in)) {
            filenames = scanner.nextLine().split(" ");

            if(filenames.length < 3) {
                System.out.println("To many arguments!");
                return;
            }

            try(
                BufferedWriter destinyFileOutput = new BufferedWriterBuilder(filenames[2])
                .buildOutputStream()
                .buildOutputStreamWriter()
                .buildBufferedWriter()
            )
            {    
                Long begin = System.currentTimeMillis();
                for(int i = 0; i <= 1; i++ )
                    FileUtil.concatFile(destinyFileOutput, filenames[i]);
                Long end = System.currentTimeMillis();

                //getting size of bytes
                Path path = Paths.get("static/" + filenames[2]);
                Long bytes = Files.size(path);
                

                System.out.println("Concat files with sucess!");
                System.out.println("Total time: " + (end - begin) + " ms");
                System.out.println("Total size: " + bytes + " bytes");
            }
        } 
        catch(Exception err) {
            System.out.println("Error: " + err.getMessage());
            File file = new File("static/" + filenames[2]);
            file.delete();
        }
    }
}
