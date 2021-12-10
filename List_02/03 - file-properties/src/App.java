import java.util.Properties;
import java.util.Scanner;

import services.ReadPropertiesFile;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);

            String filename = scanner.next();

            ReadPropertiesFile rpf = new ReadPropertiesFile(filename);
            Properties prop = rpf.read();

            System.out.println("\n------ Start read ------\n");

            prop.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
            System.out.println("\n------ End read ------");

            scanner.close();
        } catch(Exception err) {
            System.err.println(err);
        }
    }
}
