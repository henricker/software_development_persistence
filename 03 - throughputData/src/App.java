import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import services.BufferedReaderBuilder;
import services.BufferedWriterBuilder;


public class App {
    public static void main(String[] args) {
        String[] filenames = null;
        try(Scanner scanner = new Scanner(System.in)) {
            filenames = scanner.nextLine().split(" ");

            if(filenames.length < 2) {
                System.out.println("To many arguments!");
                return;
            }

            try(
                BufferedReader fileOrigin = new BufferedReaderBuilder(filenames[0])
                .buildInputStream()
                .buildInputStreamReader()
                .buildBufferedReader();
                
                BufferedWriter fileDestiny = new BufferedWriterBuilder(filenames[1])
                .buildOutputStream()
                .buildOutputStreamWriter()
                .buildBufferedWriter()
            ) 
            {
                Long begin = System.currentTimeMillis();

                int byteValue = fileOrigin.read();
                while(byteValue != -1) {
                    fileDestiny.write(byteValue);
                    byteValue = fileOrigin.read();
                }
                
                Long end = System.currentTimeMillis();

                Path pathDestiny = Paths.get("static/" + filenames[1]);
                Long bytesDestiny = Files.size(pathDestiny);

                System.out.println("Transfer data to destiny file finish with success!");
                System.out.println("total time: " + (end - begin) + " ms");
                System.out.println("total size transferred: " + bytesDestiny + " bytes");
                System.out.println("throughput: " + bytesDestiny / (end - begin) + " bytes/ms");
            }
        } 
        catch(Exception err) {
            System.out.println("Error: " + err.getMessage());
            File file = new File("static/" + filenames[1]);
            file.delete();
        }
    }
}