import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord {

    // Inner class to store student details
    static class Student {
        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("Student Records:");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            sc.nextLine(); // consume newline
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextDouble();
                            System.out.println("Student updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = students.removeIf(s -> s.id == deleteId);
                    if (removed) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println(" Student not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
