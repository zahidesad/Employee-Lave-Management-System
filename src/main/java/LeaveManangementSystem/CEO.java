package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class CEO extends Users {
    
    

    public static void createEmployee(String firstName, String lastName, String username, Manager manager, String password) {
        Company.createEmployee(firstName, lastName, username, manager, password);
    }

    public static void createManager(String firstName, String lastName, String username, String password) {
        Company.createManager(firstName, lastName, username, password);

    }

    public void viewEmployeeWithPassword(ArrayList<Employee> employeeDetails) {
        System.out.println("Employee List With Password");

        for (Employee employeeDetail : employeeDetails) {
            System.out.println("Name and surname are : " + employeeDetail.getFirstName() + employeeDetail.getLastName()
                    + "\t\tUsername is : " + employeeDetail.getUsername() + "\t\tPassword is : " + employeeDetail.getPassword());
        }

    }

    public void viewManagerWithPassword(ArrayList<Manager> managerDetails) {
        System.out.println("Manager List With Password");

        for (Manager managerDetail : managerDetails) {
            System.out.println("Name and surname are : " + managerDetail.getFirstName() + managerDetail.getLastName()
                    + "\t\tUsername is : " + managerDetail.getUsername() + "\t\tPassword is : " + managerDetail.getPassword());

        }

    }

}
