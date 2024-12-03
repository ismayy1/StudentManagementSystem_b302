public class Runner {
    public static void main(String[] args) {


    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        int select;
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
