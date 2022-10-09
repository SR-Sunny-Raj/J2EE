import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection con = ConnectionProvider.gConnection();
            String q = "select * from j2ee_table1";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()) {
                int id = set.getInt(1);
                String city = set.getString(2);
                String occup = set.getString(3);
                System.out.println(id + " : " + city + " : " + occup);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
