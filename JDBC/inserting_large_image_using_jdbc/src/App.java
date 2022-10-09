import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection c = ConnectionProvider.getConnection();
            String q = "insert into j2ee_table2(pic) values(?)";
            PreparedStatement pstmt = c.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Image inserted...");
            System.out.println("Image inserted");
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
