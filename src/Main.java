import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> StudentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Course: ");
                String course = sc.nextLine();
                System.out.print("Enter Marks: ");
                double marks = sc.nextDouble();

                Student s = new Student(roll, name, course, marks);
                StudentList.add(s);
                System.out.println("✅ Student added successfully!");

            } else if (choice == 2) {
                if (StudentList.isEmpty()) {
                    System.out.println("📭 No students to show.");
                } else {
                    System.out.println("🎓 Student List:");
                    for (Student s : StudentList) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter Roll No of student to update: ");
                int roll = sc.nextInt();
                sc.nextLine();

                boolean found = false;
                for (Student s : StudentList) {
                    if (s.getRollNo() == roll) {
                        System.out.print("Enter new Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter new Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter new Marks: ");
                        double marks = sc.nextDouble();

                        s.setName(name);
                        s.setCourse(course);
                        s.setMarks(marks);

                        System.out.println("✅ Student updated successfully!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Student not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter Roll No of student to delete: ");
                int roll = sc.nextInt();

                boolean removed = false;
                for (Student s : StudentList) {
                    if (s.getRollNo() == roll) {
                        StudentList.remove(s);
                        System.out.println("🗑️ Student deleted successfully!");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("❌ Student not found.");
                }

            } else if (choice == 5) {
                System.out.println("👋 Exiting program. Goodbye!");
                break;

            } else {
                System.out.println("❗ Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
