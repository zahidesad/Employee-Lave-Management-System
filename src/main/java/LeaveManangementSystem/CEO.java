package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class CEO extends Users {

    Scanner scan = new Scanner(System.in);

    public void createEmployee(String firstName, String lastName, String username, Manager manager,
            int numberOfLeavesLeft, int totalDayLeaveValue) {
        Company.createEmployee(firstName, lastName, username, manager, totalDayLeaveValue);
    }

    public void createManager(String firstName, String lastName, String username, int totalDayLeaveValue) {
        Company.createManager(firstName, lastName, username, totalDayLeaveValue);

    }

    public void removeEmployee(String removeUsername) {
        Company.removeEmployee(removeUsername);

    }

    public void removeManager(String removeUsername) {
        Company.removeManager(removeUsername);

    }

    //print all the leave requests of manager (CEO)
    @Override
    public void requests() {
        for (Manager manager : Company.managers) {
            System.out.println("\n\nName and surname are : " + ConsoleColorsCode.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                    + " wants for " + manager.getNumberOfLeaveRequest() + " days leave" + "\n" + ConsoleColorsCode.RESET);
        }

    }

    public void confirmationForManagerLeaves(CEO ceo) {
        for (Manager manager : Company.managers) {
            if (manager.getNumberOfLeaveRequest() != 0) {
                System.out.println(ConsoleColorsCode.GREEN_BOLD + manager.getUsername()
                        + " wants for " + manager.getNumberOfLeaveRequest() + " days leave" + "\n" + ConsoleColorsCode.RESET);

                int a;
                System.out.println("Please Select the action you want to do : ");
                System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                a = scan.nextInt();

                switch (a) {
                    //if CEO confirms the request
                    case 1:
                        int leave = manager.getNumberOfLeavesLeft();
                        int deduct = manager.getNumberOfLeaveRequest();
                        leave -= deduct;

                        manager.updateLeave(leave);
                        int used = manager.getUsedLeave() + manager.getNumberOfLeaveRequest();

                        manager.setUsedLeave(used);
                        manager.setNumberOfLeaveRequest(0);
                        System.out.println(ConsoleColorsCode.GREEN_BOLD + "Leaves granted.\n" + ConsoleColorsCode.RESET);
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println(ConsoleColorsCode.RED_BOLD + "Leaves Rejected.\n" + ConsoleColorsCode.RESET);
                        manager.setNumberOfLeaveRequest(0);
                        break;

                    case 3:
                        System.out.println(ConsoleColorsCode.GREEN_BOLD + "\n\nLogging out from the system..." + ConsoleColorsCode.RESET);
                        break;
                    default:
                        break;

                }

            } else {
                continue;
            }

        }
    }

    public void viewEmployeeWithPassword(ArrayList<Employee> employeeDetails) {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nEmployee List With Password :" + ConsoleColorsCode.RESET);

        for (Employee employeeDetail : employeeDetails) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + employeeDetail.getFirstName() + " " + employeeDetail.getLastName()
                    + ConsoleColorsCode.RESET + "\t\tUsername is : " + ConsoleColorsCode.GREEN_BOLD + employeeDetail.getUsername() + ConsoleColorsCode.RESET
                    + "\t\tPassword is : " + ConsoleColorsCode.GREEN_BOLD + employeeDetail.getPassword() + ConsoleColorsCode.RESET);
        }

    }

    public void viewManagerWithPassword(ArrayList<Manager> managerDetails) {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nManager List With Password :" + ConsoleColorsCode.RESET);

        for (Manager managerDetail : managerDetails) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + managerDetail.getFirstName() + " " + managerDetail.getLastName()
                    + ConsoleColorsCode.RESET + "\t\tUsername is : " + ConsoleColorsCode.GREEN_BOLD + managerDetail.getUsername() + ConsoleColorsCode.RESET
                    + "\t\tPassword is : " + ConsoleColorsCode.GREEN_BOLD + managerDetail.getPassword() + ConsoleColorsCode.RESET);

        }

    }

    public void viewManagerWithoutPassword() {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nManager List :" + ConsoleColorsCode.RESET);

        for (int i = 0; i < Company.managers.size(); i++) {
            System.out.println((i + 1) + ") " + Company.managers.get(i).getFirstName() + " " + Company.managers.get(i).getLastName()
                    + "\t-----> Number of emmployees responsible : " + Company.managers.get(i).getWhoIsResponsibleEmployees().size());

        }

    }

}
