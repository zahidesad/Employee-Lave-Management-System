package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Feedback {

    Scanner scan = new Scanner(System.in);

    //it is showing all employee names, available leaves and used leaves (Manager)
    public void viewEmployee(Manager manager) {
        for (Employee employee : Company.employees) {
            if (manager.getUsername().equalsIgnoreCase(employee.getManager().getUsername())) {
                System.out.println("Name and surname is : " + employee.getFirstName() + employee.getLastName()
                        + "\t\tAvailable Leaves : " + employee.getNumberOfLeavesLeft() + "\t\t Used Leaves : " + employee.getUsedLeave() + "\n");
            }

        }
    }

    //print all the leave requests of employee (CEO)
    public void emlpoyeeRequests() {
        for (Employee employee : Company.employees) {
            System.out.println("Name and surname is : " + employee.getFirstName() + employee.getLastName()
                    + "\t\tRequesting for " + employee.getNumberOfLeaveRequest() + " Days \n");
        }

    }

    //Confirmation for employee leave to be given or not (Manager)
    public void confirmationForLeave(Manager manager) {
        for (Employee responsbileEmployee : manager.getWhoIsResponsibleEmployees()) {
            if (responsbileEmployee.getNumberOfLeaveRequest() != 0) {
                System.out.println("Name is " + responsbileEmployee.getUsername()
                        + "\t\t Requesting for " + responsbileEmployee.getNumberOfLeaveRequest() + "\n");

                int a;
                System.out.println("Please Select the action you want to do : ");
                System.out.println("1.Confirm " + "\n" + "2.Reject" + "\n" + "3.Quit");
                a = scan.nextInt();

                switch (a) {
                    //if manager confirms the request
                    case 1:
                        int leave = responsbileEmployee.getNumberOfLeavesLeft();
                        int deduct = responsbileEmployee.getNumberOfLeaveRequest();
                        leave -= deduct;

                        responsbileEmployee.updateLeave(leave);
                        int used = responsbileEmployee.getUsedLeave();

                        responsbileEmployee.setUsedLeave(used);
                        System.out.println("Leaves granted.\n");
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println("Leaves Rejected.\n");
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
