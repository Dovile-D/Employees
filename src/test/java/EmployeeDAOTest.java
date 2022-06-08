import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EmployeeDAOTest {
    Employee localEmployee;
    @Before
    public void setUp() {
        localEmployee = new Employee("Ugne", "Barauskaite", 5891.56);
    }
    @Test
    public void createNewEntryTest() {
        EmployeeDAO.create(localEmployee);
        ArrayList<Employee> remoteEmployee = EmployeeDAO.searchByName("Ugne");
        // remoteEmployee is an ArrayList so comparing by index:
        compareEmployees(localEmployee, remoteEmployee.get(0));
    }

    public void compareEmployees(Employee localEmployee, Employee remoteEmployee) {
        Assert.assertEquals(localEmployee.getName(), remoteEmployee.getName());
        Assert.assertEquals(localEmployee.getSurname(), remoteEmployee.getSurname());
//        Assert.assertEquals(localEmployee.getSalary(), remoteEmployee.getSalary());
    }

}
