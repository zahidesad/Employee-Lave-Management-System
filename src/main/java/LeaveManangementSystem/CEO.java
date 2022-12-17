package LeaveManangementSystem;

import java.util.ArrayList;

/**
 *
 * @author zahid
 */
public class CEO extends Users {

    public static void createEmployee(String firstName, String lastName, String username, Manager manager,
            int numberOfLeavesLeft, int totalDayLeaveValue) {
        Company.createEmployee(firstName, lastName, username, manager, totalDayLeaveValue);
    }

    public static void createManager(String firstName, String lastName, String username,int totalDayLeaveValue) {
        Company.createManager(firstName, lastName, username, totalDayLeaveValue);

    }

    public void viewEmployeeWithPassword(ArrayList<Employee> employeeDetails) {
        System.out.println("\n\nEmployee List With Password");

        for (Employee employeeDetail : employeeDetails) {
            System.out.println("Name and surname are : " + employeeDetail.getFirstName()+ " " + employeeDetail.getLastName()
                    + "\t\tUsername is : " + employeeDetail.getUsername() + "\t\tPassword is : " + employeeDetail.getPassword());
        }

    }

    public void viewManagerWithPassword(ArrayList<Manager> managerDetails) {
        System.out.println("\n\nManager List With Password :");

        for (Manager managerDetail : managerDetails) {
            System.out.println("Name and surname are : " + managerDetail.getFirstName()+ " " + managerDetail.getLastName()
                    + "\t\tUsername is : " + managerDetail.getUsername() + "\t\tPassword is : " + managerDetail.getPassword());

        }

    }

    public void viewManagerWithoutPassword() {
        System.out.println("\n\nManager List :");

        for (int i = 0; i < Company.managers.size(); i++) {
            System.out.println((i + 1) + ") " + Company.managers.get(i).getFirstName() +" "+ Company.managers.get(i).getLastName()
                    + "\t-----> Number of emmployees responsible : " + Company.managers.get(i).getWhoIsResponsibleEmployees().size());

        }

    }

}
