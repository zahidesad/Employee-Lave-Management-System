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

    public static void createManager(String firstName, String lastName, String username, int totalDayLeaveValue) {
        for (Manager manager1 : managers) {
            if (username.equals(manager1.getUsername())) {
                System.out.println("This username already exist.");
                return;
            }
        }

        Manager manager = new Manager(firstName, lastName, username, totalDayLeaveValue);
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

        Employee employee = new Employee(firstName, lastName, username, totalDayLeaveValue);
        employee.randomIdGenerator();
        employee.setManager(manager);
        employee.setUsername(username);

        employees.add(employee);
        manager.SetWhoIsResponsibleEmployees(employee);

    }

    public static void removeEmployee(String removeUsername) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getUsername().equals(removeUsername)) {
                employees.remove(i);

            }
        }

    }
    public static void removeManager(String removeUsername){
         for (int i = 0; i < managers.size(); i++) {
             if (managers.get(i).getUsername().equals(removeUsername)) {
                 managers.remove(i);
             }
         }
    
    }
}
