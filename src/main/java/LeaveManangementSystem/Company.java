package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class Company {

    static ArrayList<Users> users = new ArrayList();

    //static CEO ceo = new CEO();
    //static ArrayList<Manager> managers = new ArrayList();
    //static ArrayList<Employee> employees = new ArrayList();
    public static void createManager(String firstName, String lastName, String username, int totalDayLeaveValue) {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                if (username.equals(manager.getUsername())) {
                    System.out.println("This username already exist.");
                    return;
                }
            }
        }

        Manager manager = new Manager(firstName, lastName, username, totalDayLeaveValue);
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.randomIdGenerator();
        manager.setUsername(username);
        users.add(manager);

    }

    public static void createEmployee(String firstName, String lastName, String username, Manager manager,
            int totalDayLeaveValue) {
        for (Users user : Company.users) {
            if (user instanceof Employee && !(user instanceof Manager)) {
                Employee employee = (Employee) user;

                if (username.equals(employee.getUsername())) {
                    System.out.println("This username already exist.");
                    return;
                }

            }

        }

        Employee employee = new Employee(firstName, lastName, username, totalDayLeaveValue);
        employee.randomIdGenerator();
        employee.setManager(manager);
        employee.setUsername(username);

        users.add(employee);
        manager.SetWhoIsResponsibleEmployees(employee);

    }

    public static void removeEmployee(String removeUsername) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Employee && !(users.get(i) instanceof Manager)) {
                Employee employee = (Employee) users.get(i);
                
                if (employee.getUsername().equals(removeUsername)) {
                    users.remove(i);
                }
            }
        }

    }

    public static void removeManager(String removeUsername) {
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i) instanceof Manager)) {
                 Manager manager = (Manager) Company.users.get(i);
                
                if (manager.getUsername().equals(removeUsername)) {
                    users.remove(i);
                }
            }
        }
    }
}
