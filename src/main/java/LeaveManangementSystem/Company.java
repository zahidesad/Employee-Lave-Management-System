package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Company {
    static CEO ceo;
    static ArrayList<Manager> managers = new ArrayList();
    static ArrayList<Employee> employees = new ArrayList();

    public static void createManager(String firstName, String lastName, String username, String password) {
        for (Manager manager1 : managers) {
            if (username.equals(manager1.getUsername())) {
                System.out.println("This username already exist.");
                return;
            }
        }

        Manager manager = new Manager();
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.randomIdGenerator();
        manager.setPassword(password);
        managers.add(manager);

    }

    public static void createEmployee(String firstName, String lastName, String username, Manager manager, String password) {
        for (Manager manager1 : managers) {
            if (username.equals(manager1.getUsername())) {
                System.out.println("This username already exist.");
                return;
            }
        }

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.randomIdGenerator();
        employee.setManager(manager);
        employee.setPassword(password);
        employees.add(employee);
        manager.WhoIsResponsibleEmployees(employee);

    }
}
