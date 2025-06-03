import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    // Add student to DB
    public static void addStudent(Student s) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO students (roll_no, name, course, marks) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getRollNo());
            stmt.setString(2, s.getName());
            stmt.setString(3, s.getCourse());
            stmt.setDouble(4, s.getMarks());
            stmt.executeUpdate();
            System.out.println("✅ Student added to DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all students
    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int roll = rs.getInt("roll_no");
                String name = rs.getString("name");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");

                Student s = new Student(roll, name, course, marks);
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Update student by roll_no
    public static void updateStudent(Student s) {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE students SET name=?, course=?, marks=? WHERE roll_no=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getCourse());
            stmt.setDouble(3, s.getMarks());
            stmt.setInt(4, s.getRollNo());
            stmt.executeUpdate();
            System.out.println("✅ Student updated in DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student by roll_no
    public static void deleteStudent(int rollNo) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE roll_no=?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rollNo);
            stmt.executeUpdate();
            System.out.println("🗑️ Student deleted from DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
