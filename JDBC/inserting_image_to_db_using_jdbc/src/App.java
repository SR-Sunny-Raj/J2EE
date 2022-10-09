import java.io.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "sqluser", "Sql@2421");
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection established...");
            }
            String q = "insert into j2ee_table2(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            FileInputStream fis = new FileInputStream("E:\\Images\\Images\\heart01.jpg");
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            System.out.println("Values inserted...");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
