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
            System.out.println("\n\nName and surname is : " + manager.getFirstName() + manager.getLastName()
                    + "\t\tRequesting for " + manager.getNumberOfLeaveRequest() + " Days \n");
        }

    }

    public void confirmationForManagerLeaves(CEO ceo) {
        for (Manager manager : Company.managers) {
            if (manager.getNumberOfLeaveRequest() != 0) {
                System.out.println("Name is " + manager.getUsername()
                        + "\t\t Requesting for " + manager.getNumberOfLeaveRequest() + "\n");

                int a;
                System.out.println("Please Select the action you want to do : ");
                System.out.println("1.Confirm " + "\n" + "2.Reject" + "\n" + "3.Quit");
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
                        System.out.println("Leaves granted.\n");
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println("Leaves Rejected.\n");
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
                System.out.println("Name and surname are : " + employee.getFirstName() + " " + employee.getLastName()
                        + "\t\tAvailable Leaves : " + employee.getNumberOfLeavesLeft() + "\t\t Used Leaves : " + employee.getUsedLeave() + "\n");
            }

        }
    }

    //print all the leave requests of employee (Manager)
    public void emlpoyeeRequests() {
        for (Employee employee : Company.employees) {
            System.out.println("Name and surname are : " + employee.getFirstName()+ " " + employee.getLastName()
                    + "\t\tRequesting for " + employee.getNumberOfLeaveRequest() + " Days \n");
        }

    }

    //Confirmation for employee leave to be given or not (Manager)
    public void confirmationForEmployeeLeaves(Manager manager) {
        for (Employee responsbileEmployee : manager.getWhoIsResponsibleEmployees()) {
            if (responsbileEmployee.getNumberOfLeaveRequest() != 0) {
                System.out.println("Name and surname are " + responsbileEmployee.getFirstName()+" "+ responsbileEmployee.getLastName()
                        + "\t\t Requesting for " + responsbileEmployee.getNumberOfLeaveRequest() + "\n");

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
                        System.out.println("\n------Leaves granted.------\n");
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println("\n------Leaves Rejected.------\n");
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
