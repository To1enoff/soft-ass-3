
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseConnection {

    private static volatile DatabaseConnection instance;
    private static final Object lock = new Object();
    private Properties connectionProps;

    private DatabaseConnection() {
        // Load database properties
        connectionProps = new Properties();
        try {
            String homeDirectory = System.getProperty("user.home");
            connectionProps.load(new FileReader(  homeDirectory + "\\IdeaProjects\\soft-ass-3\\src\\dbconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Properties getConnectionProperties() {
        return connectionProps;
    }

    public void executeQuery(String sqlQuery) {

        System.out.println("Executing SQL query: " + sqlQuery);
    }
}
