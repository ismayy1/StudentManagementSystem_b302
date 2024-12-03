import java.util.Scanner;

public class StudentService {

    private StudentRepository repository = new StudentRepository();

    Scanner scanner = new Scanner(System.in);

    public void createStudentTable() {
        repository.createTable();
    }

    public Student getInfo() {

        System.out.println("Enter a first name:");    // "         adkhh       " ->
        String firstName = scanner.nextLine().trim();

        System.out.println("Enter a last name:");
        String lastName = scanner.nextLine().trim();

        System.out.println("Enter a city:");
        String city = scanner.nextLine().trim();

        System.out.println("Enter age:");
        Integer age = scanner.nextInt();
        scanner.nextLine();

        return new Student(firstName, lastName, city, age);
    }

    public void saveStudent(Student newStudent) {

        repository.save(newStudent);
    }
}
