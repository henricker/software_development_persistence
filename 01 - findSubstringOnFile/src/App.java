import java.io.BufferedReader;
import java.util.Scanner;

import services.BufferedReaderBuilder;

public class App {

    public static void main(String[] args) throws Exception {
        //create channel to send console data
        Scanner line = new Scanner(System.in);
        
        //Get data from console
        System.out.println("Enter the filename and string to search respectively.");
        String[] inputConsole = line.nextLine().split(" ");
        
        //Get bufferedReader to read lines 
        try(
            BufferedReader bufferedReader = new BufferedReaderBuilder(inputConsole[0])
            .buildInputStream()
            .buildInputStreamReader()
            .buildBufferedReader()
        )
        {
            int lineCounter = 1;
            String s = bufferedReader.readLine();
            while(s != null) {
              boolean containsSubstring = s.contains(inputConsole[1]);
              if(containsSubstring == true) {
                System.out.println("{ line: " + lineCounter + ", content: " + s + " }");
              }
              s = bufferedReader.readLine();
              lineCounter++;
            }
        } catch(Exception err) {
            System.out.println("not found file");
        }

        line.close();
    }
}
