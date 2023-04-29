package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    static String url = "jdbc:mysql://localhost:3306/";
    //database name
    static String dbName = "documents";
    //username and password
    static String userName = "root";
    static String password = "root";
    //create a new instance of the class
    static String driver = "com.mysql.cj.jdbc.Driver";
    static Connection connection;
    private DatabaseConnection(){}

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url + dbName, userName, password);
                System.out.println("Connected to the database");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            if(connection != null) {
                connection.close();
                connection = null;
            }else {
                System.out.println("Connection is null");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
