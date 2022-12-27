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

    public int SummationOfAllLeaves() {
        int total = 0;

        for (Users user : Company.users) {
            if (user instanceof Employee) {
                Employee employee = (Employee) user;
                total += employee.getUsedLeave();
            }
        }
        return total;
    }

    //print all the leave viewLeaveRequests of manager (CEO)
    @Override
    public void viewLeaveRequests() {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                System.out.println("\n\nName and surname are : " + ConsoleColorsCode.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                        + " wants for " + manager.getNumberOfLeaveRequest() + " days leave" + "\n" + ConsoleColorsCode.RESET);
            }
        }
    }

    public void confirmationForManagerLeaves(CEO ceo) {
        for (Users user : Company.users) {
            if (user instanceof Manager) {
                Manager manager = (Manager) user;
                if (manager.getNumberOfLeaveRequest() != 0) {
                    System.out.println(ConsoleColorsCode.GREEN_BOLD + manager.getUsername()
                            + " wants for " + manager.getNumberOfLeaveRequest() + " days leave" + "\n" + ConsoleColorsCode.RESET);

                    int a;
                    System.out.println("Please Select the action you want to do : ");
                    System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                    System.out.println(ConsoleColorsCode.GREEN_BOLD +"\n\nYour Choice : " + ConsoleColorsCode.RESET);
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
    }

    public void viewEmployeeWithPassword() {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nEmployee List With Password :" + ConsoleColorsCode.RESET);

        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Employee && !(Company.users.get(i) instanceof Manager)) {
                Employee employee = (Employee) Company.users.get(i);
                System.out.println(ConsoleColorsCode.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                        + ConsoleColorsCode.RESET + "\t\tUsername is : " + ConsoleColorsCode.GREEN_BOLD + employee.getUsername() + ConsoleColorsCode.RESET
                        + "\t\tPassword is : " + ConsoleColorsCode.GREEN_BOLD + employee.getPassword() + ConsoleColorsCode.RESET);
            }
        }
    }

    public void viewManagerWithPassword() {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nManager List With Password :" + ConsoleColorsCode.RESET);

        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Manager) {
                Manager manager = (Manager) Company.users.get(i);
                System.out.println(ConsoleColorsCode.GREEN_BOLD + manager.getFirstName() + " " + manager.getLastName()
                        + ConsoleColorsCode.RESET + "\t\tUsername is : " + ConsoleColorsCode.GREEN_BOLD + manager.getUsername() + ConsoleColorsCode.RESET
                        + "\t\tPassword is : " + ConsoleColorsCode.GREEN_BOLD + manager.getPassword() + ConsoleColorsCode.RESET);

            }
        }
    }

    public void viewManagerWithoutPassword() {
        System.out.println(ConsoleColorsCode.BLUE_BOLD + "\n\nManager List :" + ConsoleColorsCode.RESET);
        int count=1;
        for (int i = 0; i < Company.users.size(); i++) {
            if (Company.users.get(i) instanceof Manager) {
                Manager manager = (Manager) Company.users.get(i);
                System.out.println((count + ") " + manager.getFirstName() + " " + manager.getLastName()
                        + "\t-----> Number of emmployees responsible : " + manager.getWhoIsResponsibleEmployees().size()));
                count++;
            }

        }

    }

}
