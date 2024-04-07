
public class DataBaseConnectionCheck {

    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        System.out.println("Database Connection Properties:");
        dbConnection.getConnectionProperties().forEach((key, value) -> System.out.println(key + ": " + value));

        dbConnection.executeQuery("SELECT * FROM users");


    }
}
