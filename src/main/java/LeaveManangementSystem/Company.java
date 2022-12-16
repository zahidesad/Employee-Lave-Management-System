package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Company {

    static CEO ceo = new CEO();
    static ArrayList<Manager> managers = new ArrayList();
    static ArrayList<Employee> employees = new ArrayList();
    
    

    public static void createManager(String firstName, String lastName, String username) {
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
        manager.setUsername(username);
        managers.add(manager);

    }

    public static void createEmployee(String firstName, String lastName, String username, Manager manager,
             int totalDayLeaveValue) {
        for (Manager manager1 : managers) {
            if (username.equals(manager1.getUsername())) {
                System.out.println("This username already exist.");
                return;
            }
            
        }

        Employee employee = new Employee(firstName, lastName, username,totalDayLeaveValue);
        employee.randomIdGenerator();
        employee.setManager(manager);
        employee.setUsername(username);
       
        employees.add(employee);
        manager.WhoIsResponsibleEmployees(employee);

    }
}
