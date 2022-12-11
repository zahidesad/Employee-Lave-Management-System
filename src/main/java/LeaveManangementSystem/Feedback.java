package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Feedback {

    Scanner scan = new Scanner(System.in);
    private String managerUsername;
    private String managerPassword;

    public Feedback(String scanUsername, String scanPassword) {

        this.managerUsername = scanUsername;
        this.managerPassword = scanPassword;
    }

    public Feedback() {
    }

    //it is showing all employe names, available leaves and used leaves 
    public void viewEmployee(ArrayList<Employee> employeeDetails) {
        for (Employee getDetails : employeeDetails) {
            if (getManagerUsername().equalsIgnoreCase(getDetails.getManager().getUsername())) {
                System.out.println("Name and surname is : " + getDetails.getFirstName() + getDetails.getLastName()
                        + "\t\tAvailable Leaves : " + getDetails.getNumberOfLeavesLeft() + "\t\t Used Leaves : " + getDetails.getUsedLeave() + "\n");
            }

        }
    }

    //print all the leave requests of employee
    public void emlpoyeeRequests(ArrayList<Employee> employeeDetails) {
        for (Employee getDetails : employeeDetails) {
            System.out.println("Name and surname is : " + getDetails.getFirstName() + getDetails.getLastName()
                    + "\t\tRequesting for " + getDetails.getNumberOfLeaveRequest() + " Days \n");
        }

    }

    //Confirmation for employee leave to be given or not,
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
                        //responsbileEmployee.setTotalDayLeaveValue(0);
                        System.out.println("Leaves granted.\n");
                        break;

                    // if manager rejects request    
                    case 2:
                        System.out.println("Leaves Rejected.\n");
                        //responsbileEmployee.setTotalDayLeaveValue(0);
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

    //Start of encapsulation 
    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
    //End of encapsulation
}
