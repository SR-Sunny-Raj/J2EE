import java.util.Scanner;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "update j2ee_table1 set tCity=?, tOccupation=? where tName=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter new city -: ");
            String city = input.next();
            System.out.println("Enter new occupation -: ");
            String occup = input.next();
            System.out.println("Enter the id -: ");
            int ids = input.nextInt();
            pstmt.setString(1, city);
            pstmt.setString(2, occup);
            pstmt.setInt(3, ids);
            pstmt.executeUpdate();
            System.out.println("Data updated successfully...");
            con.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
