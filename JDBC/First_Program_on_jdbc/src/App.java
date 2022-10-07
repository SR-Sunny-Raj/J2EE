import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creating the connection
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "sqluser";
            String password = "Sql@2421";

            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection established...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
