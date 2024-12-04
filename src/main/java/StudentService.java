import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        System.out.println("Adding a student: " + newStudent);
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

        Student student = getStudentById(id);

        int deleted = repository.deleteById(id);

        if (deleted > 0) {
            System.out.println("Deleted Student: " + student);
        } else {
            System.out.println("No student found with ID: " + id);
        }
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

        Student foundStudent = getStudentById(id);

        if (foundStudent == null) {
            System.out.println("No Student found with ID: " + id);
        } else {
            Student newStudent = getInfo();
            scanner.nextLine();

            foundStudent.setFirstName(newStudent.getFirstName());
            foundStudent.setLastName(newStudent.getLastName());
            foundStudent.setCity(newStudent.getCity());
            foundStudent.setAge(newStudent.getAge());

            int updatedCount = repository.update(foundStudent);

            if (updatedCount > 0) {
                System.out.println("Student Updated successfully!");
            }
        }
    }

    public void generateReport() {

        try {
            System.out.println("Report is loading...");
            Thread.sleep(10000);

            List<Student> students = repository.findAll();
//            FileWriter fileWriter = new FileWriter("Student-report.txt");
            FileWriter fileWriter = new FileWriter(new File("Folder", "Student-report.txt"));

            fileWriter.write("Student Report\n");
            fileWriter.write("============================\n");

            for (Student student: students) {
                fileWriter.write("Student: " + student.getFirstName() + " " + student.getLastName() + "\n");

            }

            fileWriter.close();
            System.out.println("Report generated and saved into Student-report.txt");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
