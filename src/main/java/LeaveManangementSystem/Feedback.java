package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Feedback {

    Scanner scan = new Scanner(System.in);

    //print all the leave requests of employee (CEO)
    public void ManagerRequests() {
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
                        System.out.println(ConsoleColorsCode.GREEN_BOLD+ "Leaves granted.\n" + ConsoleColorsCode.RESET);
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println(ConsoleColorsCode.RED_BOLD + "Leaves Rejected.\n" + ConsoleColorsCode.RESET);
                        manager.setNumberOfLeaveRequest(0);
                        break;

                    case 3:
                        System.out.println("Logging out from the system...");
                        break;
                    default:
                        break;

                }

            } else {
                continue;
            }

        }
    }

    //it is showing all employee names, available leaves and used leaves (Manager)
    public void viewEmployee(Manager manager) {
        for (Employee employee : Company.employees) {
            if (manager.getUsername().equalsIgnoreCase(employee.getManager().getUsername())) {
                System.out.println("Name and surname are : " + ConsoleColorsCode.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                        + ConsoleColorsCode.RESET + "\t\tAvailable Leaves : " + ConsoleColorsCode.GREEN_BOLD + employee.getNumberOfLeavesLeft() + ConsoleColorsCode.RESET
                        + "\t\t Used Leaves : " + ConsoleColorsCode.GREEN_BOLD + employee.getUsedLeave() + ConsoleColorsCode.RESET + "\n");
            }

        }
    }

    //print all the leave requests of employee (Manager)
    public void employeeRequests() {
        for (Employee employee : Company.employees) {
            System.out.println(ConsoleColorsCode.GREEN_BOLD + employee.getFirstName() + " " + employee.getLastName()
                    + " wants for " + employee.getNumberOfLeaveRequest() + " days leave" + ConsoleColorsCode.RESET + "\n");
        }

    }

    //Confirmation for employee leave to be given or not (Manager)
    public void confirmationForEmployeeLeaves(Manager manager) {
        for (Employee responsbileEmployee : manager.getWhoIsResponsibleEmployees()) {
            if (responsbileEmployee.getNumberOfLeaveRequest() != 0) {
                System.out.println(ConsoleColorsCode.GREEN_BOLD + responsbileEmployee.getFirstName() + " " + responsbileEmployee.getLastName()
                        + " wants for " + responsbileEmployee.getNumberOfLeaveRequest() + " days leave" + ConsoleColorsCode.RESET + "\n");

                int a;
                System.out.println("\n\nPlease Select the action you want to do : ");
                System.out.println("1)Confirm " + "\n" + "2)Reject" + "\n" + "3)Quit");
                a = scan.nextInt();

                switch (a) {
                    //if manager confirms the request
                    case 1:
                        int leave = responsbileEmployee.getNumberOfLeavesLeft();
                        int deduct = responsbileEmployee.getNumberOfLeaveRequest();
                        leave -= deduct;

                        responsbileEmployee.updateLeave(leave);
                        int used = responsbileEmployee.getUsedLeave() + responsbileEmployee.getNumberOfLeaveRequest();

                        responsbileEmployee.setUsedLeave(used);
                        responsbileEmployee.setNumberOfLeaveRequest(0);
                        System.out.println(ConsoleColorsCode.GREEN_BOLD+ "Leaves granted.\n" + ConsoleColorsCode.RESET);
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println(ConsoleColorsCode.RED_BOLD+ "Leaves Rejected.\n" + ConsoleColorsCode.RESET);
                        responsbileEmployee.setNumberOfLeaveRequest(0);
                        break;

                    case 3:
                        System.out.println("Logging out from the system...");
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
