import service.ReadProperties;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            ReadProperties readProperties = new ReadProperties(args[0], "config.properties");
            readProperties.read();
        } catch(Exception err) {
            System.err.println(err);
        }
    }
}
