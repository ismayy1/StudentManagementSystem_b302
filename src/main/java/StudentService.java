import java.util.List;
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

    public void getAllStudents() {

        List<Student> students = repository.findAll();
        System.out.println("========== All Students ==========");

        for (Student student : students) {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("ID: " + student.getId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("City: " + student.getCity());
            System.out.println("Age: " + student.getAge());
//            We have 1 student printed
            System.out.println("+++++++++++++++++++++++");
        }
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public Student getStudentById(int id) {

        Student student = repository.findById(id);
        return student;
    }

    public void findStudentById(int id) {

        Student student = getStudentById(id);

        if (student == null) {
            System.out.println("Student found with ID: " + id);
        } else {
            System.out.println(student);
        }
    }

    public void updateStudent(int id) {


    }
}
