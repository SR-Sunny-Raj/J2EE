import java.sql.*;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "sqluser", "Sql@2421");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
