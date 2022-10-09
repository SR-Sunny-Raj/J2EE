import java.sql.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "sqluser", "Sql@2421");
            String q = "alter table j2ee_table2 modify pic longblob";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Succesfully altered...");
            System.out.println("Altered...");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
