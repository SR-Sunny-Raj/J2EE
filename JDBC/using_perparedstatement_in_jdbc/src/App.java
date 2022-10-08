import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Loading driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creating connection
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "sqluser";
            String password = "Sql@2421";
            Connection con = DriverManager.getConnection(url, username, password);

            // Creating query
            String q = "insert into j2ee_table1(tCity,tOccupation) values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, "NewYork");
            pstmt.setString(2, "Engineer");

            pstmt.executeUpdate();

            System.out.println("Values inserted...");

            // Closing the connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
