import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        dao.connect();
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Which operation you want to perform -:\n1) Get Student information\n2) Insert new Student's data\n3) Remove Student's data");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter roll no. -: ");
                int rollno = input.nextInt();
                Student s = dao.getStudent(rollno);
                System.out.println("Student's name with roll no. " + rollno + " is -: " + s.sname);
                break;
            case 2:
                System.out.println("Enter new Student's roll no. -: ");
                int rno = input.nextInt();
                System.out.println("Enter new Student's name -: ");
                String sname = input.next();
                dao.setStudent(rno, sname);
                System.out.println("Value succesfully inserted...");
                break;
            case 3:
                System.out.println("Enter the roll no. of the Student whose data you want to remove -: ");
                int rono = input.nextInt();
                dao.removeStudent(rono);
                System.out.println("Student's data succesfully removed...");
                break;
            default:
                System.out.println("User didn't gave the correct input...\nProgram Closed...");
        }
        input.close();
    }
}

class StudentDao {
    Connection con = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "sqluser", "Sql@2421");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(int rollno) {
        Student s = new Student();
        s.rollno = rollno;
        try {
            String q = "select sname from j2ee_table3 where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, rollno);
            ResultSet set = pstmt.executeQuery();
            set.next();
            String sname = set.getString("sname");
            s.sname = sname;
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setStudent(int rollno, String sname) {
        try {
            String q = "insert into j2ee_table3 values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, rollno);
            pstmt.setString(2, sname);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(int rollno) {
        try {
            String q = "delete from j2ee_table3 where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, rollno);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    int rollno;
    String sname;
}
