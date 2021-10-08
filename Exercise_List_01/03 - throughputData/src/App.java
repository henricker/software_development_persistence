import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import services.TransferData;

public class App {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");

            if(input.length < 2)
                throw new Exception("few arguments!");


            String filenameOrigin = input[0];
            String filenameDestiny = input[1];

            TransferData td = new TransferData(filenameOrigin, filenameDestiny, 1);
            Long begin = System.currentTimeMillis();
            td.transferFileData();
            Long end = System.currentTimeMillis();


            Path pathDestiny = Paths.get("static/" + filenameOrigin);
            Long bytesDestiny = Files.size(pathDestiny);

            System.out.println("Transfer data to destiny file finish with success!");
            System.out.println("total time: " + (end - begin) + " ms");
            System.out.println("total size transferred: " + bytesDestiny + " bytes");
            System.out.println("throughput: " + bytesDestiny / (end - begin) + " bytes/ms");

            System.out.println("Process thoughput finish in " + (end - begin) + " ms");
        }

        catch(Exception err) {
            System.err.println(err);
        }
    }
}
