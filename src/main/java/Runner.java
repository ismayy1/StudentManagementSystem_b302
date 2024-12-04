/*
 * Project: Student Management System
 * 1. Develop a student management system for any school.
 * 2. Users can:
 *    - C: Register a student.
 *    - R: View a student or a list of students.
 *    - U: Update a student by ID.
 *    - D: Delete a student by ID.
 * 3. Student Properties:
 *    - id, name, lastname, city, age.
 * Homework:
 *    - After deleting a student, display the details of the deleted student.
 *    - After adding a student, display the details of the added student.
 *    - Allow filtering students by first name and last name.
 */

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        StudentService service = new StudentService();

        int select;

        service.createStudentTable();

        do {
            System.out.println("==========================");
            System.out.println("Student Management System");
            System.out.println("1 - Register a Student");
            System.out.println("2 - List of all students");
            System.out.println("3 - Update a student");
            System.out.println("4 - Delete a student");
            System.out.println("5 - Find a student");
            System.out.println("6 - Generate Report for all Students");
            System.out.println("0 - Exit");
            System.out.println();
            System.out.println("Choose an operation");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    Student student = service.getInfo();
                    service.saveStudent(student);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:

                    break;
            }
        } while (select != 0);
    }

    private static int getId(Scanner scanner) {

        System.out.println("Student ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}
