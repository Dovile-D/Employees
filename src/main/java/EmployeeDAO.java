import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    // global variables:
    private static final String DATABASE_NAME = "employee_db";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void create(Employee employee) {
        String query = "INSERT INTO employee (name, surname, salary) VALUES (?, ?, ?);";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try {
            // create connection to database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful");
            // prepare database query (read given string):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1:
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setDouble(3, employee.getSalary());
            // run prepared query:
            preparedStatement.executeUpdate();

            // close connection to database:
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed. Read more: ");
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> searchById (int id) {
        String query = "SELECT * FROM employee WHERE id = ?;";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        // array list to store entries from result set:
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            // create connection to database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful");
            // prepare database query (read given string):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            // create result set:
            while (resultSet.next()) {
                employees.add(new Employee(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getDouble("salary")
                ));
            }

            // close connection to database:
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed. Read more: ");
            e.printStackTrace();
        }
        return employees;
    }

    public static ArrayList<Employee> searchByName(String name) {
        String query = "SELECT * FROM employee WHERE name LIKE ?;";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        // array list to store entries from result set:
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            // create connection to database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful");
            // prepare database query (read given string):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            // create result set:
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDouble("salary")
                ));
            }

            // close connection to database:
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed. Read more: ");
            e.printStackTrace();
        }
        return employees;
    }

    public static void updateByID(Employee employee) {
        String query = "UPDATE employee SET name = ?, surname = ?, salary = ? WHERE id = ?;";
        // connect to database:
        String url = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
        try {
            // create connection to database:
            Connection connection = DriverManager.getConnection(url, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connection successful");
            // prepare database query (read given string):
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // get values from Main starting from index 1:
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getSurname());
            preparedStatement.setDouble(4, employee.getSalary());
            // run prepared query:
            preparedStatement.executeUpdate();

            // close connection to database:
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            System.out.println("Connection failed. Read more: ");
            e.printStackTrace();
        }
    }
}
