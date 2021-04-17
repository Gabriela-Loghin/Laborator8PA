package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static Connect instance = null;
    private Connection connection;

    private Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "gabriela02");
            System.out.println("Connected successfully!");
        } catch (SQLException exception) {
            System.out.println("Something went wrong while trying to connect.");
            exception.printStackTrace();
        }
    }

    /***
     * Static method to create the instance of ConnectDataBase object
     */
    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}