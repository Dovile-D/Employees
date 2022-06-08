import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    // global variables:
    private static final String DATABASE_NAME = "employee_db";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public static void create(Employee employee) {
        String query = "INSERT into employees (name, surname, salary) VALUES (?, ?, ?)";
        // connect to database:
        String url = "jdbc.mysql://localhost:3306/" + DATABASE_NAME;
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
}
