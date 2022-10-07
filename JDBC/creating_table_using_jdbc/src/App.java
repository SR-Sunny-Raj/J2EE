import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Loading the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Creating the Connection
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "sqluser";
            String password = "Sql@2421";
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection established...");
            }
            // Writing query
            String q = "create table j2ee_table1(tName int(20) primary key auto_increment, tCity varchar(200) not null, tOccupation varchar(400))";

            // Creating statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);

            System.out.println("Table created succesfully...");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
