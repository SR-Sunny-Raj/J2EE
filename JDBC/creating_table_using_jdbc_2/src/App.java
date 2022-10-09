import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "sqluser", "Sql@2421");
            if (con.isClosed()) {
                System.out.println("Connection is closed...");
            } else {
                System.out.println("Connection established...");
            }

            String q = "create table j2ee_table2(id int(20) primary key auto_increment, pic blob)";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table created...");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
