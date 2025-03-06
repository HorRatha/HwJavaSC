
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Map<Integer, String> studentInfo = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    private static boolean addNewStudentName(String studentName) {
        int key = new Random().nextInt(999999);
        studentInfo.put(key, studentName);
        System.out.println("Student added with ID: " + key);
        return true;
    }

    private static boolean removeStudentById(int id) {
        String value = studentInfo.remove(id);
        return value != null;
    }

    private static boolean updateStudentById(int id, String newName) {
        if (studentInfo.containsKey(id)) {
            studentInfo.put(id, newName);
            return true;
        }
        return false;
    }

    private static void searchById() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentInfo.containsKey(id)) {
            System.out.println("Student found: ID = " + id + ", Name = " + studentInfo.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void home() {
        while (true) {
            System.out.println("""
                    1. Add Student Name
                    2. Search by ID
                    3. Delete Student by ID
                    4. Update Student by ID
                    5. Exit
                    """);
            System.out.print("Insert option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Insert student name to add record: ");
                    String name = scanner.nextLine();
                    addNewStudentName(name);
                    System.out.println(studentInfo);
                }
                case 2 -> searchById();
                case 3 -> {
                    System.out.print("Enter student ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (removeStudentById(id)) {
                        System.out.println("Student record deleted.");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (studentInfo.containsKey(id)) {
                        System.out.print("Enter new student name: ");
                        String newName = scanner.nextLine();
                        updateStudentById(id, newName);
                        System.out.println("Student record updated.");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        home();
    }
}