import java.util.Scanner;
import services.TransferData;

public class App {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");

            if(input.length < 3)
                throw new Exception("few arguments!");


            String filenameOrigin = input[0];
            String filenameDestiny = input[1];
            Integer SizeOfByteBlocks = Integer.valueOf(input[2]);

            TransferData td = new TransferData(filenameOrigin, filenameDestiny, SizeOfByteBlocks);
            Long begin = System.currentTimeMillis();
            td.transferFileData();
            Long end = System.currentTimeMillis();

            System.out.println("Process thoughput finish in " + (end - begin) + " ms");
        }

        catch(Exception err) {
            System.err.println(err);
        }
    }
}
