import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create:
        Scanner scan = new Scanner(System.in);
        System.out.println("enter employee name\n");
        String name = scan.nextLine();
        System.out.println("enter employee surname\n");
        String surname = scan.nextLine();
        System.out.println("enter employee salary\n");
        Double salary = scan.nextDouble();

        Employee employee = new Employee(name, surname, salary);
        EmployeeDAO.create(employee);
    }
}
