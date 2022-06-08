import java.util.ArrayList;
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


        // print all employees:

        ArrayList<Employee> employees = EmployeeDAO.searchById(1);
        if (employees.size() == 0) {
            System.out.println("No entries");
        }
        else {
            System.out.println(employees);
        }

        // search by name:
        ArrayList<Employee> employees1 = EmployeeDAO.searchByName("Jonas");
        if (employees.size() == 0) {
            System.out.println("No entries");
        }
        else {
            System.out.println(employees1);
        }

        // update entry:
        Employee employee1 = new Employee(1, "Jonas", "Basanavicius", 9542.48);
        EmployeeDAO.updateByID(employee1);
        System.out.println(employee1);

        // delete entry:
        EmployeeDAO.deleteById(6);

    }
}