import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "sqluser";
            String password = "Sql@2421";

            Connection con = DriverManager.getConnection(url, username, password);

            String q = "insert into j2ee_table1(tCity,tOccupation) values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter City -: ");
            String var1 = input.next();
            System.out.println("Enter Occupation -: ");
            String var2 = input.next();

            pstmt.setString(1, var1);
            pstmt.setString(2, var2);

            pstmt.executeUpdate();
            System.out.println("Values inserted...");

            input.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
